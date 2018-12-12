package com.ai.mini.pr.repository;

import com.ai.mini.pr.model.Demographics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemographicsRepository extends JpaRepository<Demographics, Long> {

	public List<Demographics> findByEid(Long eid);
}
