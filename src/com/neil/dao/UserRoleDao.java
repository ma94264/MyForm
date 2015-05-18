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

import com.neil.object.UserRoleObj;

@Repository("UserRoleDao")
@Transactional
public class UserRoleDao {
private static final Log log = LogFactory.getLog(UserRoleDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<UserRoleObj> getAllUserRoles(){
		log.debug("getAllUserRoles() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(UserRoleObj.class);
		return c.list();
	}
	
	public UserRoleObj getUserRole(long id) {
		log.debug("getUserRole() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (UserRoleObj) ses.get(UserRoleObj.class, id);
	}
	
	public void saveUserRole(UserRoleObj obj) {
		log.debug("saveUserRole() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteUserRole(UserRoleObj obj){
		log.debug("deleteUserRole() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
