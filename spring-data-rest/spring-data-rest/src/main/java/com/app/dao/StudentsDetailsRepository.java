package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.StudentsDetails;

@RepositoryRestResource
public interface StudentsDetailsRepository extends JpaRepository<StudentsDetails, Integer>{
	
	
	
}
