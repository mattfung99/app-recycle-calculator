package com.example.recyclingcalculator.model;

public class DataHandler {
    // Create instance fields
    private static DataHandler instance;
    private Form form;
    private boolean isFormLoaded;

    public static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public boolean isFormLoaded() {
        return isFormLoaded;
    }

    public void setFormLoaded(boolean formLoaded) {
        isFormLoaded = formLoaded;
    }
}
