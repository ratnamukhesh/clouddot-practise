package com.example.demo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.objects.Doctor;
import com.example.demo.proxy.PatientServiceProxy;

@Controller
@RequestMapping("/doctc")
public class DoctorController {
	
//	@Autowired
//	private IDoctorService  doctorService;
public static Map<Integer, Doctor> map= new HashMap<Integer, Doctor>();

@Autowired
PatientServiceProxy patientServiceProxy;


static {
	map.put(1, new Doctor(1,"ratna","piduhuralla"));
	map.put(2, new Doctor(2,"ratna1","piduhuralla1"));
}


	@RequestMapping(value="/ds/{id}")
	public @ResponseBody Doctor getDoctorDetails(@PathVariable("id") int id) {
		//Doctor doc=null;
		for ( Doctor doc : map.values()) {
			if(id == doc.getId()) {
				return doc;
			}
		}
		
		return null;
	}
	
	@RequestMapping(value="/getDoctores",produces="application/json")
	public @ResponseBody Collection<Doctor>  getAllDoctores() {

		Collection<Doctor> values = map.values();
		return values;
	}

	@RequestMapping(value="/createDoctor",method=RequestMethod.POST)
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor bean) {

		//map.put(bean.getId(), bean);
		JSONObject obj=new JSONObject();    
		  obj.put("fname",bean.getName());    
		  obj.put("lname",bean.getName());    
		 System.out.println("in doctor controller");
		
		ResponseEntity<String> addPatient = patientServiceProxy.AddPatient(obj.toString());

		return new ResponseEntity<>(bean, HttpStatus.CREATED);
	}

}
