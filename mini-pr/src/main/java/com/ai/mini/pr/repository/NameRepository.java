package com.ai.mini.pr.repository;

import com.ai.mini.pr.model.Name;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Name, Long> {

	public List<Name> findByEid(Long eid);
}
