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

import com.neil.object.LabSessionObj;

@Repository("LabSessionDao")
@Transactional
public class LabSessionDao {
private static final Log log = LogFactory.getLog(LabSessionDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<LabSessionObj> getAllLabSessions(){
		log.debug("getAllLabSessions() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(LabSessionObj.class);
		return c.list();
	}
	
	public LabSessionObj getLabSession(long id) {
		log.debug("getLabSession() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (LabSessionObj) ses.get(LabSessionObj.class, id);
	}
	
	public void saveLabSession(LabSessionObj obj) {
		log.debug("saveLabSession() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteLabSession(LabSessionObj obj){
		log.debug("deleteLabSession() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}