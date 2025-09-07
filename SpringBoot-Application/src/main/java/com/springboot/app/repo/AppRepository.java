package com.springboot.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entity.UserEntity;

@Repository
public interface AppRepository extends JpaRepository<UserEntity, Long> {

}
