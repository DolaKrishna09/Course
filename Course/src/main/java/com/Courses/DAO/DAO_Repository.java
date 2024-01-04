package com.Courses.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Courses.Entities.COURSE_DETAILS;

@RepositoryRestResource
public interface DAO_Repository extends JpaRepository<COURSE_DETAILS, Integer> {
    
    @Query(value="select e from COURSE_DETAILS e")
    public Iterable<COURSE_DETAILS> allCourses();
}
