package com.example.wallet1398.ui.listcurrencies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.wallet1398.R;
import com.example.wallet1398.data.model.Currencies;

import java.util.List;

public class CurrenciesActivity extends AppCompatActivity implements CurrenciesInterface.View {

    RecyclerView recyclerView;
    Toolbar toolbar;
    CurrenciesPresenter presenter;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencies);

        init();
        presenter.getCurrencies();
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
        recyclerView = findViewById(R.id.recyclerview);
        toolbar = findViewById(R.id.toolbarcurrencies);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        presenter = new CurrenciesPresenter(CurrenciesActivity.this);

    }

    @Override
    public void setCurrencies(List<Currencies> list) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        adapter = new MyAdapter(CurrenciesActivity.this, list);
        recyclerView.setAdapter(adapter);
    }
}

