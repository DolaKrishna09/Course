package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Integer>{

}
