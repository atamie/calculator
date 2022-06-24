package com.atamie.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.BDDAssertions.then;
//import org.mockito.BDDMockito.given;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorApplicationTests {
	private Sum sum;
	@BeforeEach
	public void setUp()
	{
		sum = new Sum();
	}
	@Test
	void contextLoads() {
		//Sum sum = new Sum();
		then(sum.sum(2,3)).isEqualTo(5);


	}
	@Test
	void testSubtract(){
		//Sum sum = new Sum();
		assertEquals(1, sum.subtract(3,2));
	}
	@Test
	void testMultiply(){
		//Sum sum = new Sum();
		assertEquals(6, sum.multiply(2,3));
	}

}
