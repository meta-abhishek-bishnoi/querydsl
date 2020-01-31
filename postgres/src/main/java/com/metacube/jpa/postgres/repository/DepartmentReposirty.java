package com.metacube.jpa.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.metacube.jpa.postgres.model.Department;

@Repository("departmentRepositry")
public interface DepartmentReposirty extends JpaRepository<Department, Long>, QuerydslPredicateExecutor<Department> {

}
