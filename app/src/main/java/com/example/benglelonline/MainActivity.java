package com.example.benglelonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benglelonline.helper.Helper;

public class MainActivity extends AppCompatActivity {

    Helper db;
    ImageButton bengkel,tambalBan,gantiBan,btnLogout;
    TextView catatanPengeluaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Helper(this);
        btnLogout = (ImageButton) findViewById(R.id.btnLogout);
        bengkel = (ImageButton) findViewById(R.id.btnTambalBan);
        tambalBan = (ImageButton) findViewById(R.id.btnTambahAngin);
        gantiBan = (ImageButton) findViewById(R.id.btnGantiBan);
        catatanPengeluaran = (TextView) findViewById(R.id.namaPengguna);


        Boolean checkSession = db.checkSession("ada");
        if (checkSession == false){
            Intent loginIntent = new Intent(MainActivity.this, login.class);
            startActivity(loginIntent);
            finish();
        }


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean updateSession = db.upgradeSession("kosong",1);
                if (updateSession == true){
                    Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(MainActivity.this, login.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });

        bengkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText (getApplicationContext (), "Bengkel Terdekat", Toast.LENGTH_SHORT).show ();
                Intent bengkel = new Intent(MainActivity.this, MapsFragment.class);
                MainActivity.this.startActivity(bengkel);
            }
        });

        tambalBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Tambal Ban Terdekat", Toast.LENGTH_SHORT).show();
                Intent tambalBan = new Intent(MainActivity.this, MapsTambalBan.class);
                MainActivity.this.startActivity(tambalBan);
            }
        });

        gantiBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ganti Ban Terdekat", Toast.LENGTH_SHORT).show();
                Intent gantiban = new Intent(MainActivity.this, MapsGantiBan.class);
                MainActivity.this.startActivity(gantiban);
            }
        });

        catatanPengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pengeluaran = new Intent(MainActivity.this, Pengeluaran.class);
                startActivity(pengeluaran);
            }
        });

    }
}
