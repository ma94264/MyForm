package com.neil.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neil.object.ParticipantObj;

@Repository("ParticipantDao")
@Transactional
public class ParticipantDao {
private static final Log log = LogFactory.getLog(ParticipantDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ParticipantObj> getAllParticipants(){
		log.debug("getAllStudents() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(ParticipantObj.class);
		return c.list();
	}
	
	public ParticipantObj getParticipant(String id) {
		log.debug("getParticipant() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (ParticipantObj) ses.get(ParticipantObj.class, id);
	}
	
	public void saveParticipant(ParticipantObj obj) {
		log.debug("saveParticipant() entry");
		Session ses = sessionFactory.getCurrentSession();
		Date now = new Date();
		obj.setCreate_date(now);
		ses.saveOrUpdate(obj);
	}
	
}
