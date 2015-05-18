package com.neil.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	private static final Log log = LogFactory.getLog(ViewController.class);
	
	protected String cmsPath() {
		return "cms/";
	}
	
	protected String viewPage(String strURL) {
		return cmsPath() + strURL;
	}
	
//	@PreAuthorize("hasAnyRole('ROLE_SuperAdmin','ROLE_Admin','ROLE_Marketing','ROLE_Product Dev','ROLE_CS')")
	@RequestMapping(value="home")
	public String home(Model model, HttpSession ses) {

		return viewPage("home");
	}
	
	@RequestMapping(value="tables")
	public String table(Model model, HttpSession ses) {
		return viewPage("tables");
	}
	
	@RequestMapping(value="login")
	public String login(Model model, HttpSession ses) {
		return viewPage("login");
	}


}
