package com.varxyz.jv300.mode010;

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

	public boolean isValidUser(String userId, String passwd) {
		return userDao.isValidUser(userId, passwd);
	}

	public boolean isValidUser(String passwd) {
		return userDao.isValidUser(passwd);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}
	
	public User findUserByUserPasswd(String passwd) {
		return userDao.findUserByUserPasswd(passwd);
	}

}
