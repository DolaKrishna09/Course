package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.app.Service.StudentsDetailsService;
import com.app.entity.Courses;
import com.app.entity.StudentsDetails;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	CourseService courseService;

	@Autowired
	StudentsDetailsService studentsdetailsservice;

	// FOR ADDING COURSE
	@PostMapping("/addCourse")
	public ResponseEntity<String> addCourses(@RequestBody Courses course) {
		return courseService.addCourse(course);

	}

	// FETCHING COURSES WITH ID
	@GetMapping("/allCoursesWithId")
	public List<Courses> allCoursesWithId() {
		return courseService.getAllCoursesWithId();

	};

	// FETCHING COURSES WITHOUT ID
	@GetMapping("/allCoursesWithoutId")
	public List<Object[]> allCoursesWithoutId() {
		return courseService.getAllCoursesWithoutId();

	};

	// UPDATE COURSE
	@PutMapping("/updateCourse")
	public ResponseEntity<String> updateCourse(@RequestBody Courses updatedCourse) {
		return courseService.updateCourse(updatedCourse);
	}

	// DELETE COURSE ACCORDING TO ID
	@DeleteMapping("/deleteCourse/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable int courseId) {
		return courseService.deleteCourse(courseId);
	}

	// -------------------------------------------------------------------------------------------------//

	

	// FOR ADDING STUDENT_DETAILS
	@PostMapping("/addStudentsDetails")
	public ResponseEntity<String> addStudentsDetails(@RequestBody StudentsDetails studentdetails) {
		return studentsdetailsservice.addStudentsDetails(studentdetails);

	}
	
	// COURSE BUYED STUDENTS
	@GetMapping("/allStudentsDetails")
	public List<StudentsDetails> getAllStudentsDetails() {
		return studentsdetailsservice.allStudentsDetails();
	}
//
//	// UPDATE COURSE
//	@PutMapping("/updateStudentDetails")
//	public ResponseEntity<String> updateStudentsDetails(@RequestBody StudentsDetails Studentdetails) {
//		return courseService.updateStudentsDetails(Studentdetails);
//	}
//
//	// DELETE COURSE ACCORDING TO ID
//	@DeleteMapping("/deleteCourse/{courseId}")
//	public ResponseEntity<String> deleteCourse(@PathVariable int courseId) {
//		return courseService.deleteCourse(courseId);
//	}
//	

}
