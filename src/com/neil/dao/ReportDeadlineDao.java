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

import com.neil.object.ReportDeadlineObj;

@Repository("ReportDeadlineDao")
@Transactional
public class ReportDeadlineDao {
private static final Log log = LogFactory.getLog(ReportDeadlineDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ReportDeadlineObj> getAllReportDeadlines(){
		log.debug("getAllReportDeadlines() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(ReportDeadlineObj.class);
		return c.list();
	}
	
	public ReportDeadlineObj getReportDeadline(long id) {
		log.debug("getReportDeadline() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (ReportDeadlineObj) ses.get(ReportDeadlineObj.class, id);
	}
	
	public void saveReportDeadline(ReportDeadlineObj obj) {
		log.debug("saveReportDeadline() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteReportDeadline(ReportDeadlineObj obj){
		log.debug("deleteReportDeadline() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
