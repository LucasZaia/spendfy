package com.spendfy.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spendfy.api.models.User;

public interface UserRepository extends JpaRepository<User, Long>  {}
