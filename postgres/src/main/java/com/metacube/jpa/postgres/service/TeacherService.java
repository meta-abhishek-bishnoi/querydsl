 package com.metacube.jpa.postgres.service;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Optional;

 import javax.persistence.EntityManager;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import com.metacube.jpa.postgres.exception.RecordNotFoundException;
 import com.metacube.jpa.postgres.model.Teacher;
 import com.metacube.jpa.postgres.model.QTeacher;
 import com.metacube.jpa.postgres.model.pojo.TeacherDetails;
 import com.metacube.jpa.postgres.model.pojo.TeacherPojo;
 import com.metacube.jpa.postgres.repository.DepartmentReposirty;
 import com.metacube.jpa.postgres.repository.TeacherReposirty;
 import com.querydsl.core.types.Projections;
 import com.querydsl.jpa.JPAQueryBase;
 import com.querydsl.jpa.impl.JPAQuery;

 @Service
 @Transactional
 public class TeacherService {
 	@Autowired
 	TeacherReposirty repository;
 	@Autowired
 	DepartmentReposirty departRepo;
 	@Autowired
 	private EntityManager entityManager;

 	public List<TeacherPojo> getAllTeachers() {
 		QTeacher qteacher = QTeacher.teacher;
 		JPAQueryBase query = new JPAQuery(entityManager).select(
 						Projections.bean(TeacherPojo.class,
 								qteacher.id.as("id"), qteacher.name.as("name"),
 								qteacher.email.as("email"), qteacher.address.as("address"),
 								qteacher.department.id.as("deptId")
 								)
 						).
 				from(qteacher);
 		List<TeacherPojo> listTeachers = query.fetch();
 		if (listTeachers.size() > 0) {
 			return listTeachers;
 		} else {
 			return new ArrayList<TeacherPojo>();
 		}
 	}

 	public Teacher getTeacherById(Long id) throws RecordNotFoundException {
 		Optional<Teacher> teacher = repository.findById(id);
 		if (teacher.isPresent()) {
 			return teacher.get();
 		} else {
 			throw new RecordNotFoundException("No Teacher record exist for given id", id);
 		}
 	}

 	public Teacher createOrUpdateTeacher(Teacher entity) throws RecordNotFoundException {
 		if (entity.getId() != null) {
 			Optional<Teacher> teacher = repository.findById(entity.getId());

 			if (teacher.isPresent()) {
 				Teacher newEntity = teacher.get();
 				newEntity.setName(entity.getName());
 				newEntity.setEmail(entity.getEmail());
 				newEntity.setAddress(entity.getAddress());
 				newEntity.setDepartmentId(entity.getDepartmentId());
 				newEntity = repository.save(newEntity);

 				return newEntity;
 			} else {
 				entity = repository.save(entity);

 				return entity;
 			}
 		}

 		else {
 			entity = repository.save(entity);
 			return repository.save(entity);
 		}
 	}

 	public void deleteTeacherById(Long id) throws RecordNotFoundException {
 		Optional<Teacher> student = repository.findById(id);

 		if (student.isPresent()) {
 			repository.deleteById(id);
 		} else {
 			throw new RecordNotFoundException("No teacher record exist for given id", id);
 		}
 	}
 }
