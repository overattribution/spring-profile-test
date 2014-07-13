package com.example.home;

import com.example.profileservice.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@PropertySource("classpath:application.properties")
@Controller
public class HomeController {

    private final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Value("${spring.profiles.active}")
    private String activeProfiles;

    @Autowired
    private MyService myService;

    @Autowired
    private Environment environment;

	@RequestMapping
	public HttpEntity<String> index(Principal principal) {

        LOG.debug("@Value(\"${spring.profiles.active}\"): " + activeProfiles);
        LOG.debug("environment.getActiveProfiles(): " + environment.getActiveProfiles());

        myService.doSomething();
		return new ResponseEntity<String>("hello world.", HttpStatus.OK);
	}
}
