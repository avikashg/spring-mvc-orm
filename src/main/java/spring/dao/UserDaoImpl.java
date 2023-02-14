package spring.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import spring.entities.User;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		int id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
