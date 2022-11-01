package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.user;

public interface userRepository extends JpaRepository<user, Long>, JpaSpecificationExecutor<user> {
  user findById(long id);

}
