package com.neil.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neil.object.UserObj;

@Repository("UserDao")
@Transactional
public class UserDao {
private static final Log log = LogFactory.getLog(UserDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<UserObj> getAllUsers(){
		log.debug("getAllUsers() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(UserObj.class);
		return c.list();
	}
	
	public UserObj getUser(long id) {
		log.debug("getUser() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (UserObj) ses.get(UserObj.class, id);
	}
	
	public void saveUser(UserObj obj) {
		log.debug("saveUser() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteUser(UserObj obj){
		log.debug("deleteUser() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
