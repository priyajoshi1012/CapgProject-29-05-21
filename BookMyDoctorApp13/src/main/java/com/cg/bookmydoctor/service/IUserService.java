package com.cg.bookmydoctor.service;

import com.cg.bookmydoctor.dto.User;

public interface IUserService {
	
	public User addUser(User user);
	public User updateUser(User user);
	public User removeUser(User user);
	//public User validateUser(User user);

}