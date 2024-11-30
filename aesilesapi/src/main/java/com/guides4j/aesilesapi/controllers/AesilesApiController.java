package com.guides4j.aesilesapi.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guides4j.aesilesapi.exceptions.UserNotFoundException;
import com.guides4j.aesilesapi.models.Aesiler;
import com.guides4j.aesilesapi.models.AesilerPost;
import com.guides4j.aesilesapi.repos.AesilerPostRepo;
import com.guides4j.aesilesapi.repos.AesilerRepo;

import jakarta.validation.Valid;

@RestController
public class AesilesApiController {
	
	AesilerRepo aesilerRepo;
	
	AesilerPostRepo aesilerPostRepo;
	

	protected AesilesApiController(AesilerRepo aesilerRepo,AesilerPostRepo aesilerPostRepo) {
		this.aesilerRepo = aesilerRepo;
		this.aesilerPostRepo = aesilerPostRepo;
	}
	
	@GetMapping("/users")
	public List<Aesiler> getAllAesilers(){
		return aesilerRepo.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public EntityModel<Aesiler> getAesilerInfoById(@PathVariable Long id) {
		Aesiler user = checkAndGetUser(id);
		
		EntityModel<Aesiler> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = WebMvcLinkBuilder
									.linkTo(WebMvcLinkBuilder.methodOn(getClass()).getAllAesilers());
		
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}

	private Aesiler checkAndGetUser(Long id) {
		Optional<Aesiler> user = aesilerRepo.findById(id);
		if(user.isEmpty())	throw new UserNotFoundException("user with id:"+id +"not Found");
		return user.get();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Aesiler> addAesiler(@RequestBody @Valid Aesiler aesiler){
		aesiler.setCreated_at(LocalDateTime.now());
		Aesiler aesile_user = aesilerRepo.save(aesiler);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(aesile_user.getId())
							.toUri();
		
		return ResponseEntity.created(location).build();
 	
	}
	
	@GetMapping("/users/{id}/posts")
	public List<AesilerPost> getAesilerPost(@PathVariable long id){
		Aesiler user = checkAndGetUser(id);
		return user.getUser_posts();
	}
	
	@GetMapping("/users/{id}/posts/{post_id}")
	public EntityModel<AesilerPost> getAesilerPost(@PathVariable long id,@PathVariable long post_id){
		Aesiler user = checkAndGetUser(id);
		AesilerPost post = user.getUser_posts()
							   .stream()
							   .filter( p -> p.getPost_id() == post_id)
							   .findFirst().get();
		
		EntityModel<AesilerPost> entityModel = EntityModel.of(post);
		WebMvcLinkBuilder link = WebMvcLinkBuilder
									.linkTo(WebMvcLinkBuilder.methodOn(getClass()).getAesilerPost(id));
		
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> addAesilerPost(@Valid @RequestBody AesilerPost aesilerPost,@PathVariable long id) {
		Aesiler user = checkAndGetUser(id);
		
		aesilerPost.setAesiler(user);
		aesilerPost.setPost_dated_details(LocalDateTime.now());
		
		AesilerPost savedpost = aesilerPostRepo.save(aesilerPost);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedpost.getPost_id())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
		
	}
	
	
	
	
}
