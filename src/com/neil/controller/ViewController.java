package com.neil.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neil.dao.ParticipantDao;

@Controller
public class ViewController {
	private static final Log log = LogFactory.getLog(ViewController.class);

	@Autowired 
	private ParticipantDao participantDao;
	
	SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	protected String cmsPath() {
		return "cms/";
	}

	protected String viewPage(String strURL) {
		return cmsPath() + strURL;
	}

	@RequestMapping(value = "login")
	public String login(Model model, HttpSession ses) {
		return viewPage("login");
	}
	
	@RequestMapping(value = "report")
	public String test(Model model, HttpSession ses) {
		model.addAttribute("pList",participantDao.getAllParticipants());
		return viewPage("report");
	}

}
