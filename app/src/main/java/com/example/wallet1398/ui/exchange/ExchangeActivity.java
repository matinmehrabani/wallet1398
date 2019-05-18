package com.example.wallet1398.ui.exchange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.wallet1398.R;
import com.example.wallet1398.data.model.Rates;

import java.util.ArrayList;
import java.util.List;

public class ExchangeActivity extends AppCompatActivity implements ExchangeInterface.View {

    EditText base;
    EditText converted;
    Spinner spinner;
    int position;
    Float buy;
    int bases;
    int id;
    int Converted;
    boolean foCus;
    Toolbar toolbar;
    ExchangePresenter presenter;
    List<Rates> list;

    @Override
    public void setRates(List<Rates> lists) {
        list.addAll(lists);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        init();
        spinner();
        presenter.getRates();
        base.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    foCus = true;
                } else {
                    foCus = false;
                }
            }
        });

        base.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                switch (spinner.getSelectedItem().toString()) {

                    case "USD":
                        position = 2;
                        break;
                    case "ALP":
                        position = 3;
                        break;
                    case "Euro":
                        position = 4;
                        break;
                }
                id = list.get(position).getId();
                buy = list.get(id).getBuy();
                if (foCus == true) {
                    if (s.length() != 0) {
                        bases = Integer.parseInt(base.getText().toString());
                        converted.setText("" + bases * buy);
                    } else {
                        converted.setText("");
                    }

                }

            }
        });

        converted.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                id = list.get(position).getId();
                buy = list.get(id).getBuy();
                if (foCus == false) {

                    if (s.length() == 0) {
                        base.setText("");
                    }
                    else{
                        Converted = Integer.parseInt(converted.getText().toString());
                        base.setText("" + Converted * buy);

                    }

                }

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
        base = findViewById(R.id.base);
        converted = findViewById(R.id.converted);
        spinner = findViewById(R.id.spinner);
        toolbar = findViewById(R.id.toolbarchange);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        presenter = new ExchangePresenter(ExchangeActivity.this);
        list = new ArrayList<>();
    }

    @Override
    public void spinner() {
        final String[] currency = getResources().getStringArray(R.array.wallet);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currency);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}






