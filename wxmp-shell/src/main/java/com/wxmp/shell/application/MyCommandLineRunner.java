package com.wxmp.shell.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaohg
 * @date 2019/06/15.
 */
@Order(InteractiveShellApplicationRunner.PRECEDENCE - 2)
public class MyCommandLineRunner implements CommandLineRunner {
    
    private final ConfigurableEnvironment environment;
    private       Shell                   shell;
    
    public MyCommandLineRunner(Shell shell, ConfigurableEnvironment environment) {
        this.shell = shell;
        this.environment = environment;
    }
    
    @Override
    public void run(String... args) throws Exception {
        List<String> commandsToRun = Arrays.stream(args)
                .filter(w -> !w.startsWith("@"))
                .collect(Collectors.toList());
        if (!commandsToRun.isEmpty()) {
            InteractiveShellApplicationRunner.disable(environment);
            shell.run(new StringInputProvider(commandsToRun));
        }
    }
}
