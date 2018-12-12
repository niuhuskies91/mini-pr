package com.ai.mini.pr.repository;

import com.ai.mini.pr.model.Address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

	public List<Address> findByEid(Long eid);
}
