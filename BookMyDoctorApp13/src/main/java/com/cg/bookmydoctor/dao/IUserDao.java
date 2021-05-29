package com.cg.bookmydoctor.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmydoctor.dto.User;


@Repository
public interface IUserDao extends CrudRepository<User, Integer>{

}
