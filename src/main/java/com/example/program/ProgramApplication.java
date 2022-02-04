package com.example.program;

import com.example.program.exceptions.SiteNotFoundException;
import com.example.program.services.SiteService;
import com.example.program.services.SiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class ProgramApplication {

	private SiteService siteService;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProgramApplication.class, args);
	}

	@PostConstruct
	public void doRun() throws IOException, SiteNotFoundException {
		siteService.create();
	}

	@Autowired
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
}
