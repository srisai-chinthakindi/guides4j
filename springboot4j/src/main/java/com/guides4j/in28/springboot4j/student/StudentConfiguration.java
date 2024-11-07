package com.guides4j.in28.springboot4j.student;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


// though it is not mandatory to use the prefix but to avoid the Conflicts we use prefix
// Custom Configuration via profiles and ConfigProperties



@ConfigurationProperties(prefix = "settings.student")
@Component
public class StudentConfiguration {
	
	private String quota;
	
	private String university;
//	If we try to use the Constructor 

//	StudentConfiguration is annotated with @ConstructorBinding but it is defined as a regular bean which caused dependency injection to fail.

//	public StudentConfiguration(String quota, String university) {
//		super();
//		this.quota = "default quota";
//		this.university = "default Universty";
//	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}
	
	
}
