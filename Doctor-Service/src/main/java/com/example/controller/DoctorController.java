package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exmaple.domain.DoctorBean;

@Controller
@RequestMapping("/doctor-service")
public class DoctorController {
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/ds")
	public @ResponseBody ResponseEntity getDoctorDetails() {
		
		DoctorBean bean= new DoctorBean();
		bean.setId(1);
		bean.setName("ratna");
		bean.setName("hyd");
		
		return new ResponseEntity<>(bean, HttpStatus.CREATED);
	}

}
