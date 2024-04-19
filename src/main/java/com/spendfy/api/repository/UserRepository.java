package com.spendfy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spendfy.api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
