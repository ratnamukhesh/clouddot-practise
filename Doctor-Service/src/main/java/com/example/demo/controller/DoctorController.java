package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.IDoctorService;
import com.exmaple.demo.vo.Doctor;

@Controller
@RequestMapping("/doctor-service")
public class DoctorController {
	
	@Autowired
	private IDoctorService  doctorService;



	@RequestMapping(value="/ds/{id}")
	public @ResponseBody ResponseEntity getDoctorDetails(@PathVariable("id") String id) {

		//		DoctorBean bean= new DoctorBean();
		//		bean.setId(1);
		//		bean.setName("ratna");
		//		bean.setName("hyd");
		//doctorService.getAllDoctors(Integer.valueOf(id));
		return new ResponseEntity<>( HttpStatus.CREATED);
	}

	@RequestMapping(value="/createDoctor",method=RequestMethod.POST)
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor bean) {

		//doctorService.createDoctor(bean);

		return new ResponseEntity<>(bean, HttpStatus.CREATED);
	}

}
