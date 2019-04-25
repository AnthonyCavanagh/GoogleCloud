package com.lumar.googlecloud.service;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import javax.servlet.ServletException;

public class ServletInitializer extends SpringBootServletInitializer {

	 @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(GoogleTypeService.class);
	  }
}
