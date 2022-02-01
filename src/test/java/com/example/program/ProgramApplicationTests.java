package com.example.program;

import com.example.program.services.SiteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ProgramApplicationTests {

	private SiteService siteService;

	@Test
	void contextLoads() {
	}

	@Test
	void createTest() throws IOException {
		System.out.println(siteService.create());
	}

	@Autowired
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
}
