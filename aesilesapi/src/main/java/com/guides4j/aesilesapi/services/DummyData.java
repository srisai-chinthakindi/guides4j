package com.guides4j.aesilesapi.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guides4j.aesilesapi.models.Aesiler;
import com.guides4j.aesilesapi.models.AesilerPost;
import com.guides4j.aesilesapi.repos.AesilerPostRepo;
import com.guides4j.aesilesapi.repos.AesilerRepo;

@Service
public class DummyData {

	@Autowired
	AesilerRepo aesilerRepo;

	@Autowired
	AesilerPostRepo aesilerPostRepo;

	public void userInit() {
		List<Aesiler> default_user = new ArrayList<>();
		List<AesilerPost> user_posts = new ArrayList<>();
		
		default_user.add(new Aesiler(1l,"Gopi","Admin"));
		user_posts.add(new AesilerPost(1l,"My First post",LocalDateTime.now(),default_user.get(0)));
		user_posts.add(new AesilerPost(2l,"My Second post",LocalDateTime.now(),default_user.get(0)));
		
		default_user.add(new Aesiler(2l,"Krish","RollNo 21"));
		user_posts.add(new AesilerPost(3l,"Krish Post",LocalDateTime.now(),default_user.get(1)));
		
		default_user.add(new Aesiler(3l,"srisai chinthakindi","Dev"));
		aesilerRepo.saveAll(default_user);	
		aesilerPostRepo.saveAll(user_posts);
	}


}
