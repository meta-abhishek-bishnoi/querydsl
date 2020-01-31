 package com.metacube.jpa.postgres.service;

 import javax.persistence.EntityManager;

 import org.springframework.beans.factory.annotation.Autowired;

 import com.querydsl.core.types.EntityPath;
 import com.querydsl.jpa.JPAQueryBase;
 import com.querydsl.jpa.impl.JPAQuery;

 public class AbstractService {
 	@Autowired
 	private EntityManager entityManager;
	
 	protected JPAQueryBase from(EntityPath<?> ... paths) {
 		return new JPAQuery(entityManager).from(paths);
 	}
	
 	public void setEntityManager(EntityManager entityManager) {
 		this.entityManager = entityManager;
 	}
 }
