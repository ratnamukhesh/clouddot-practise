/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.PatientBean;
import com.example.demo.service.PatientService;
import com.google.gson.Gson;

/**
 * @author ratna
 *
 */
@Controller
@RequestMapping("/patient-service")
public class PatientController {
	@Autowired
	PatientService patService;
	
	@RequestMapping("/addpatient")
	public ResponseEntity<Object> AddPatient(@RequestBody String patString) {
		Gson gson= new Gson();
		PatientBean patBean = gson.fromJson(patString, PatientBean.class);
		
		patService.addPatient(patBean);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllPatients")
	public ResponseEntity<String> getAllPatients(){
		ResponseEntity<String> respEntity = null;
		try {
			List<PatientBean> patBeanList = patService.getAllPatient();
			JSONObject json = new JSONObject();
			json.put("patList",patBeanList);
			json.put("message", "get all patients");
			respEntity = new ResponseEntity<String>(json.toString(), HttpStatus.FOUND);
		}catch (Exception e) {
			JSONObject json = new JSONObject();
			try {
				json.put("error", e.getMessage());
				respEntity = new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return respEntity;
		
	}

}
