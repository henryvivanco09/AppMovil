package com.example.prototipoanaquel;

public class Anaquels {

    private String state, tag_number;

    public Anaquels() {
    }

    public Anaquels(String state, String tag_number) {
        this.state = state;
        this.tag_number = tag_number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTag_number() {
        return tag_number;
    }

    public void setTag_number(String tag_number) {
        this.tag_number = tag_number;
    }
}

