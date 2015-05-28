package com.neil.dao;

import java.util.ArrayList;
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

import com.neil.object.AssessmentObj;
import com.neil.object.StudentObj;

@Repository("AssessmentDao")
@Transactional
public class AssessmentDao {
private static final Log log = LogFactory.getLog(AssessmentDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<AssessmentObj> getAllAsem(){
		log.debug("getAllAsem() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(AssessmentObj.class);
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<AssessmentObj> getOneAsem(long lab_sessionID){
		log.debug("getOneAsem() entry");
		Session ses = sessionFactory.getCurrentSession();
		Criteria c = ses.createCriteria(AssessmentObj.class);
		c.add(Restrictions.eq("lab_sessionID", lab_sessionID));
		ArrayList<AssessmentObj> aol = new ArrayList<AssessmentObj>();
		aol = (ArrayList<AssessmentObj>) c.list();
		for(AssessmentObj ao: aol){
			Session ses2 = sessionFactory.getCurrentSession();
			StudentObj so = (StudentObj)ses2.get(StudentObj.class, ao.getStudent_username());
			ao.setStudent_name(so.getName());
		}
		return aol;
	}
	
	public AssessmentObj getAsem(long id) {
		log.debug("getAsem() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (AssessmentObj) ses.get(AssessmentObj.class, id);
	}
	
	public void saveAsem(AssessmentObj obj) {
		log.debug("saveAsem() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteAsem(AssessmentObj obj){
		log.debug("deleteAsem() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
