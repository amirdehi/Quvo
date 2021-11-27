package com.amirdehi.quvo;

import com.amirdehi.quvo.service.implementations.VoteServiceImpl;
import com.amirdehi.quvo.service.interfaces.IVoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.amirdehi.quvo.repository"})
public class QuvoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(QuvoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(QuvoApplication.class);
    }

}
