package org.apcffl.mini.pr.repository;

import java.util.List;

import org.apcffl.mini.pr.model.Demographics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemographicsRepository extends JpaRepository<Demographics, Long> {

	public List<Demographics> findByEid(Long eid);
}
