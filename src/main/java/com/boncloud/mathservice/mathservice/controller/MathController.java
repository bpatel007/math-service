package com.boncloud.mathservice.mathservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boncloud.mathservice.mathservice.model.PrimeNumberResponse;
import com.boncloud.mathservice.mathservice.service.MathService;

/**
 * @author bpatel
 *
 */
@RestController
public class MathController {
	
	@Autowired
	private MathService mathService;
	
	private static final Logger logger = LoggerFactory.getLogger(MathController.class);

	@GetMapping("/primes/{maxNumber}")
	public ResponseEntity<PrimeNumberResponse> getPrimeNumbers(@PathVariable int maxNumber) {  
		
		PrimeNumberResponse response = new PrimeNumberResponse();
		List<Integer> primes = mathService.findPrimeNumbers(maxNumber);
		logger.info("primes"+primes);
		response.setInitials(maxNumber);
		response.setPrimes(primes);
		
		return new ResponseEntity<PrimeNumberResponse>(response, HttpStatus.OK);

	}
	

}
