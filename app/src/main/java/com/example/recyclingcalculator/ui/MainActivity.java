package com.example.recyclingcalculator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclingcalculator.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWidgets();
    }

    private void setupWidgets() {
        setupNewForm();
        setupLoadForm();
        setupEditForm();
        setupCalculateRefund();
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

    private void setupEditForm() {
        Button btnEditForm = (Button)findViewById(R.id.btnEditForm);
        btnEditForm.setOnClickListener(v -> {
            Intent editFormIntent = NewFormActivity.makeIntent(MainActivity.this);
            startActivity(editFormIntent);
        });
    }

    private void setupCalculateRefund() {
        Button btnCalculateRefund = (Button)findViewById(R.id.btnCalculateRefund);
        btnCalculateRefund.setOnClickListener(v -> {
            Intent calculateRefundIntent = CalculateRefundActivity.makeIntent(MainActivity.this);
            startActivity(calculateRefundIntent);
        });
    }
}