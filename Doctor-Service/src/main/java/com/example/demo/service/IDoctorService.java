/**
 * 
 */
package com.example.demo.service;

import com.exmaple.demo.vo.Doctor;

/**
 * @author ratna
 *
 */
public interface IDoctorService {

	Doctor getAllDoctors(int i);

	void createDoctor(Doctor d);

}
