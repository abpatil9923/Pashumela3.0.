package com.pashumela.authenticationservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pashumela.authenticationservice.entities.User;

@Repository
public interface ManageUserRepository extends JpaRepository<User, Long>{

	public User findUserByMobileNumber(String mobileNumber);
}
