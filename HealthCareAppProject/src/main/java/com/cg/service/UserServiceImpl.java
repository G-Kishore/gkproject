package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.dao.UserRepository;
import com.cg.entites.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository urepo;
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> ulist=urepo.findAll();
		return ulist;
		
	}
	@Override
	@Transactional
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return urepo.save(user);
	}
	@Override
	@Transactional
	public User removeUser(int userId) {
		// TODO Auto-generated method stub
		Optional<User> u=urepo.findById(userId);
		if(u.empty()!=null) {
			urepo.deleteById(userId);
			return u.get();
		}
	return null;
	}
	@Override
	public User validateUser(String username, String password) {
		User u=urepo.getUserByUsername(username);
	    if(u!=null) {
	    	System.out.println("Valid User");
	    	}
	    else {
	    	System.out.println("Invalid User");
	    }
		return null;
		
	}

	

}
