package com.test;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private EntityARepository repository;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void doSomeWork() {
		EntityA a2 = repository.findByBsName("name2");
		if(a2 != null) {
			EntityB b = a2.getB("name2");
			b.setName("name_dummy");
			repository.save(a2);
		}
		
		Optional<EntityA> a1 = repository.findById(1L);
		a1.get().addB(new EntityB("name2"));
		repository.save(a1.get());
	}
}
