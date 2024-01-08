package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.ExtractedData;

public interface ExtractedDataRepository extends JpaRepository<ExtractedData, Long> {
    // Any custom queries if needed
}

