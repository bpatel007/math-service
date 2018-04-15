package com.boncloud.mathservice.mathservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class PrimeNumberResponse {
	
	@JsonProperty(value="Initials")
	private int initials;

	@JsonProperty(value="Primes")
	private List<Integer>  primes;

	public int getInitials() {
		return initials;
	}

	public void setInitials(int initials) {
		this.initials = initials;
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public void setPrimes(List<Integer> primes) {
		this.primes = primes;
	}


}
