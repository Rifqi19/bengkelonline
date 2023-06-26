package com.example.benglelonline;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benglelonline.helper.Helper;

public class TambahData extends AppCompatActivity {

    Helper db;
    Button simpan;
    EditText keterangan, tanggal, nominal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        db = new Helper(this);
        tanggal = (EditText) findViewById(R.id.tanggal);
        keterangan = (EditText) findViewById(R.id.keterangan);
        nominal = (EditText) findViewById(R.id.nominal);
        simpan = (Button) findViewById(R.id.btnSimpanData);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database = db.getWritableDatabase();
                database.execSQL("INSERT INTO dataPengeluaran(tanggal, keterangan, nominal) VALUES ('"+tanggal.getText().toString()+"','"+keterangan.getText().toString()+"','"+nominal.getText().toString()+"')");
                Toast.makeText(TambahData.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                Pengeluaran.p.RefreshList();
                finish();
            }
        });

    }
}