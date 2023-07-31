package com.example.model;

public class Server {
    private String name;
    private boolean valid;

    public Server() {
    }

    public Server(String name) {
        this.name = name;
    }

    // Getter for 'name'
    public String getName() {
        return name;
    }

    // Setter for 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Setter for 'valid'
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    // Getter for 'valid'
    public boolean isValid() {
        return valid;
    }
}
