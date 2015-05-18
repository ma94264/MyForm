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

import com.neil.object.ReportObj;

@Repository("ReportDao")
@Transactional
public class ReportDao {
private static final Log log = LogFactory.getLog(ReportDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ReportObj> getAllReports(){
		log.debug("getAllReports() entry");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(ReportObj.class);
		return c.list();
	}
	
	public ReportObj getReport(long id) {
		log.debug("getReport() entry");
		Session ses = sessionFactory.getCurrentSession();
		return (ReportObj) ses.get(ReportObj.class, id);
	}
	
	public void saveReport(ReportObj obj) {
		log.debug("saveReport() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(obj);
	}
	
	public void deleteReport(ReportObj obj){
		log.debug("deleteReport() entry");
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(obj);
	}
}
