package com.ai.mini.pr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ai.mini.pr.model.RelationshipByEid;

public interface RelationshpByEidRepository extends JpaRepository<RelationshipByEid, Long>{
	
	@Query("select p from RelationshipByEid p where p.eid = :eid")
	List<RelationshipByEid> findAllByIdentityEid(@Param("eid") Long id);
}
