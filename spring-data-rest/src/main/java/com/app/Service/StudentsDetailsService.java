package com.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dao.StudentsDetailsRepository;
import com.app.entity.StudentsDetails;

@Service
public class StudentsDetailsService {

    @Autowired
    private StudentsDetailsRepository studentsDetailsRepository;

    public List<StudentsDetails> allStudentsDetails() {
        return studentsDetailsRepository.findAll();
    }


    public ResponseEntity<String> addStudentsDetails(StudentsDetails studentsDetails) {
        studentsDetailsRepository.save(studentsDetails);
        return new ResponseEntity<>("StudentDetails added successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateStudentsDetails(StudentsDetails studentsDetails) {
        Optional<StudentsDetails> existingStudent = studentsDetailsRepository.findById(studentsDetails.getSNo());

        if (existingStudent.isPresent()) {
            StudentsDetails studentToUpdate = existingStudent.get();
            studentToUpdate.setStudentId(studentsDetails.getStudentId());
            studentToUpdate.setStudentName(studentsDetails.getStudentName());
            studentToUpdate.setCourses(studentsDetails.getCourses());

            studentsDetailsRepository.save(studentToUpdate);
            return new ResponseEntity<>("Student Details updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student Details not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteStudentDetails(int studentId) {
        Optional<StudentsDetails> existingStudent = studentsDetailsRepository.findById(studentId);

        if (existingStudent.isPresent()) {
            try {
                studentsDetailsRepository.deleteById(studentId);
                return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
            } catch (Exception e) {
             
                return new ResponseEntity<>("Error deleting student", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
}
