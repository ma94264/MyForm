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
		Session ses = sessionFactory.getCurrentSession();
		Criteria c = ses.createCriteria(LabSessionObj.class);
		List<LabSessionObj> lsList = c.list();
		for(LabSessionObj ls:lsList){
			ls.setLgo((LabGroupObj) ses.get(LabGroupObj.class, ls.getGroupID()));
		}
		return lsList;
	}
	
	public LabSessionObj getLabSession(long id) {
		log.debug("getLabSession() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (LabSessionObj) ses.get(LabSessionObj.class, id);
	}
	
	public LabSessionObj getLabSessionByGWP(long groupID, int week_number, String professor_username) {
		log.debug("getLabSessionByGWP() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(LabSessionObj.class);
		c.add(Restrictions.eq("groupID", groupID));
		c.add(Restrictions.eq("week_number", week_number));
		c.add(Restrictions.eq("professor_username", professor_username));
		return (LabSessionObj) c.list().get(0);
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
