package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, String>{

}
