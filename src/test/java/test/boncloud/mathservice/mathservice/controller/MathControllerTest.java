package test.boncloud.mathservice.mathservice.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.boncloud.mathservice.mathservice.controller.MathController;
import com.boncloud.mathservice.mathservice.service.MathService;

/**
 * @author bpatel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class MathControllerTest {

	private MockMvc mockMvc;

	@Mock
	private MathService MathService;

	@InjectMocks
	private MathController mathController;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
	}

	public void teatDown() {
		mockMvc = null;
	}

	@Test
	public void testGetPrimes() throws Exception {

		List<Integer> result1 = Arrays.asList(2, 3, 5, 7);
		List<Integer> result2 = Arrays.asList(2, 3, 5, 7,11,13);
		when(MathService.findPrimeNumbers(10)).thenReturn(result1);
		when(MathService.findPrimeNumbers(15)).thenReturn(result2);
		String response1 = "{\"Initials\":10,\"Primes\":[2,3,5,7]}";
		String response2 = "{\"Initials\":15,\"Primes\":[2,3,5,7,11,13]}";
		
		
		mockMvc.perform(get("/primes/{maxNumber}", 10)).
		andExpect(status().isOk()).
		andExpect(status().is2xxSuccessful()).
		andExpect(content().string(response1));
		
		mockMvc.perform(get("/primes/{maxNumber}", 15)).
		andExpect(status().isOk()).
		andExpect(status().is2xxSuccessful()).
		andExpect(content().string(response2));
		
		verify(MathService, times(1)).findPrimeNumbers(10);
		verify(MathService, times(1)).findPrimeNumbers(15);

	}
}
