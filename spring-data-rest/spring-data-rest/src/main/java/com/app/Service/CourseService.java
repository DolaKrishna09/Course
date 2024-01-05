package com.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dao.CourseRepository;
import com.app.entity.Courses;

@Service
public class CourseService {

	@Autowired
	CourseRepository repository;

	public List<Courses> getAllCoursesWithId() {
		return repository.findAll();
	}

	public List<Object[]> getAllCoursesWithoutId() {
		return repository.allCoursesWithoutId();
	}

	public List<Object[]> getCourseByCourseName(String courseName) {
		return repository.findByCOURSE_NAME(courseName);
	}

	public ResponseEntity<String> addCourse(Courses course) {
		repository.save(course);
		return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateCourse(Courses updatedCourse) {

		Optional<Courses> existingCourse = repository.findById(updatedCourse.getCourse_id());

		if (existingCourse.isPresent()) {

			Courses courseToUpdate = existingCourse.get();
			courseToUpdate.setCourse_name(updatedCourse.getCourse_name());
			courseToUpdate.setCourse_duration(updatedCourse.getCourse_duration());
			courseToUpdate.setStart_date(updatedCourse.getStart_date());
			courseToUpdate.setEnd_date(updatedCourse.getEnd_date());
			courseToUpdate.setAvailability(updatedCourse.getAvailability());
			courseToUpdate.setDetails(updatedCourse.getDetails());
			courseToUpdate.setCourse_prerequisites(updatedCourse.getCourse_prerequisites());
			courseToUpdate.setCourse_outcome(updatedCourse.getCourse_outcome());

			repository.save(courseToUpdate);
			return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
		} else {

			return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<String> deleteCourse(int courseId) {

		Optional<Courses> existingCourse = repository.findById(courseId);

		if (existingCourse.isPresent()) {

			repository.deleteById(courseId);
			return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
		} else {

			return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
		}
	}
}
