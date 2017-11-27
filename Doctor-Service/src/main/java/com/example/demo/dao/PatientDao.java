package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.exmaple.demo.vo.Doctor;


public interface PatientDao  extends CrudRepository<Doctor, Integer>{

	@Query("from Patient pat where pat.fname like '%:name%'")
	public List<Doctor>  seachAllPatientsByName(@Param("name")String name);
}
