package com.Courses.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Courses.DAO.DAO_Repository;
import com.Courses.Entities.COURSE_DETAILS;

@RestController 
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private DAO_Repository repository;
	
	
	@GetMapping("/allcourses")
	public Iterable<COURSE_DETAILS> allCourses(){
		return repository.allCourses();
	}
	
	
    
   
}
