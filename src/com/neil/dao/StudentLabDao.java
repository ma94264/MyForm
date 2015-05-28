package com.neil.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neil.object.StudentLabObj;

@Repository("StudentLabDao")
@Transactional
public class StudentLabDao {
private static final Log log = LogFactory.getLog(StudentLabDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<StudentLabObj> getAllStudentLabs(){
		log.debug("getAllStudentLabs() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(StudentLabObj.class);
		return c.list();
	}
	
	public StudentLabObj getStudentLab(long id) {
		log.debug("getStudentLab() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (StudentLabObj) ses.get(StudentLabObj.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentLabObj> getStudentLabByGroupID(long id) {
		log.debug("getStudentLabByGroupID() entry");
		Session ses = sessionFactory.getCurrentSession();
		Criteria c = ses.createCriteria(StudentLabObj.class);
		c.add(Restrictions.eq("groupID", id));
		return c.list();
	}
	
	public void saveStudentLab(StudentLabObj obj) {
		log.debug("saveStudentLab() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteStudentLab(StudentLabObj obj){
		log.debug("deleteStudentLab() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
