package com.test;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class EntityA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "a", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EntityB> bs;
	
	@Version
	@Column(nullable = false)
	private long version;
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<EntityB> getBs() {
		return bs;
	}
	
	public EntityB getB(String name) {
		for(EntityB b : bs) {
			if(b.getName().equals(name)) {
				return b;
			}
		}
		return null;
	}
	
	public boolean addB(EntityB b) {
		for(EntityB _b : bs) {
			if(_b.getName().equals(b.getName())) {
				throw new IllegalArgumentException();
			}
		}
		boolean added = bs.add(b);
		if(added)
			b.setA(this);
		return added;
	}
	
	public long getVersion() {
		return version;
	}
	
	EntityA() {

	}
}
