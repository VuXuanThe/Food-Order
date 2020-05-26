package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextView tvNoticeUser, tvNoticePassword;
    Button btnShowPassword, btnLogin;
    TextInputEditText TIedtUsername, TIedtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Delete Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        inIt();
        showPassword();
        login();
    }

    private void inIt(){
        TIedtPassword       = findViewById(R.id.TIedtPassword);
        TIedtUsername       = findViewById(R.id.TIedtUsername);
        btnLogin            = findViewById(R.id.btnLogin);
        btnShowPassword     = findViewById(R.id.btnShowPassword);
        tvNoticePassword    = findViewById(R.id.tvNoticePassword);
        tvNoticeUser        = findViewById(R.id.tvNoticeUser);
    }

    //Hien thi password
    private void showPassword(){
        btnShowPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    TIedtPassword.setTransformationMethod(new PasswordTransformationMethod());
                    TIedtPassword.setSelection(TIedtPassword.getText().length());
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    TIedtPassword.setTransformationMethod(null);
                }
                return false;
            }
        });
    }

    private void login(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passWord = TIedtPassword.getText().toString();
                String userName = TIedtUsername.getText().toString();
                if(passWord.isEmpty() && userName.isEmpty()){
                    tvNoticePassword.setText(getResources().getString(R.string.Notice_EnterPassword));
                    tvNoticeUser.setText(getResources().getString(R.string.Notice_EnterUsername));
                }
                if(passWord.isEmpty()){
                    tvNoticePassword.setText(getResources().getString(R.string.Notice_EnterPassword));
                    tvNoticeUser.setText("");
                }
                if(userName.isEmpty()){
                    tvNoticeUser.setText(getResources().getString(R.string.Notice_EnterUsername));
                    tvNoticePassword.setText("");
                }
                if(passWord.isEmpty() == false && userName.isEmpty() == false){
                    Intent intent = new Intent(getBaseContext(), Food_order.class);
                    startActivity(intent);
                }
            }
        });
    }
}
