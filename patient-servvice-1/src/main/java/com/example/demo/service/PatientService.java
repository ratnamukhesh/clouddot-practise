/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.PatientBean;
import com.example.demo.vo.Patient;

/**
 * @author ratna
 *
 */
public interface PatientService {

	
	Patient getPatientByName(String name);
	void addPatient(PatientBean patBean);
	List<PatientBean> getAllPatient();
}
