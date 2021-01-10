package com.example.recyclingcalculator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclingcalculator.R;
import com.example.recyclingcalculator.model.DataHandler;

public class MainActivity extends AppCompatActivity {
    // Reference the singleton instance
    private final DataHandler dHandler = DataHandler.getInstance();

    // UI Widgets
    private TextView textNotifier;
    private Button btnCalculateRefund;
    private Button btnNewForm;
    private Button btnLoadForm;
    private Button btnEditForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWidgets();
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnEditForm.setEnabled(dHandler.isFormLoaded());
        textNotifier.setText(
                dHandler.isFormLoaded() ?
                getString(R.string.display_current_form) :
                getString(R.string.display_current_form_default)
        );
    }

    private void setupWidgets() {
        setupReferences();
        setupNewForm();
        setupLoadForm();
        setupEditForm();
        setupCalculateRefund();
    }

    private void setupReferences() {
        textNotifier = (TextView)findViewById(R.id.textNotifier);
        btnCalculateRefund = (Button)findViewById(R.id.btnCalculateRefund);
        btnNewForm = (Button)findViewById(R.id.btnNewForm);
        btnLoadForm = (Button)findViewById(R.id.btnLoadForm);
        btnEditForm = (Button)findViewById(R.id.btnEditForm);
    }

    private void setupCalculateRefund() {
        btnCalculateRefund.setOnClickListener(v -> {
            Intent calculateRefundIntent = CalculateRefundActivity.makeIntent(MainActivity.this);
            startActivity(calculateRefundIntent);
        });
    }

    private void setupNewForm() {
        btnNewForm.setOnClickListener(v -> {
            Intent newFormIntent = NewFormActivity.makeIntent(MainActivity.this);
            startActivity(newFormIntent);
        });
    }

    private void setupLoadForm() {
        btnLoadForm.setOnClickListener(v -> {
            Intent loadFormIntent = LoadFormActivity.makeIntent(MainActivity.this);
            startActivity(loadFormIntent);
        });
    }
      
    private void setupEditForm() {
        btnEditForm.setOnClickListener(v -> {
            Intent editFormIntent = NewFormActivity.makeIntent(MainActivity.this);
            startActivity(editFormIntent);
        });
    }
}