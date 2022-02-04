package com.example.program;

import com.example.program.components.MapPrinter;
import com.example.program.components.SiteParser;
import com.example.program.components.TextParser;
import com.example.program.components.UrlReader;
import com.example.program.exceptions.SiteNotFoundException;
import com.example.program.services.SiteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ProgramApplicationTests {

	private SiteParser siteParser;
	private TextParser textParser;

	@Test
	void contextLoads() {
	}

	@Test
	void siteParserTest() throws SiteNotFoundException {
		siteParser.getDocument("https://yandex.ru/");
	}

	@Test
	void textParserTest() throws SiteNotFoundException {
		textParser.findWords(siteParser.getDocument("https://yandex.ru/"));
	}

	@Autowired
	public void setSiteParser(SiteParser siteParser) {
		this.siteParser = siteParser;
	}

	@Autowired
	public void setTextParser(TextParser textParser) {
		this.textParser = textParser;
	}
}
