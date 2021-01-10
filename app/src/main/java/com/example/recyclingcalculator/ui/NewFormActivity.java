package com.example.recyclingcalculator.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import java.util.HashMap;
import java.util.Objects;

public class NewFormActivity extends AppCompatActivity {
    // Reference the singleton instance
    private final DataHandler dHandler = DataHandler.getInstance();
    private Form form;

    // Reference Firebase
    private final DatabaseReference fireBaseRef = FirebaseDatabase.getInstance().getReference();

    // UI Widgets
    private TextView textDisplayFormName;
    private Button btnCreate;
    private EditText stringKey;
    private final EditText[] editTextWidgets = new EditText[13];

    // Flags
    private boolean isKeyFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_form);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setupWidgets();
        displayActivityState();
        setupCreateButton();
    }

    private void setupWidgets() {
        textDisplayFormName = (TextView)findViewById(R.id.textDisplayFormName);
        btnCreate = (Button)findViewById(R.id.btnCreate);
        stringKey = (EditText)findViewById(R.id.stringKey);
        editTextWidgets[0] = (EditText)findViewById(R.id.numAluminum);
        editTextWidgets[1] = (EditText)findViewById(R.id.numPlastic);
        editTextWidgets[2] = (EditText)findViewById(R.id.numPlasticAlt);
        editTextWidgets[3] = (EditText)findViewById(R.id.numDrinkBox);
        editTextWidgets[4]= (EditText)findViewById(R.id.numDrinkBoxAlt);
        editTextWidgets[5] = (EditText)findViewById(R.id.numGlass);
        editTextWidgets[6] = (EditText)findViewById(R.id.numGlassAlt);
        editTextWidgets[7] = (EditText)findViewById(R.id.numPouch);
        editTextWidgets[8] = (EditText)findViewById(R.id.numBagBox);
        editTextWidgets[9] = (EditText)findViewById(R.id.numLiquorPlastic);
        editTextWidgets[10] = (EditText)findViewById(R.id.numLiquorPlasticAlt);
        editTextWidgets[11] = (EditText)findViewById(R.id.numLiquorGlass);
        editTextWidgets[12] = (EditText)findViewById(R.id.numLiquorGlassAlt);
    }

    private void displayActivityState() {
        if (getIntent().getBooleanExtra("edit", false)) {
            setTitle(getString(R.string.btn_edit_form));
            textDisplayFormName.setVisibility(View.VISIBLE);
            form = dHandler.getForm();
            textDisplayFormName.setText(getString(R.string.display_form_name, form.getKey()));
            setDefaultFields();
            btnCreate.setText(getString(R.string.btn_save_form));
        } else {
            setTitle(getString(R.string.btn_create_form));
            textDisplayFormName.setVisibility(View.INVISIBLE);
            btnCreate.setText(getString(R.string.btn_create_form));
        }
    }

    private void setDefaultFields() {
        stringKey.setText(form.getKey());
        editTextWidgets[0].setText(String.valueOf(form.getAluminum()));
        editTextWidgets[1].setText(String.valueOf(form.getPlasticSmall()));
        editTextWidgets[2].setText(String.valueOf(form.getPlasticLarge()));
        editTextWidgets[3].setText(String.valueOf(form.getDrinkBoxSmall()));
        editTextWidgets[4].setText(String.valueOf(form.getDrinkBoxLarge()));
        editTextWidgets[5].setText(String.valueOf(form.getGlassSmall()));
        editTextWidgets[6].setText(String.valueOf(form.getGlassLarge()));
        editTextWidgets[7].setText(String.valueOf(form.getPouch()));
        editTextWidgets[8].setText(String.valueOf(form.getBagBox()));
        editTextWidgets[9].setText(String.valueOf(form.getLiquorPlasticSmall()));
        editTextWidgets[10].setText(String.valueOf(form.getLiquorPlasticLarge()));
        editTextWidgets[11].setText(String.valueOf(form.getLiquorGlassSmall()));
        editTextWidgets[12].setText(String.valueOf(form.getLiquorGlassLarge()));
    }

    private void setupCreateButton() {
        btnCreate.setOnClickListener(v -> {
            if (getIntent().getBooleanExtra("edit", false)) {
                editForm();
            } else {
                createForm();
            }
        });
    }

    private boolean validateFields() {
        for (EditText eInput : editTextWidgets) {
            String strIn = eInput.getText().toString();
            if ((strIn.matches(getString(R.string.empty_string))) || (strIn.contains("-")) || (strIn.charAt(0) == '0' && strIn.length() > 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateKey() {
        return stringKey.getText().toString().matches(getString(R.string.empty_string));
    }

    private void findKey() {
        fireBaseRef.orderByKey().equalTo(stringKey.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                isKeyFound = dataSnapshot.exists();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    private void editForm() {
        if (validateKey()) {
            Toast.makeText(this, getString(R.string.toast_empty_key), Toast.LENGTH_SHORT).show();
        } else if(isKeyFound) {
            if (stringKey.getText().toString().matches(form.getKey())) {
                fillForm();
                Toast.makeText(this, getString(R.string.toast_form_saved), Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, getString(R.string.toast_key_exists), Toast.LENGTH_SHORT).show();
            }
        } else if(validateFields()) {
            Toast.makeText(this, getString(R.string.toast_invalid_fields), Toast.LENGTH_SHORT).show();
        } else {
            fillForm();
            Toast.makeText(this, getString(R.string.toast_form_saved), Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void createForm() {
        findKey();
        if (validateKey()) {
            Toast.makeText(this, getString(R.string.toast_empty_key), Toast.LENGTH_SHORT).show();
        } else if(isKeyFound) {
            Toast.makeText(this, getString(R.string.toast_key_exists), Toast.LENGTH_SHORT).show();
        } else if(validateFields()) {
            Toast.makeText(this, getString(R.string.toast_invalid_fields), Toast.LENGTH_SHORT).show();
        } else {
            fillForm();
            Toast.makeText(this, getString(R.string.toast_form_created), Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void fillForm() {
        dHandler.setForm(
            new Form(
                stringKey.getText().toString(),
                Integer.parseInt(editTextWidgets[0].getText().toString()),
                Integer.parseInt(editTextWidgets[1].getText().toString()),
                Integer.parseInt(editTextWidgets[2].getText().toString()),
                Integer.parseInt(editTextWidgets[3].getText().toString()),
                Integer.parseInt(editTextWidgets[4].getText().toString()),
                Integer.parseInt(editTextWidgets[5].getText().toString()),
                Integer.parseInt(editTextWidgets[6].getText().toString()),
                Integer.parseInt(editTextWidgets[7].getText().toString()),
                Integer.parseInt(editTextWidgets[8].getText().toString()),
                Integer.parseInt(editTextWidgets[9].getText().toString()),
                Integer.parseInt(editTextWidgets[10].getText().toString()),
                Integer.parseInt(editTextWidgets[11].getText().toString()),
                Integer.parseInt(editTextWidgets[12].getText().toString())
            )
        );
        saveToFirebase();
        dHandler.setFormLoaded(true);
    }

    private void saveToFirebase() {
//        Form currForm = dHandler.getForm();
//        fireBaseRef.child(currForm.getKey()).setValue(currForm);
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", dHandler.getForm().getKey());
        map.put("aluminum", dHandler.getForm().getAluminum());
        map.put("plasticSmall", dHandler.getForm().getPlasticSmall());
        map.put("plasticLarge", dHandler.getForm().getPlasticLarge());
        map.put("drinkBoxSmall", dHandler.getForm().getDrinkBoxSmall());
        map.put("drinkBoxLarge", dHandler.getForm().getDrinkBoxLarge());
        map.put("glassSmall", dHandler.getForm().getGlassSmall());
        map.put("glassLarge", dHandler.getForm().getGlassLarge());
        map.put("pouch", dHandler.getForm().getPouch());
        map.put("bagBox", dHandler.getForm().getBagBox());
        map.put("liquorPlasticSmall", dHandler.getForm().getLiquorPlasticSmall());
        map.put("liquorPlasticLarge", dHandler.getForm().getLiquorPlasticLarge());
        map.put("liquorGlassSmall", dHandler.getForm().getLiquorGlassSmall());
        map.put("liquorGlassLarge", dHandler.getForm().getLiquorGlassLarge());

        fireBaseRef.child(dHandler.getForm().getKey()).setValue(map);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, NewFormActivity.class);
    }
}