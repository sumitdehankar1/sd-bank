
package com.example.sdBank.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sdBank.entity.Branches;

@Repository
public interface BranchRepository extends CrudRepository<Branches,String>{
	@Query("Select br from Branches br where city=:city and br.bankId=:id")
	List<Branches> getBranchesByCity(@Param("id")Integer id,@Param("city") String city);

}




