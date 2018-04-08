package com.wordpress.necessitateapps.allot;


import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edit_email)
    TextInputEditText editEmail;
    @BindView(R.id.edit_pass)
    TextInputEditText editPass;
    @BindView(R.id.text_register)
    TextView textRegister;
    @BindView(R.id.text_forgotpass)
    TextView textForgotPass;


    @OnClick(R.id.button_login)
    public void login(View view) {

        String email = editEmail.getText().toString();
        String pass = editPass.getText().toString();

        message(email, pass);
    }


    @OnClick(R.id.text_skip)
    public void skip(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    private void message(String email, String pass){
        Snackbar.make(findViewById(R.id.login_frame), email+" "+pass, Snackbar.LENGTH_SHORT).show();
    }
}
