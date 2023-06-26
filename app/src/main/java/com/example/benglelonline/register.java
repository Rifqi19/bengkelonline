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

public class register extends AppCompatActivity {

    Helper db;
    EditText textNama, textEmail, textPassword, textPassword2;
    ImageButton btnRegister;
    TextView tmblMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new Helper(this);

        textNama = (EditText)findViewById(R.id.nama);
        textEmail = (EditText) findViewById(R.id.email);
        textPassword = (EditText) findViewById(R.id.password);
        textPassword2 = (EditText) findViewById(R.id.password2);
        btnRegister = (ImageButton) findViewById(R.id.btnDaftar);
        tmblMasuk = (TextView) findViewById(R.id.masuk);

        //login
        tmblMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent masukIntent = new Intent(register.this, login.class);
                startActivity(masukIntent);
                finish();
            }
        });

        //register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strNama = textNama.getText().toString();
                String strEmail = textEmail.getText().toString();
                String strPassword = textPassword.getText().toString();
                String strPassword2 = textPassword2.getText().toString();
                if (strPassword.equals(strPassword2)){
                    Boolean daftar = db.insertUser(strNama, strEmail,strPassword);
                    if (daftar == true){
                        Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                        Intent masukIntent = new Intent(register.this, login.class);
                        startActivity(masukIntent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Password Tidak Sama", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}