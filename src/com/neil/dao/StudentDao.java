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

import com.neil.object.StudentObj;

@Repository("StudentDao")
@Transactional
public class StudentDao {
private static final Log log = LogFactory.getLog(StudentDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<StudentObj> getAllStudents(){
		log.debug("getAllStudents() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(StudentObj.class);
		return c.list();
	}
	
	public StudentObj getStudent(long id) {
		log.debug("getStudent() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (StudentObj) ses.get(StudentObj.class, id);
	}
	
	public void saveStudent(StudentObj obj) {
		log.debug("saveStudent() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteStudent(StudentObj obj){
		log.debug("deleteStudent() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
