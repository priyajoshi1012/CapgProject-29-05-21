package com.cg.bookmydoctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dao.IUserDao;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	
	@Override
	public User addUser(User user) {
		if(user == null) {
			throw new UserException("Passed object can't be null");
		} else {
			return userDao.save(user);
		}
	}

	@Override
	public User updateUser(User user) {
		if(user == null) {
			throw new UserException("Passed object can't be null");
		} else {
			return userDao.save(user);
		}
	}

	@Override
	public User removeUser(User user) {
		User user1 = user;
		if(user == null) {
			throw new UserException("Record Not Found");

		} else {
			userDao.deleteById(user.getUserId());
		}
		return user1;	
	}

}