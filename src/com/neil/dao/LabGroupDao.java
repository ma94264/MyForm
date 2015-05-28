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

import com.neil.object.LabGroupObj;

@Repository("LabGroupDao")
@Transactional
public class LabGroupDao {
private static final Log log = LogFactory.getLog(LabGroupDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<LabGroupObj> getAllLabGroups(){
		log.debug("getAllLabGroups() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(LabGroupObj.class);
		return c.list();
	}
	
	public LabGroupObj getLabGroup(long id) {
		log.debug("getLabGroup() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (LabGroupObj) ses.get(LabGroupObj.class, id);
	}
	
	public LabGroupObj getLabGroupByCG(String course, String group) {
		log.debug("getLabGroupByCG() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(LabGroupObj.class);
		c.add(Restrictions.eq("course", course));
		c.add(Restrictions.eq("group", group));
		return (LabGroupObj) c.list().get(0);
	}
	
	public void saveLabGroup(LabGroupObj obj) {
		log.debug("saveLabGroup() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteLabGroup(LabGroupObj obj){
		log.debug("deleteLabGroup() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
