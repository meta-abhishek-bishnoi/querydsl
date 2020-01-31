 package com.metacube.jpa.postgres.service;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Optional;

 import javax.persistence.EntityManager;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import com.metacube.jpa.postgres.exception.RecordNotFoundException;
 import com.metacube.jpa.postgres.model.Department;
 import com.metacube.jpa.postgres.model.QDepartment;
 import com.metacube.jpa.postgres.model.QTeacher;
 import com.metacube.jpa.postgres.model.Teacher;
 import com.metacube.jpa.postgres.model.pojo.DepartmentPojo;
 import com.metacube.jpa.postgres.model.pojo.TeacherDetails;
 import com.metacube.jpa.postgres.model.pojo.TeacherPojo;
 import com.metacube.jpa.postgres.repository.DepartmentReposirty;
 import com.querydsl.core.types.Projections;
 import com.querydsl.jpa.JPAQueryBase;
 import com.querydsl.jpa.impl.JPAQuery;

 @Service
 @Transactional
 public class DepartmentService extends AbstractService {
 	@Autowired
 	DepartmentReposirty repository;
 	@Autowired
 	private EntityManager entityManager;

 	/**
 	 *
 	 */

 	public List<DepartmentPojo> getAllDepartments()
     {
 		QDepartment qdepartment = QDepartment.department;
 		JPAQueryBase query = new JPAQuery(entityManager).select(
 				Projections.bean(DepartmentPojo.class,
 						qdepartment.id.as("id"), qdepartment.name.as("name"),
 						qdepartment.description.as("description")
 						)
 				).from(qdepartment);
 		List<DepartmentPojo> listDepartments = query.fetch();
 		if (listDepartments.size() > 0) {
 			return listDepartments;
 		} else {
 			return new ArrayList<DepartmentPojo>();
 		}
     }

 	public DepartmentPojo getDepartmentById(Long id) throws RecordNotFoundException {
 		Optional<Department> department = repository.findById(id);

 		if (department.isPresent()) {
 			Department dept = department.get();
 			return new DepartmentPojo(dept.getId(), dept.getName(), dept.getDescription());
 		} else {
 			throw new RecordNotFoundException("No Department record exist for given id", id);
 		}
 	}

 	public Department createOrUpdateDepartment(Department entity) throws RecordNotFoundException {

 		if (entity.getId() != null) {
 			Optional<Department> department = repository.findById(entity.getId());

 			if (department.isPresent()) {
 				Department newEntity = department.get();
 				newEntity.setName(entity.getName());
 				newEntity.setDescription(entity.getDescription());
 				newEntity = repository.save(newEntity);

 				return newEntity;
 			} else {
 				entity = repository.save(entity);

 				return entity;
 			}
 		}

 		else {
 			entity = repository.save(entity);
 			return entity;
 		}
 	}

 	public void deleteDepartmentById(Long id) throws RecordNotFoundException {
 		Optional<Department> student = repository.findById(id);

 		if (student.isPresent()) {
 			repository.deleteById(id);
 		} else {
 			throw new RecordNotFoundException("No department record exist for given id", id);
 		}
 	}

 	/**
 	 * This Function Is used for
 	 *
 	 * @return
 	 */
 	public List<TeacherDetails> getTeachersListOfDepartment() {
 		QDepartment qdepartment = QDepartment.department;
 		QTeacher qteacher = QTeacher.teacher;
 		JPAQueryBase query = new JPAQuery(entityManager)
 				.select(Projections.bean(TeacherDetails.class, qteacher.id.as("teacherId"),
 						qteacher.name.as("teacherName"), qteacher.email.as("email"), qteacher.address.as("address"),
 						qteacher.department.id.as("departmentId"), qteacher.department.name.as("departmentName")))
 				.from(qteacher);
 		query.leftJoin(qteacher.department, qdepartment);
 		// query.on(qteacher.teacher.deptId.eq(qdepartment.department.id));
 		List<TeacherDetails> listTeachers = query.fetch();
 		return listTeachers;
 	}
 }
