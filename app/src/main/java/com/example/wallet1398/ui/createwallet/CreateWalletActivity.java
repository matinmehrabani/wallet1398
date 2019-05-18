package com.example.wallet1398.ui.createwallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.wallet1398.R;

import java.util.ArrayList;
import java.util.List;


public class CreateWalletActivity extends AppCompatActivity implements CreateWalletInterface.View {

    Spinner spinner;
    EditText editText;
    Button add;
    Button show;
    MethodRealm methodRealms;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craete);
        init();
        spinner();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString() ==null) {
                    methodRealms.saveData(getApplicationContext(), String.valueOf(spinner.getSelectedItem()));
                } else {
                    methodRealms.saveData(getApplicationContext(), editText.getText().toString());
                }

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodRealms.showData();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void init() {
        spinner = findViewById(R.id.spinner);
        editText = findViewById(R.id.name);
        add = findViewById(R.id.add);
        show = findViewById(R.id.showdata);
        toolbar = findViewById(R.id.toolbarwallet);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        methodRealms = new MethodRealm();
    }

    @Override
    public void spinner() {
        List<String> wallet = new ArrayList<>();
        wallet.add("Dollar");
        wallet.add("Alpha");
        wallet.add("Euro");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, wallet);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
