package org.apcffl.mini.pr.repository;

import java.util.List;

import org.apcffl.mini.pr.model.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Name, Long> {

	public List<Name> findByEid(Long eid);
}
