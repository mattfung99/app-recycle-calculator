package com.example.recyclingcalculator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclingcalculator.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWidgets();
        start();
    }

    private void setupWidgets() {
        setupNewForm();
        setupLoadForm();
    }

    private void setupNewForm() {
        Button btnNewForm = (Button)findViewById(R.id.btnNewForm);
        btnNewForm.setOnClickListener(v -> {
            Intent newFormIntent = NewFormActivity.makeIntent(MainActivity.this);
            startActivity(newFormIntent);
        });
    }

    private void setupLoadForm() {
        Button btnLoadForm = (Button)findViewById(R.id.btnLoadForm);
        btnLoadForm.setOnClickListener(v -> {
            Intent loadFormIntent = LoadFormActivity.makeIntent(MainActivity.this);
            startActivity(loadFormIntent);
        });
    }


    private void start(){
        int a = 1;
        int b = 2;
        int c = 3;
        HashMap<String, Object> users = new HashMap<>();
        Test t = new Test(a,b,c);
        users.put("Steven",t);
        users.put("Matt","test2");
        FirebaseDatabase.getInstance().getReference().child("saved-list").child("name").setValue(users);
    }
}