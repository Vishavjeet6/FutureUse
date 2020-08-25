package com.nagarro.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.Demo.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
	
}
