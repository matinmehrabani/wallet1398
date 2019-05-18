package com.example.wallet1398;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.wallet1398.data.model.User;
import com.example.wallet1398.ui.login.LoginActivity;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity implements MainInterface.View {


    Button button;
    MainPresenter presenter;
    MainHelper helper;
    String id;
    TextInputLayout editText;
    TextInputEditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        id = android.provider.Settings.System.getString(super.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    presenter.getPassword("" + editText1.getText().toString(), "" + helper.SHA1(id));

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void setUser(User user) {
        //TODO:
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.putExtra("phone", user.getPhone());
        intent.putExtra("udid", user.getUdid());
        startActivity(intent);

    }

    @Override
    public void init() {
        editText = findViewById(R.id.edit);
        button = findViewById(R.id.claim);
        presenter = new MainPresenter(MainActivity.this);
        helper = new MainHelper();
        editText1 = findViewById(R.id.name_edit_text);
    }


}
