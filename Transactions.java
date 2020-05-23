package com.example.prototipoanaquel;

public class Transactions {
    private String key, idShelf_owner, loanTime, tag_number, title;
    private int counter;

    public Transactions() {
    }

    public Transactions(String key, String idShelf_owner, String loanTime, String tag_number, String title, int counter) {
        this.key = key;
        this.idShelf_owner = idShelf_owner;
        this.loanTime = loanTime;
        this.tag_number = tag_number;
        this.title = title;
        this.counter = counter;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIdShelf_owner() {
        return idShelf_owner;
    }

    public void setIdShelf_owner(String idShelf_owner) {
        this.idShelf_owner = idShelf_owner;
    }

    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime;
    }

    public String getTag_number() {
        return tag_number;
    }

    public void setTag_number(String tag_number) {
        this.tag_number = tag_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
