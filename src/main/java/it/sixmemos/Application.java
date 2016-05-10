package it.sixmemos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
* Simple application generate test for liferay developer certification
*
* @author  Daniele Fiorio
* @version 1.0
* @since   2016-05-09
*/

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class, WebSecurityConfigurerAdapter.class})
@ComponentScan
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
