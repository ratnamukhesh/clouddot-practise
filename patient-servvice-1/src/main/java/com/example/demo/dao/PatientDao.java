/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import com.example.demo.vo.Patient;

/**
 * @author ratna
 *
 */
public interface PatientDao {
	
	Patient getPatientByName(String name);
	
	Patient addPatient(Patient pat);
	
	List<Patient> getAllPatient();

}
