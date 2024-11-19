package com.guides4j.learnspringdata.jpa;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class JpaRepo {

	@PersistenceContext
	private EntityManager enityManager;
	
	public void insertCourse(Course course) {
		enityManager.merge(course);
	}
	
	public Course findCourseById(long id) {
		return enityManager.find(Course.class,id);
	}
	
	public void deleteCourseById(long id) {
		enityManager.remove(enityManager.find(Course.class, id));
	}
}
