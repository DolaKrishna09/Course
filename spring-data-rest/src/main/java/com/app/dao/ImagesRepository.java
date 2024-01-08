package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.ImagesEntity;

public interface ImagesRepository extends JpaRepository<ImagesEntity, Integer> {

    @Query(value = "SELECT image FROM ImagesEntity")
    public List<byte[]> getImageWithoutId();
}
