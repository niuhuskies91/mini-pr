package org.apcffl.mini.pr.repository;

import java.util.List;

import org.apcffl.mini.pr.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

	public List<Address> findByEid(Long eid);
}
