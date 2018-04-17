package com.boncloud.mathservice.mathservice.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author bpatel
 *
 */
@Service
public class MathServiceImpl implements MathService {

	private static final Logger logger = LoggerFactory.getLogger(MathServiceImpl.class);

	@Override
	public List<Integer> findPrimeNumbers(int maxNumber) {
		logger.debug("finding prime numbes untill :" + maxNumber);
		return IntStream.rangeClosed(2, maxNumber).filter(n -> isPrime(n)).boxed().collect(Collectors.toList());
	}

	/**
	 * find given number is prime number or not.
	 * @param number
	 * @return true if given number is prime, else return false
	 */
	@Override
	public boolean isPrime(int number) {
		return number > 1 &&
				IntStream.range(2, number).noneMatch(n -> number % n == 0);
	}

}
