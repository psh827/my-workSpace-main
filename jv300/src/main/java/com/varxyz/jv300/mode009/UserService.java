package com.varxyz.jv300.mode009;

public class UserService {
	private UserDao userDao;
	
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public User addUser(User user) {
		userDao.addUser(user);
		return getUserByUserId(user.getUserId());
	}
	
	public User getUserByUserId(String userId) {
		return userDao.findUserByUserId(userId);
	}

}
