package com.wxmp.shell.standard;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

/**
 * Showcases dynamic command availability.
 * @author Eric Bottard
 */
@ShellComponent
public class DynamicCommands {
    
    private boolean connected;
    
    private boolean authenticated;
    
    public Availability authenticateAvailability() {
        return connected ? Availability.available() : Availability.unavailable("you are not connected");
    }
    
    @ShellMethod(value = "Authenticate with the system", group = "Dynamic Commands")
    public void authenticate(String credentials) {
        authenticated = "sesame".equals(credentials);
    }
    
    @ShellMethod(value = "Connect to the system", group = "Dynamic Commands")
    public void connect() {
        connected = true;
    }
    
    @ShellMethod(value = "Disconnect from the system", group = "Dynamic Commands")
    public void disconnect() {
        connected = false;
    }
    
    @ShellMethod(value = "Blow Everything up", group = "Dynamic Commands")
    @ShellMethodAvailability("dangerousAvailability")
    public String blowUp() {
        return "Boom!";
    }
    
    private Availability dangerousAvailability() {
        return connected && authenticated ? Availability.available() : Availability.unavailable("you failed to authenticate. Try 'sesame'.");
    }
}
