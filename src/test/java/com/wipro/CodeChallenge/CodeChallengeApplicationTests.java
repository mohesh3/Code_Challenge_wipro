package com.wipro.CodeChallenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CodeChallengeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void main_test() {
		CodeChallengeApplication.main(new String[] {});
		assertTrue(true);
	}

}
