package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.Courses;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Courses, Integer> {
	
	@Query(value = "SELECT COURSE_NAME, COURSE_DURATION, START_DATE, END_DATE, AVAILABILITY FROM Courses", nativeQuery = true)
	public List<Object[]> allCoursesWithoutId();
	
	
	 @Query(value = "SELECT COURSE_NAME, COURSE_DURATION, START_DATE, END_DATE, AVAILABILITY FROM Courses WHERE COURSE_NAME = :courseName", nativeQuery = true)
	    List<Object[]> findByCOURSE_NAME( String courseName);
	    
	    
	 
	
}
