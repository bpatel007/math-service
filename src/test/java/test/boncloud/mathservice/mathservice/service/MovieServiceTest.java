package test.boncloud.mathservice.mathservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boncloud.mathservice.mathservice.service.MathService;
import com.boncloud.mathservice.mathservice.service.MathServiceImpl;

/**
 * @author bpatel
 *
 */
@SpringBootTest(classes = { MathServiceImpl.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MovieServiceTest.class);

	@Autowired
	private MathService mathService;

	@Before
	public void setup() {
		logger.debug("setup method called");
	}

	@After
	public void tearDown() {
		logger.info("tear down method called");
		mathService = null;
	}

	@Test
	public void testPrimes() {

		List<Integer> result1 = Arrays.asList(2, 3, 5, 7);
		List<Integer> result2 = Arrays.asList(2, 3, 5, 7, 11, 13);

		List<Integer> resultStream1 = mathService.findPrimeNumbers(10);
		assertNotNull("Result stream is null", resultStream1);
		assertEquals("Incorrect result", result1, resultStream1);

		List<Integer> resultStream2 = mathService.findPrimeNumbers(15);
		assertNotNull("Result stream is null", resultStream2);
		assertEquals("Incorrect result", result2, resultStream2);
	}
	
	public void testIsPrime() {
		
	}

}
