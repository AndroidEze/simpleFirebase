package me.ezeezegg.simplefirebase.models;

/**
 * Created by egarcia on 11/6/15.
 */
public class ToDoItem {
    String username;
    String item;
    boolean completed;

    public ToDoItem(){ }

    public ToDoItem(String username, String item, boolean completed){
        this.username = username;
        this.item = item;
        this.completed = completed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
