package com.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dao.StudentsDetailsRepository;
import com.app.entity.Courses;
import com.app.entity.StudentsDetails;

@Service
public class StudentsDetailsService {

	@Autowired
	StudentsDetailsRepository studentsdetailsrepository;

	public List<StudentsDetails>allStudentsDetails(){
		return studentsdetailsrepository.findAll();
	}
	
	
	public ResponseEntity<String> addStudentsDetails(StudentsDetails studentdetails) {
		studentsdetailsrepository.save(studentdetails);
		return new ResponseEntity<>("StudentDetails added successfully", HttpStatus.CREATED);
	}


//	public ResponseEntity<String> updateStudentsDetails(StudentsDetails studentdetails) {
//
//		Optional<Courses> existingCourse = studentdetails.findById(studentdetails.getSNo());
//
//		if (existingCourse.isPresent()) {
//
//			Courses courseToUpdate = existingCourse.get();
//			courseToUpdate.setCourse_name(studentdetails.getStudentId());
//			courseToUpdate.setCourse_duration(studentdetails.getStudentName());
//			courseToUpdate.setStart_date(studentdetails.);
//			courseToUpdate.setEnd_date(studentdetails.getEnd_date());
//			courseToUpdate.setAvailability(studentdetails.getAvailability());
//			courseToUpdate.setDetails(studentdetails.getDetails());
//			courseToUpdate.setCourse_prerequisites(studentdetails.getCourse_prerequisites());
//			courseToUpdate.setCourse_outcome(studentdetails.getCourse_outcome());
//
//			repository.save(courseToUpdate);
//			return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
//		} else {
//
//			return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
//		}
//	}

}
