package com.hw.registration.HWRegistration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hw.registration.HWRegistration.entity.Users;


public interface UserRepository extends JpaRepository<Users, Integer> {

}
