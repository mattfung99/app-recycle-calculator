package com.example.recyclingcalculator.model;

public class Form {
    // Create instance fields
    private String key;
    private int aluminum;
    private int plasticSmall;
    private int plasticLarge;
    private int drinkBoxSmall;
    private int drinkBoxLarge;
    private int glassSmall;
    private int glassLarge;
    private int pouch;
    private int bagBox;
    private int liquorPlasticSmall;
    private int liquorPlasticLarge;
    private int liquorGlassSmall;
    private int liquorGlassLarge;

    public Form(String key, int aluminum, int plasticSmall, int plasticLarge, int drinkBoxSmall, int drinkBoxLarge, int glassSmall, int glassLarge, int pouch, int bagBox, int liquorPlasticSmall, int liquorPlasticLarge, int liquorGlassSmall, int liquorGlassLarge) {
        this.key = key;
        this.aluminum = aluminum;
        this.plasticSmall = plasticSmall;
        this.plasticLarge = plasticLarge;
        this.drinkBoxSmall = drinkBoxSmall;
        this.drinkBoxLarge = drinkBoxLarge;
        this.glassSmall = glassSmall;
        this.glassLarge = glassLarge;
        this.pouch = pouch;
        this.bagBox = bagBox;
        this.liquorPlasticSmall = liquorPlasticSmall;
        this.liquorPlasticLarge = liquorPlasticLarge;
        this.liquorGlassSmall = liquorGlassSmall;
        this.liquorGlassLarge = liquorGlassLarge;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getAluminum() {
        return aluminum;
    }

    public void setAluminum(int aluminum) {
        this.aluminum = aluminum;
    }

    public int getPlasticSmall() {
        return plasticSmall;
    }

    public void setPlasticSmall(int plasticSmall) {
        this.plasticSmall = plasticSmall;
    }

    public int getPlasticLarge() {
        return plasticLarge;
    }

    public void setPlasticLarge(int plasticLarge) {
        this.plasticLarge = plasticLarge;
    }

    public int getDrinkBoxSmall() {
        return drinkBoxSmall;
    }

    public void setDrinkBoxSmall(int drinkBoxSmall) {
        this.drinkBoxSmall = drinkBoxSmall;
    }

    public int getDrinkBoxLarge() {
        return drinkBoxLarge;
    }

    public void setDrinkBoxLarge(int drinkBoxLarge) {
        this.drinkBoxLarge = drinkBoxLarge;
    }

    public int getGlassSmall() {
        return glassSmall;
    }

    public void setGlassSmall(int glassSmall) {
        this.glassSmall = glassSmall;
    }

    public int getGlassLarge() {
        return glassLarge;
    }

    public void setGlassLarge(int glassLarge) {
        this.glassLarge = glassLarge;
    }

    public int getPouch() {
        return pouch;
    }

    public void setPouch(int pouch) {
        this.pouch = pouch;
    }

    public int getBagBox() {
        return bagBox;
    }

    public void setBagBox(int bagBox) {
        this.bagBox = bagBox;
    }

    public int getLiquorPlasticSmall() {
        return liquorPlasticSmall;
    }

    public void setLiquorPlasticSmall(int liquorPlasticSmall) {
        this.liquorPlasticSmall = liquorPlasticSmall;
    }

    public int getLiquorPlasticLarge() {
        return liquorPlasticLarge;
    }

    public void setLiquorPlasticLarge(int liquorPlasticLarge) {
        this.liquorPlasticLarge = liquorPlasticLarge;
    }

    public int getLiquorGlassSmall() {
        return liquorGlassSmall;
    }

    public void setLiquorGlassSmall(int liquorGlassSmall) {
        this.liquorGlassSmall = liquorGlassSmall;
    }

    public int getLiquorGlassLarge() {
        return liquorGlassLarge;
    }

    public void setLiquorGlassLarge(int liquorGlassLarge) {
        this.liquorGlassLarge = liquorGlassLarge;
    }

    @Override
    public String toString() {
        return aluminum + "\n" + plasticSmall + "\n" + plasticLarge + "\n" + drinkBoxSmall + "\n" + drinkBoxLarge + "\n" + glassSmall + "\n" + glassLarge + "\n" + pouch + "\n" + bagBox + "\n" + liquorPlasticSmall + "\n" + liquorPlasticLarge + "\n" + liquorGlassSmall + "\n" + liquorGlassLarge;
    }
}