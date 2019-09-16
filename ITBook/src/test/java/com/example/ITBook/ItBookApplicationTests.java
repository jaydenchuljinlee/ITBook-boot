package com.example.ITBook;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("local")
@RunWith(SpringRunner.class)
@SpringBootTest(
		properties = {"property.value=propertyTest"},
		classes = {ItBookApplication.class},
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
		)
public class ItBookApplicationTests {

	@Value("${property.value}")
	String propertyValue;
	
	@Test
	public void contextLoads() {
		
	}

}
