package com.example.recyclingcalculator.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclingcalculator.R;
import java.util.Objects;

public class CalculateRefundActivity extends AppCompatActivity {
    private EditText aluminum;
    private EditText plastic;
    private EditText plastic_alt;
    private EditText drinkBox;
    private EditText drinkBox_alt;
    private EditText glass;
    private EditText glass_alt;
    private EditText pouch;
    private EditText bagBox;
    private EditText liquorPlastic;
    private EditText liquorPlastic_alt;
    private EditText liquorGlass;
    private EditText liquorGlass_alt;


    private double prevAmountAluminum = 0;
    private double prevAmountPlastic = 0;
    private double prevAmountPlastic_alt = 0;
    private double prevAmountDrinkBox = 0;
    private double prevAmountDrinkBox_alt = 0;
    private double prevAmountGlass = 0;
    private double prevAmountGlass_alt = 0;
    private double prevAmountPouch = 0;
    private double prevAmountBagBox = 0;
    private double prevAmountLiquorPlastic = 0;
    private double prevAmountLiquorPlastic_alt = 0;
    private double prevAmountLiquorGlass = 0;
    private double prevAmountLiquorGlass_alt = 0;

    public double toRemove = 0;
    public TextView totalText;
    public String total;
    public double totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_refund);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        update();
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, CalculateRefundActivity.class);
    }

    private void calculate(EditText num, TextView sentence, double price, String id, double prevAmount) {
        int value = Integer.parseInt(num.getText().toString());
        double temp = Double.valueOf(value * price);
        int resID = getResources().getIdentifier(id, "id", getPackageName());
        //String s = id + getString(value, temp);
        //sentence.setText(getString(resID, value, temp));
        calculateTotal(temp, prevAmount);
        totalText.setText(getString(R.string.total_refund, totalAmount));

    }

    private void update(){
        aluminum = findViewById(R.id.numAluminum);
        plastic = findViewById(R.id.numPlastic);
        plastic_alt = findViewById(R.id.numPlasticAlt);
        drinkBox = findViewById(R.id.numDrinkBox);
        drinkBox_alt = findViewById(R.id.numDrinkBoxAlt);
        glass = findViewById(R.id.numGlass);
        glass_alt = findViewById(R.id.numGlassAlt);
        pouch = findViewById(R.id.numPouch);
        bagBox = findViewById(R.id.numBagBox);
        liquorPlastic = findViewById(R.id.numLiquorPlastic);
        liquorPlastic_alt = findViewById(R.id.numLiquorPlasticAlt);
        liquorGlass = findViewById(R.id.numLiquorGlass);
        liquorGlass_alt = findViewById(R.id.numLiquorGlassAlt);
        totalText = findViewById(R.id.labelTotalRefund);
        total = totalText.getText().toString();
        addTextListener(aluminum,  findViewById(R.id.labelAluminum), 0.10, getString(R.string.calc_label_aluminum), prevAmountAluminum);
        addTextListener(plastic, findViewById(R.id.labelPlastic), 0.13, getString(R.string.calc_label_plastic), prevAmountPlastic);
        addTextListener(plastic_alt, findViewById(R.id.labelPlasticAlt), 0.15, getString(R.string.calc_label_plastic_alt), prevAmountPlastic_alt);
        addTextListener(drinkBox, findViewById(R.id.labelDrinkBox), 0.10, getString(R.string.calc_label_drink_box), prevAmountDrinkBox);
        addTextListener(drinkBox_alt, findViewById(R.id.labelDrinkBoxAlt), 0.15, getString(R.string.calc_label_drink_box_alt), prevAmountDrinkBox_alt);
        addTextListener(glass, findViewById(R.id.labelGlass), 0.17, getString(R.string.calc_label_glass), prevAmountGlass);
        addTextListener(glass_alt, findViewById(R.id.labelGlassAlt), 0.28, getString(R.string.calc_label_liquor_glass_alt), prevAmountGlass_alt);
        addTextListener(pouch, findViewById(R.id.labelPouch), 0.10, getString(R.string.calc_label_pouch), prevAmountPouch);
        addTextListener(bagBox, findViewById(R.id.labelBagBox), 0.17, getString(R.string.calc_label_bag), prevAmountBagBox);
        addTextListener(liquorPlastic, findViewById(R.id.labelLiquorPlastic), 0.13, getString(R.string.calc_label_liquor_plastic), prevAmountLiquorPlastic);
        addTextListener(liquorPlastic_alt, findViewById(R.id.labelLiquorPlasticAlt), 0.16, getString(R.string.calc_label_liquor_plastic_alt), prevAmountLiquorPlastic_alt);
        addTextListener(liquorGlass, findViewById(R.id.labelLiquorGlass), 0.24, getString(R.string.calc_label_liquor_glass), prevAmountLiquorGlass);
        addTextListener(liquorGlass_alt, findViewById(R.id.labelLiquorGlassAlt), 0.28, getString(R.string.calc_label_liquor_glass_alt), prevAmountLiquorGlass_alt);


    }

    private void addTextListener(EditText text, TextView sentence, double price, String id, double prevAmount) {
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (text.getText().toString().length() == 0)
                    calculate(text, sentence, 0, id, prevAmount);
                calculate(text, sentence, price, id, prevAmount);

            }
        };
            text.addTextChangedListener(watcher);
    }

    private void calculateTotal(double cost, double prevAmount){
        totalAmount += cost;
        totalAmount -= prevAmount;
        prevAmount = cost;
    }

}