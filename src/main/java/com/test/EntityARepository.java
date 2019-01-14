package com.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EntityARepository extends JpaRepository<EntityA, Long> {

	@Transactional(readOnly = true)
	EntityA findByBsName(String name);
}
