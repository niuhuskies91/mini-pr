package com.ai.mini.pr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.mini.pr.model.Local;
import com.ai.mini.pr.model.LocalIdentity;

public interface LocalRepository extends JpaRepository<Local, LocalIdentity>{

}
