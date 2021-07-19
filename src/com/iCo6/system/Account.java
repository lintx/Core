package com.iCo6.system;

public class Account {
    public String name;

    public Account(String name) {
        this.name = name;
    }

    public Holdings getHoldings() {
        return new Holdings(this.name);
    }
}
