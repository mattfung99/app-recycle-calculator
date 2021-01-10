package com.example.recyclingcalculator.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclingcalculator.R;
import com.example.recyclingcalculator.model.DataHandler;
import com.example.recyclingcalculator.model.Form;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.Objects;

public class LoadFormActivity extends AppCompatActivity {
    // Reference the singleton instance
    private final DataHandler dHandler = DataHandler.getInstance();

    // Reference Firebase
    private final DatabaseReference fireBaseRef = FirebaseDatabase.getInstance().getReference();

    // UI Widgets
    private EditText enterKey;
    private Button btnFetchForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_form);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setupWidgets();
        setupFetchFormButton();
    }

    private void setupWidgets() {
        enterKey = (EditText)findViewById(R.id.enterKey);
        btnFetchForm = (Button)findViewById(R.id.btnFetchForm);
    }

    private void setupFetchFormButton() {
        btnFetchForm.setOnClickListener(v -> {
            if (enterKey.getText().toString().matches(getString(R.string.empty_string))) {
                Toast.makeText(this, getString(R.string.toast_empty_key), Toast.LENGTH_SHORT).show();
            } else {
                findKey();
            }
        });
    }

    private void findKey() {
        fireBaseRef.orderByKey().equalTo(enterKey.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Gson gson = new Gson();
                    String str = gson.toJson(dataSnapshot.getValue());
//                    System.out.println(str);
//                    Form form = gson.fromJson(str, Form.class);
//                    System.out.println(form);
//                    dHandler.setForm(form);

                    dHandler.setForm(dataSnapshot.getValue(Form.class));

                    dHandler.setFormLoaded(true);
//                    System.out.println(dataSnapshot.getValue());
                } else {
                    Toast.makeText(LoadFormActivity.this, getString(R.string.toast_key_dne), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }


    public static Intent makeIntent(Context context) {
        return new Intent(context, LoadFormActivity.class);
    }
}