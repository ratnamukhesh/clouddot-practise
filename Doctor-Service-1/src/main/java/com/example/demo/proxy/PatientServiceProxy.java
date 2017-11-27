package com.example.demo.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//@RibbonClient
@FeignClient(name="patient-service")
public interface PatientServiceProxy {
	
	@RequestMapping("/patient-service/addpatient")
	public ResponseEntity<String> AddPatient(@RequestBody String patString);

}
