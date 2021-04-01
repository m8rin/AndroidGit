package com.example.lab8;

public class User {
    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String toString() { return name; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
