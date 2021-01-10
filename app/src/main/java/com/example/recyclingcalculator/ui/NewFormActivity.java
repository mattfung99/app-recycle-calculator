package com.example.recyclingcalculator.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclingcalculator.R;
import com.example.recyclingcalculator.model.DataHandler;

import java.util.Objects;

public class NewFormActivity extends AppCompatActivity {
    // Reference the singleton instance
    private final DataHandler dHandler = DataHandler.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_form);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, NewFormActivity.class);
    }
}