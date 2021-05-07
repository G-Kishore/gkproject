package com.cg.service;

import java.util.List;

import com.cg.entites.User;


public interface UserService {
    public List<User> getAllUsers();;
    public User addUser(User user);
    public User removeUser(int UserId);
	public User validateUser(String username,String password);
}
