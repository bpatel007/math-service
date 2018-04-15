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
		return IntStream.range(2, maxNumber).filter(n -> isPrime(n)).boxed().collect(Collectors.toList());
	}

	/**
	 * find given number is prime number or not.
	 * @param maxNumber
	 * @return true if given number is prime, else return false
	 */
	private boolean isPrime(int maxNumber) {
		return maxNumber > 1 &&
				IntStream.range(2, maxNumber).noneMatch(n -> maxNumber % n == 0);
	}

}
