package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.ModuleEntity;

@RepositoryRestResource
public interface ModulesRepository extends JpaRepository<ModuleEntity, Integer> {

    
    @Query("SELECT m.video FROM ModuleEntity m")
    public List<byte[]> findVideosWithoutId();
    

    @Query(value = "SELECT COURSE_NAME, MODULE_NAME, NOTES, VIDEO FROM MODULE_ENTITY", nativeQuery = true)
    List<Object[]> myLearningsData();
}
