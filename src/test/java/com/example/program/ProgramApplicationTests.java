package com.example.program;

import com.example.program.components.DocParser;
import com.example.program.exceptions.SiteNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProgramApplicationTests {


	private DocParser textParser;

	@Test
	void contextLoads() {
	}



	@Autowired
	public void setTextParser(DocParser textParser) {
		this.textParser = textParser;
	}
}
