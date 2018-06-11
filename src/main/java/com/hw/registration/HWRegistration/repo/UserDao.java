package com.hw.registration.HWRegistration.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hw.registration.HWRegistration.entity.Users;



@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	EntityManager em;
	

	public void addUser(Users p) {
		System.out.println(p);
		em.merge(p);
	}
}