package com.praktikum.data;

public class Item {
    private final String ItemName;
    private final String Description;
    private final String Location;
    private String Status;

    public Item(String itemName, String description, String location) {
        this.ItemName = itemName;
        this.Description = description;
        this.Location = location;
        this.Status = "Reported";
    }

    public String getItemName(){
        return ItemName;
    }

    public String getDescription(){
        return Description;
    }

    public String getLocation() {
        return Location;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}

