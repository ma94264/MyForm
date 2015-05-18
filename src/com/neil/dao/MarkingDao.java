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

import com.neil.object.MarkingObj;

@Repository("MarkingDao")
@Transactional
public class MarkingDao {
private static final Log log = LogFactory.getLog(MarkingDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<MarkingObj> getAllMarkings(){
		log.debug("getAllMarkings() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(MarkingObj.class);
		return c.list();
	}
	
	public MarkingObj getMarking(long id) {
		log.debug("getMarking() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (MarkingObj) ses.get(MarkingObj.class, id);
	}
	
	public void saveMarking(MarkingObj obj) {
		log.debug("saveMarking() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteMarking(MarkingObj obj){
		log.debug("deleteMarking() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
