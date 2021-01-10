package com.example.recyclingcalculator.ui;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;


public class Test {


    private int aluminum;
    private int glass;
    private int plastic;

    public Test(){}

    public Test(int aluminum, int glass, int plastic) {
        this.aluminum = aluminum;
        this.glass = glass;
        this.plastic = plastic;
    }

    public int getAluminum(){
        return this.aluminum;
    }

    public int getGlass(){
        return this.glass;
    }

    public int getPlastic(){
        return this.plastic;
    }

}