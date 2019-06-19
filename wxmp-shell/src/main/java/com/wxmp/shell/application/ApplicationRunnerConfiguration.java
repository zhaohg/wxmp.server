package com.wxmp.shell.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.shell.ExitRequest;
import org.springframework.shell.Shell;

@Configuration
public class ApplicationRunnerConfiguration {
    
    @Autowired
    private Shell shell;
    
    @Bean
    public CommandLineRunner exampleCommandLineRunner(ConfigurableEnvironment environment) {
        return new MyCommandLineRunner(shell, environment);
    }
    
    @Bean
    public ExitCodeExceptionMapper exitCodeExceptionMapper() {
        return exception -> {
            Throwable e = exception;
            while (e != null && !(e instanceof ExitRequest)) {
                e = e.getCause();
            }
            return e == null ? 1 : ((ExitRequest) e).status();
        };
    }
}



