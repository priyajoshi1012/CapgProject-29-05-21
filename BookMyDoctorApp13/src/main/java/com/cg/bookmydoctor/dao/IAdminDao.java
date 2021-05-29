package com.cg.bookmydoctor.dao;

import java.util.List;    

import com.cg.bookmydoctor.dto.Admin;
import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository;


@Repository
public interface IAdminDao extends CrudRepository<Admin, Integer> {


	//public Admin addAdmin(Admin admin);
//	public Admin updateAdmin(Admin admin);
	//public Admin removeAdmin(Admin admin);
//	public Admin viewAdmin(Admin admin);
	
}