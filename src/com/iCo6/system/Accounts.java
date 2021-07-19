package com.iCo6.system;

public class Accounts {
    public Accounts() { }

    public boolean exists(String name) {
        return true;
    }

    public Account get(String name) {
        return new Account(name);
    }

    public boolean create(String name) {
        return true;
    }
}