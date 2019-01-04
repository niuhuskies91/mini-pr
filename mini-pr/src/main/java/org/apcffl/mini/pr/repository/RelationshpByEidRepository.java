package org.apcffl.mini.pr.repository;

import java.util.List;

import org.apcffl.mini.pr.model.RelationshipByEid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RelationshpByEidRepository extends JpaRepository<RelationshipByEid, Long>{
	
	@Query("select p from RelationshipByEid p where p.eid = :eid")
	List<RelationshipByEid> findAllByIdentityEid(@Param("eid") Long id);
}
