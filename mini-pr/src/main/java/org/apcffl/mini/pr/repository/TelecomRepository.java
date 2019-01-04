package org.apcffl.mini.pr.repository;

import java.util.List;

import org.apcffl.mini.pr.model.Telecom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelecomRepository extends JpaRepository<Telecom, Long> {

	public List<Telecom> findByEid(Long eid);
}
