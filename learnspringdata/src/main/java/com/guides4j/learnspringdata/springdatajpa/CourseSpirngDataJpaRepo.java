package com.guides4j.learnspringdata.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guides4j.learnspringdata.springdatajpa.courseSpringDataJPA;

 
public interface CourseSpirngDataJpaRepo extends JpaRepository<courseSpringDataJPA, Long>{

 List<CourseSpirngDataJpaRepo> findByName(String name);
}
