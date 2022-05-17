package com.zensar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.InterviewEntity;

public interface InterviewRepo extends JpaRepository<InterviewEntity, Integer> {

}
