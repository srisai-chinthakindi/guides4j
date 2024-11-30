package com.guides4j.aesilesapi.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AesilerPost {
	
	@Id
	@GeneratedValue
	private Long post_id;

	private String post_description;
	
	private LocalDateTime post_dated_details;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="aesiler_id")
	@JsonIgnore
	private Aesiler aesiler;

	public AesilerPost() {
		
	}
	
	public AesilerPost(Long post_id, String post_description, LocalDateTime post_dated_details, Aesiler aesiler) {
		super();
		this.post_id = post_id;
		this.post_description = post_description;
		this.post_dated_details = post_dated_details;
		this.aesiler = aesiler;
	}


	public Long getPost_id() {
		return post_id;
	}
	
	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}
	

	public String getPost_description() {
		return post_description;
	}

	public void setPost_description(String post_description) {
		this.post_description = post_description;
	}

	public LocalDateTime getPost_dated_details() {
		return post_dated_details;
	}

	public void setPost_dated_details(LocalDateTime post_dated_details) {
		this.post_dated_details = post_dated_details;
	}
	
	public Aesiler getAesiler() {
		return aesiler;
	}
	public void setAesiler(Aesiler aesiler) {
		this.aesiler = aesiler;
	}

	
	
	

}
