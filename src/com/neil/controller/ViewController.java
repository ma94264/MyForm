package com.neil.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neil.dao.ParticipantDao;
import com.neil.object.ParticipantObj;

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

	// @PreAuthorize("hasAnyRole('ROLE_SuperAdmin','ROLE_Admin','ROLE_Marketing','ROLE_Product Dev','ROLE_CS')")
	@RequestMapping(value = "home")
	public String home(Model model, HttpSession ses) {

		return viewPage("home");
	}

	@RequestMapping(value = "tables")
	public String table(Model model, HttpSession ses) {
		return viewPage("tables");
	}

	@RequestMapping(value = "login")
	public String login(Model model, HttpSession ses) {
		return viewPage("login");
	}


}
