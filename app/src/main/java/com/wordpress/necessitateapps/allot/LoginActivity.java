package com.wordpress.necessitateapps.allot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
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

    @OnClick(R.id.text_register)
    public void changeCard(final View view){
        final View card=findViewById(R.id.card_login);
        TranslateAnimation animate = new TranslateAnimation(
                0,
                0,
                0,
                card.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);
        card.startAnimation(animate);
        card.setVisibility(View.GONE);
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
