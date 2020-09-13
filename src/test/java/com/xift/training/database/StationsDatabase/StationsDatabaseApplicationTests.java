//package com.xift.training.database.StationsDatabase;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest // It tells Spring Boot to look for a main configuration class and use that to start a Spring application context
//class StationsDatabaseApplicationTests {
//
//	@Test
//	void contextLoads() // Test that the context successfully loads (the test will fail if the context cannot be loaded)
//
//	{
//	}
//
//}
package com.xift.training.database.StationsDatabase;

import org.junit.Test;

public class StationsDatabaseApplicationTests {

	@Test
	public void testMain() {
		StationsDatabaseApplication.main(new String[]{"value"});

	}
}
