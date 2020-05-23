package com.example.prototipoanaquel;

public class Alerts {
    private String key, correct_location, idShelf_owner, message, tag_number, title;
    private String type;

    public Alerts() {
    }

    public Alerts(String key, String correct_location, String idShelf_owner, String message, String tag_number, String title, String type) {
        this.key = key;
        this.correct_location = correct_location;
        this.idShelf_owner = idShelf_owner;
        this.message = message;
        this.tag_number = tag_number;
        this.title = title;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCorrect_location() {
        return correct_location;
    }

    public void setCorrect_location(String correct_location) {
        this.correct_location = correct_location;
    }

    public String getIdShelf_owner() {
        return idShelf_owner;
    }

    public void setIdShelf_owner(String idShelf_owner) {
        this.idShelf_owner = idShelf_owner;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        return message;
    }
}
