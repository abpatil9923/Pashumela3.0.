package com.pashumela.authenticationservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pashumela.authenticationservice.entities.Address;

@Repository
public interface ManagerAddressReporsitory extends JpaRepository<Address, Long> {

}
