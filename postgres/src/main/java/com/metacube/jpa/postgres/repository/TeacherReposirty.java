package com.metacube.jpa.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.metacube.jpa.postgres.model.Teacher;

@Repository("teacherRepositry")
public interface TeacherReposirty extends JpaRepository<Teacher, Long>, QuerydslPredicateExecutor<Teacher>{

}
