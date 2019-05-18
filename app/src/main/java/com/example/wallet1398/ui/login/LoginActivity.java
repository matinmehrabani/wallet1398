package com.example.wallet1398.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.wallet1398.R;
import com.example.wallet1398.data.model.Confirmation;
import com.example.wallet1398.ui.pageActivity.PageActivity;

public class LoginActivity extends AppCompatActivity implements LoginInterface.View {

    EditText editText;
    Button button;
    String password;
    String phone;
    String uDid;
    RelativeLayout relativeLayout;
    LoginPresenter presenter;
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();


        phone = getIntent().getStringExtra("phone");
        uDid = getIntent().getStringExtra("uDid");
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          password = editText.getText().toString();
                                          presenter.bind(phone, uDid, android.os.Build.MODEL, password);

                                      }
                                  }
        );

    }


    @Override
    public void init() {
        button = findViewById(R.id.login);
        editText = findViewById(R.id.editpass);
        relativeLayout = findViewById(R.id.relativelayout);
        presenter = new LoginPresenter(LoginActivity.this);
    }

    @Override
    public void setConfirmation(Confirmation confirmation) {
        intent = new Intent(LoginActivity.this, PageActivity.class);
        startActivity(intent);

    }

    @Override
    public void snackBar() {
        Snackbar snackbar = Snackbar.make(relativeLayout, R.string.password2, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
