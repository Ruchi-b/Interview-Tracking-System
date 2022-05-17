package com.zensar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.CandidatesEntity;

public interface CandidateRepo extends JpaRepository<CandidatesEntity, Integer> {

}
