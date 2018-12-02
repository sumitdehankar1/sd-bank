package com.example.sdBank.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sdBank.entity.Banks;

@Repository
public interface BankRepository extends CrudRepository<Banks,Integer>{
	
	@Query("select id from Banks where name=:bankName")
	Integer getIdByName(@Param("bankName") String bankName);
	
}