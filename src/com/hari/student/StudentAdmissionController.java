package com.hari.student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/a")
public class StudentAdmissionController {

	@InitBinder
	public void initBuilder(WebDataBinder binder){
		//		binder.setDisallowedFields(new String[] {"studentName"});
		//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy***MM***dd");
		//		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat,false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}

	@RequestMapping(value = "/addmission", method = RequestMethod.GET)
	public ModelAndView getAdmission() throws Exception{
		if(true){
			throw new NullPointerException("exception Trial");
		}
		ModelAndView model = new ModelAndView("AdmissionForm");
		return model;
	}

	//	@ModelAttribute
	//	public void addingCommonObjects(Model model){
	//		model.addAttribute("msg","Hi Welcome!");
	//		
	//	}


	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	//		public ModelAndView submitAdmissionForm(@RequestParam(value = "studentName", defaultValue ="Mr.X") String name, @RequestParam("studentHobby") String hobby){
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student1, BindingResult result){
		//		public ModelAndView submitAdmissionForm(){
		//	public ModelAndView submitAdmissionForm(@RequestParam Map<String,String> paramMap){
		//		Student s1= new Student();
		//		s1.setName(name);
		//		s1.setHobby(hobby);

		//		 String hobby = paramMap.get("studentHobby");
		//		 String name = paramMap.get("studentName");
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("AdmissionForm");
			return model;
		}
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		//		model.addObject("msg","Name: "+name+"  Hobby: "+hobby);
		//		model.addObject("s1",s1);
		return model;
	}

	

}

