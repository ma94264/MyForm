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

import com.neil.object.ProfessorObj;

@Repository("ProfessorDao")
@Transactional
public class ProfessorDao {
private static final Log log = LogFactory.getLog(ProfessorDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ProfessorObj> getAllProfessors(){
		log.debug("getAllProfessors() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(ProfessorObj.class);
		return c.list();
	}
	
	public ProfessorObj getProfessor(String id) {
		log.debug("getProfessor() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (ProfessorObj) ses.get(ProfessorObj.class, id);
	}
	
	public void saveProfessor(ProfessorObj obj) {
		log.debug("saveProfessor() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteProfessor(ProfessorObj obj){
		log.debug("deleteProfessor() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
