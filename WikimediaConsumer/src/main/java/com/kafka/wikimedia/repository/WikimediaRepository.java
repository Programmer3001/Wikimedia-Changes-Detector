package com.kafka.wikimedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.wikimedia.entity.WikimediaEntity;


public interface WikimediaRepository extends JpaRepository<WikimediaEntity, Long> {
}
