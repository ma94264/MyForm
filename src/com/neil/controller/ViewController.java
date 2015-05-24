package com.neil.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neil.dao.StudentDao;
import com.neil.object.StudentObj;

@Controller
public class ViewController {
	private static final Log log = LogFactory.getLog(ViewController.class);
	
	@Autowired
	private StudentDao studentDao;
	
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
	
	@ResponseBody
	@RequestMapping(value = "studentHandler")
	public void studentHandler(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(required = false) String id,
			@RequestParam(required = false) String value,
			@RequestParam(required = false) String columnName) throws IOException {
		
		if(StringUtils.isNotEmpty(id)&&StringUtils.isNotEmpty(value)){
			StudentObj so = studentDao.getStudent(id);
			if(StringUtils.containsIgnoreCase(columnName, "username"))
				so.setUsername(value);
			if(StringUtils.containsIgnoreCase(columnName, "name"))
				so.setName(value);
			if(StringUtils.containsIgnoreCase(columnName, "course"))
				so.setCourse_type(value);
			if(StringUtils.containsIgnoreCase(columnName, "nation"))
				so.setNationality(value);
			if(StringUtils.containsIgnoreCase(columnName, "group"))
				so.setGroupID(value);
			
			studentDao.saveStudent(so);
		}
		
			res.getWriter().print(value);
	}

}
