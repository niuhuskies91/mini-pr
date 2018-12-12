package com.ai.mini.pr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.mini.pr.model.RelationshipByMrn;
import com.ai.mini.pr.model.RelationshipByMrnIdentity;

public interface RelationshpByMrnRepository extends JpaRepository<RelationshipByMrn, RelationshipByMrnIdentity>{
	
}
