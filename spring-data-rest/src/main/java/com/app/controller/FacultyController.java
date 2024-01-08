package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.CourseService;
import com.app.entity.Courses;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	
	
	@Autowired
	CourseService courseService;

	@PostMapping("/addCourse")
	public ResponseEntity<String> addCourses(@RequestBody Courses course) {
		return courseService.addCourse(course);

	}

	@GetMapping("/allCoursesWithId")
	public List<Courses> allCoursesWithId() {
		return courseService.getAllCoursesWithId();

	};

	@GetMapping("/allCoursesWithoutId")
	public List<Object[]> allCoursesWithoutId() {
		return courseService.getAllCoursesWithoutId();

	};

	@PutMapping("/updateCourse")
	public ResponseEntity<String> updateCourse(@RequestBody Courses updatedCourse) {
		return courseService.updateCourse(updatedCourse);
	}

	@DeleteMapping("/deleteCourse/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable int courseId) {
		return courseService.deleteCourse(courseId);
	}

}
