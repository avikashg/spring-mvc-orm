package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.IUserDao;
import spring.entities.User;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserDao userDao;
	
	public int insertUser(User user) {
		int id = this.userDao.insertUser(user);
		return id;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
