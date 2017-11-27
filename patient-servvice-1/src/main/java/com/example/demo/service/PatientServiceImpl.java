/**
 * 
 */
package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PatientDao;
import com.example.demo.domain.PatientBean;
import com.example.demo.vo.Patient;

/**
 * @author ratna
 *
 */
@Service
public class PatientServiceImpl  implements PatientService{

	@Autowired
	PatientDao patDao;
	
	
	@Override
	public Patient getPatientByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public void addPatient(PatientBean patBean) {
		Patient pat = mapBeanToVO(patBean);
		Patient addPatient = patDao.addPatient(pat);
		PatientBean bean = mapDomainToDomain(addPatient);
		
	}
	
	private Patient mapBeanToVO(PatientBean patBean) {
		Patient pat = new Patient();
		
		if(patBean.getId() >0) {
			pat.setPatId(patBean.getId());
		}
		if(patBean.getFname() != null && !patBean.getFname().isEmpty()) {
			pat.setFname(patBean.getFname());
		}
		if(patBean.getLname() != null && !patBean.getLname().isEmpty()) {
			pat.setLname(patBean.getLname());
		}
		
//		if(patBean.getCreatedDate() != null && !patBean.getCreatedDate().isEmpty()) {
//			pat.setCreateDate(utils.getNovelHealthDateFromString(patBean.getCreatedDate()));
//		}
		
		
		return pat;
	}
	
	private PatientBean mapDomainToDomain(Patient patBean) {
		PatientBean pat = new PatientBean();
		if(patBean.getPatId() >0) {
			pat.setId(patBean.getPatId());
		}
		if(patBean.getFname() != null && !patBean.getFname().isEmpty()) {
			pat.setFname(patBean.getFname());
		}
		if(patBean.getLname() != null && !patBean.getLname().isEmpty()) {
			pat.setLname(patBean.getLname());
		}
		
//		if(patBean.getCreateDate() != null) {
//			pat.setCreatedDate(utils.getNovelHealthDateInString(patBean.getCreateDate()));
//		}
		
		return pat;
	}
@Transactional
	@Override
	public List<PatientBean> getAllPatient() {
		Iterable<Patient> iterable = patDao.getAllPatient();
		Iterator<Patient> it= iterable.iterator();
		List<PatientBean> patBeanList = new ArrayList<PatientBean>();
		while(it.hasNext()) {
			Patient pat = it.next();
			patBeanList.add(mapDomainToDomain(pat));
		}
		return patBeanList;
	}

}
