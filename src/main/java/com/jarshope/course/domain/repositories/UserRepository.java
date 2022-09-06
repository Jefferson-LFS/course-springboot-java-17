package com.jarshope.course.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarshope.course.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
