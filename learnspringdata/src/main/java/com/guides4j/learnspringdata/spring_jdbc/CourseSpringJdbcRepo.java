package com.guides4j.learnspringdata.spring_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseSpringJdbcRepo {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY = """
			INSERT INTO course (id,name,author) values(?,?,?);
			""";

	private static String SELECT_QUERY = """
			  SELECT * from course where id = ?;
			""";

	private static String DELETE_QUERY = """
			DELETE from course where id = ?;
			""";

	public void insertCourse(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteCourse(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);
	}

	public Course findById(int i) {
		// TODO Auto-generated method stub
		return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),i);
	}
}
