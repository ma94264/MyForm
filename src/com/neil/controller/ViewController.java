package com.neil.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import com.neil.dao.CourseDao;
import com.neil.dao.LabGroupDao;
import com.neil.dao.StudentDao;
import com.neil.object.CourseObj;
import com.neil.object.LabGroupObj;
import com.neil.object.StudentObj;

@Controller
public class ViewController {
	private static final Log log = LogFactory.getLog(ViewController.class);
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private LabGroupDao labGroupDao;
	
	SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	
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
	@RequestMapping(value = "updateStudent")
	public void updateStudent(Model model, HttpServletRequest req, HttpServletResponse res,
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
			
			studentDao.saveStudent(so);
		}
		
			res.getWriter().print(value);
	}
	
	@ResponseBody
	@RequestMapping(value = "deleteStudent")
	public void deleteStudent(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(required = false) String id,
			@RequestParam(required = false) String value,
			@RequestParam(required = false) String columnName) throws IOException {
		
		studentDao.deleteStudent(studentDao.getStudent(id));
		res.getWriter().print("ok");
	}
	
	@ResponseBody
	@RequestMapping(value = "addStudent")
	public void addStudent(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String course_type,
			@RequestParam(required = false) String nationality) throws IOException {
		
		StudentObj so = new StudentObj();
		so.setCourse_type(course_type);
		so.setName(name);
		so.setNationality(nationality);
		so.setUsername(username);
		studentDao.saveStudent(so);
		
		res.getWriter().print("ok");
	}

	@ResponseBody
	@RequestMapping(value = "updateCourse")
	public void updateCourse(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(required = false) String id,
			@RequestParam(required = false) String value,
			@RequestParam(required = false) String columnName) throws IOException {
		
		if(StringUtils.isNotEmpty(id)&&StringUtils.isNotEmpty(value)){
			CourseObj co = courseDao.getCourse(id);
			if(StringUtils.containsIgnoreCase(columnName, "course"))
				co.setCourse(value);
			if(StringUtils.containsIgnoreCase(columnName, "program"))
				co.setProgram(value);
			if(StringUtils.containsIgnoreCase(columnName, "class"))
				co.setClass_type(value);
			
			courseDao.saveCourse(co);
		}
		
			res.getWriter().print(value);
	}
	
	@ResponseBody
	@RequestMapping(value = "deleteCourse")
	public void deleteCourse(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(required = false) String id,
			@RequestParam(required = false) String value,
			@RequestParam(required = false) String columnName) throws IOException {
		
		courseDao.deleteCourse(courseDao.getCourse(id));
		res.getWriter().print("ok");
	}
	
	@ResponseBody
	@RequestMapping(value = "addCourse")
	public void addStudent(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(required = false) String course,
			@RequestParam(required = false) String program,
			@RequestParam(required = false) String class_type) throws IOException {
		
		CourseObj co = new CourseObj();
		co.setCourse(course);
		co.setProgram(program);
		co.setClass_type(class_type);
		courseDao.saveCourse(co);
		res.getWriter().print("ok");
	}
	
	@ResponseBody
	@RequestMapping(value = "updateLabGroup")
	public void updateLabGroup(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(required = false) String id,
			@RequestParam(required = false) String value,
			@RequestParam(required = false) String columnName) throws IOException, ParseException {
		
		if(StringUtils.isNotEmpty(id)&&StringUtils.isNotEmpty(value)){
			LabGroupObj lgo = labGroupDao.getLabGroup(Long.parseLong(id));
			if(StringUtils.containsIgnoreCase(columnName, "course"))
				lgo.setCourse(value);
			if(StringUtils.containsIgnoreCase(columnName, "group"))
				lgo.setGroup(value);
			if(StringUtils.containsIgnoreCase(columnName, "venue"))
				lgo.setVenue(value);
			if(StringUtils.containsIgnoreCase(columnName, "session")&&StringUtils.containsIgnoreCase(columnName, "start"))
				lgo.setSession_start(timeFormatter.parse(value));
			if(StringUtils.containsIgnoreCase(columnName, "session")&&StringUtils.containsIgnoreCase(columnName, "end"))
				lgo.setSession_end(timeFormatter.parse(value));
			if(StringUtils.containsIgnoreCase(columnName, "week")&&StringUtils.containsIgnoreCase(columnName, "start"))
				lgo.setWeek_start(Integer.valueOf(value));
			if(StringUtils.containsIgnoreCase(columnName, "week")&&StringUtils.containsIgnoreCase(columnName, "end"))
				lgo.setWeek_end(Integer.valueOf(value));
			
			labGroupDao.saveLabGroup(lgo);
		}
		
			res.getWriter().print(value);
	}
	
	@ResponseBody
	@RequestMapping(value = "deleteLabGroup")
	public void deleteLabGroup(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(required = false) String id,
			@RequestParam(required = false) String value,
			@RequestParam(required = false) String columnName) throws IOException {
		
		labGroupDao.deleteLabGroup(labGroupDao.getLabGroup(Long.valueOf(id)));
		res.getWriter().print("ok");
	}
	
	@ResponseBody
	@RequestMapping(value = "addLabGroup")
	public void addLabGroup(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(required = false) String course,
			@RequestParam(required = false) String group,
			@RequestParam(required = false) String venue,
			@RequestParam(required = false) String session_start,
			@RequestParam(required = false) String session_end,
			@RequestParam(required = false) String week_start,
			@RequestParam(required = false) String week_end) throws IOException, ParseException {
		
		LabGroupObj lgo = new LabGroupObj();
		lgo.setCourse(course);
		lgo.setGroup(group);
		lgo.setVenue(venue);
		lgo.setSession_start(timeFormatter.parse(session_start));
		lgo.setSession_end(timeFormatter.parse(session_end));
		lgo.setWeek_start(Integer.valueOf(week_start));
		lgo.setWeek_end(Integer.valueOf(week_end));
		labGroupDao.saveLabGroup(lgo);
		res.getWriter().print("ok");
	}
	
}
