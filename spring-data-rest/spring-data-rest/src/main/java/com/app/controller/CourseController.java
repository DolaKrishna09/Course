package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.CourseService;
import com.app.dao.CourseRepository;
import com.app.entity.Courses;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	CourseService courseservice;

	@GetMapping("/allCoursesWithId")
	public List<Courses> allCoursesWithId() {
		return courseservice.getAllCoursesWithId();

	};

	@GetMapping("/allCoursesWithoutId")
	public List<Object[]> allCoursesWithoutId() {
		return courseservice.getAllCoursesWithoutId();

	};

	@GetMapping("/SearchByCoursename/{coursename}")
	public List<Object[]> getCoursesByCourseName(@PathVariable String coursename) {
		return courseservice.getCourseByCourseName(coursename);
	}
	
	

}
