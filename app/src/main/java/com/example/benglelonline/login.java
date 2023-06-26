package com.example.benglelonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benglelonline.helper.Helper;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {

    Helper db;
    EditText textEmail, textPassword;
    ImageButton btnLogin;
    TextView btndaftar, btnForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new Helper(this);

        textEmail = (EditText)findViewById(R.id.email);
        textPassword = (EditText)findViewById(R.id.password);
        btnLogin = (ImageButton) findViewById(R.id.btnLogin);
        btndaftar = (TextView) findViewById(R.id.daftar);
        btnForgot = (TextView) findViewById(R.id.lupapassword);


        //register
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftarintent = new Intent(login.this, register.class);
                startActivity(daftarintent);
            }
        });

        //login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = textEmail.getText().toString();
                String strPassword = textPassword.getText().toString();
                Boolean masuk = db.checkLogin(strEmail,strPassword);
                if (masuk == true){
                    Boolean updateSession = db.upgradeSession("ada",1);
                    if (updateSession == true){
                        Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                        Intent mainIntent = new Intent(login.this, MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Masuk Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lupapassword = new Intent(login.this, forgot.class);
                startActivity(lupapassword);
            }
        });
    }
}