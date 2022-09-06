package com.jarshope.course.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarshope.course.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
