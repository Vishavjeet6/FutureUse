package com.nagarro.Course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.Course.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
	
}
