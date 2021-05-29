package com.cg.bookmydoctor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.service.AdminServiceImpl;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminservice ;
	
    //working
   	@GetMapping("/viewAdmin/{adminId}")
	@ExceptionHandler(AdminException.class)
	public Admin viewAdmin(@PathVariable("adminId") Admin admin) {
		return adminservice.viewAdmin(admin);
	}

   	//working
	@PostMapping("/addAdmin")
	@ExceptionHandler(AdminException.class)
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminservice.addAdmin(admin);
	}

	
	//working
	@PutMapping("/updateAdmin")
	@ExceptionHandler(AdminException.class)
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminservice.updateAdmin(admin);
	}

	
	//working
	@DeleteMapping("/removeAdmin")
	@ExceptionHandler(AdminException.class)
	public Admin removeAdmin(@RequestBody Admin admin) {
		return adminservice.removeAdmin(admin);
	}
}