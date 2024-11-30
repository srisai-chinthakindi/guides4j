package com.guides4j.aesilesapi.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Aesiler {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Size(min = 2, message = "user name must contains atleast 2 characters")
	@NotNull
	private String user_name;

	private String bio;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime created_at;

	@OneToMany(mappedBy = "aesiler")
	@JsonIgnore
	List<AesilerPost> user_posts;

	public Aesiler() {

	}

	@Size(min = 2, message = "user name must contains atleast 2 characters")
	public Aesiler(Long id, String user_name, String bio) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.bio = bio;
		this.created_at = LocalDateTime.now();
	}

	public Long getId() {
		return this.id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}


	public List<AesilerPost> getUser_posts() {
		return user_posts;
	}

	public void setUser_posts(List<AesilerPost> user_posts) {
		this.user_posts = user_posts;
	}
	

	@Override
	public String toString() {
		return "Aesiler [Id=" + id + ", user_name=" + user_name + ", bio=" + bio + ", created_at=" + created_at + "]";
	}

}
