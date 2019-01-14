package com.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
class EntityB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "a_id")
	private EntityA a;
	
	@Column(unique = true)
	private String name;
	
	public Long getId() {
		return id;
	}
	
	public EntityA getA() {
		return a;
	}
	
	void setA(EntityA a) {
		this.a = a;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	EntityB() {

	}

	public EntityB(String name) {
		this.name = name;
	}
}
