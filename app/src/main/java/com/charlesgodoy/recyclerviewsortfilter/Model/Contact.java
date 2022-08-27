package com.charlesgodoy.recyclerviewsortfilter.Model;

public class Contact {

    // Model class to get json variables

    private int id;
    private int listId;
    private String name;

    public Contact(int id, int listId, String name) {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }
}
