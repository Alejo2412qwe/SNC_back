package com.senescyt.app.security2;

import com.senescyt.app.security2.jwt.JwtEntryPoint;
import com.senescyt.app.security2.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfiguration {
//
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    JwtEntryPoint jwtEntryPoint;

}