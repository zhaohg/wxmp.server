package com.wxmp.shell.standard;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ConversionCommands {
    
    @ShellMethod("Shows conversion using Spring converter")
    public Object conversionExample(DomainObject object) {
        return object;
    }
    
}


