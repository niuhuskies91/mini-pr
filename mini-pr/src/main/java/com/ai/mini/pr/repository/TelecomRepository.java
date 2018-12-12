package com.ai.mini.pr.repository;

import com.ai.mini.pr.model.Telecom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelecomRepository extends JpaRepository<Telecom, Long> {

	public List<Telecom> findByEid(Long eid);
}
