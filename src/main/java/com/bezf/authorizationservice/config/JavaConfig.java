package com.bezf.authorizationservice.config;

import com.bezf.authorizationservice.services.AuthorizationService;
import com.bezf.authorizationservice.userRepository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService(userRepository());
    }
}