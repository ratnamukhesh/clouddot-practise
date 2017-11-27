package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PatientDao;
import com.exmaple.demo.vo.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	//@Autowired
	private CrudRepository<Doctor, Integer> dao;
//PatientDao dao;
	
	public Doctor getAllDoctors(int i) {

		return dao.findOne(i);

	}

	
	public void createDoctor(Doctor d) {
		
		dao.save(d);

	}

}
