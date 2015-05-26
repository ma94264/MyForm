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

import com.neil.object.CourseObj;
import com.neil.object.LabGroupObj;

@Repository("CourseDao")
@Transactional
public class CourseDao {
private static final Log log = LogFactory.getLog(CourseDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<CourseObj> getAllCourses(){
		log.debug("getAllCourses() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(CourseObj.class);
		return c.list();
	}
	
	public CourseObj getCourse(String course) {
		log.debug("getCourse() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (CourseObj) ses.get(CourseObj.class, course);
	}
	
	public void saveCourse(CourseObj obj) {
		log.debug("saveCourse() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteCourse(CourseObj obj){
		log.debug("deleteCourse() entry");
		Session ses = sessionFactory.getCurrentSession();
		//delete all children, all LabGroupObjs 
		Criteria c = ses.createCriteria(LabGroupObj.class);
		@SuppressWarnings("unchecked")
		List<LabGroupObj> lgolist = c.add(Restrictions.eq("course",obj.getCourse())).list();
		for(LabGroupObj lgo : lgolist){
			ses.delete(lgo);
		}
		//delete parent
		ses.delete(obj);
	}
}
