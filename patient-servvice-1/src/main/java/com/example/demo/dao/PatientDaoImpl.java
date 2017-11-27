package com.example.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.Patient;
@Repository
public class PatientDaoImpl  implements PatientDao{
	
	@Autowired
	SessionFactory sf;

	@Override
	public Patient getPatientByName(String name) {
		Session session = sf.getCurrentSession();
		Patient pat = (Patient)session.get(name, Patient.class);
		
		return pat;
	}

	@Override
	public Patient addPatient(Patient pat) {
		Session session = sf.getCurrentSession();
		Integer id = (Integer) session.save(pat);
		pat.setPatId(id);
		return pat;
	}

	@Override
	public List<Patient> getAllPatient() {
		Session session = sf.getCurrentSession();
		Query createQuery = session.createQuery("from Patient");
		return createQuery.list();
	}

}
