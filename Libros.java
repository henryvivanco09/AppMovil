package com.example.prototipoanaquel;

public class Libros {
    private String  state, edition_number, idShelf, tag_number, loanTime, returnTime, location;
    private String title, author, key;

    public Libros() {
    }

    public Libros(String state, String edition_number, String idShelf, String tag_number, String loanTime, String returnTime, String location, String title, String author, String key) {
        this.state = state;
        this.edition_number = edition_number;
        this.idShelf = idShelf;
        this.tag_number = tag_number;
        this.loanTime = loanTime;
        this.returnTime = returnTime;
        this.location = location;
        this.title = title;
        this.author = author;
        this.key = key;
    }


    public String getEdition_number() {
        return edition_number;
    }

    public void setEdition_number(String edition_number) {
        this.edition_number = edition_number;
    }

    public String getIdShelf() {
        return idShelf;
    }

    public void setIdShelf(String idShelf) {
        this.idShelf = idShelf;
    }

    public String getTag_number() {
        return tag_number;
    }

    public void setTag_number(String tag_number) {
        this.tag_number = tag_number;
    }

    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toString(){
        return title;
    }
}