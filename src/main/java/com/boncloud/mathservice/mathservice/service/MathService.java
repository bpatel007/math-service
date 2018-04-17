package com.boncloud.mathservice.mathservice.service;

import java.util.List;

/**
 * @author bpatel
 *
 */
public interface MathService {
	/**
	 * Find the all prime numbers supplied range
	 * @param maxNumber
	 * @return List of all prime numbers
	 */
	List<Integer> findPrimeNumbers(int maxNumber);

	/**
	 * Find is supplied number is prime or not
	 * @param number
	 * @return true if supplied number is prime else this method will return false
	 */
	boolean isPrime(int number);

}
