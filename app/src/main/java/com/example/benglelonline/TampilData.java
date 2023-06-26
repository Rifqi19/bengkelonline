package com.example.benglelonline;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benglelonline.helper.Helper;

public class TampilData extends AppCompatActivity {

    protected Cursor cursor;
    Helper db;
    TextView keterangan, tanggal, nominal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        db = new Helper(this);
        tanggal = findViewById(R.id.tvTanggal);
        keterangan = findViewById(R.id.tvKeterangan);
        nominal = findViewById(R.id.tvNominal);

        SQLiteDatabase database = db.getReadableDatabase();
        cursor = database.rawQuery("SELECT * FROM dataPengeluaran WHERE keterangan = '"+getIntent().getStringExtra("keterangan")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            cursor.moveToPosition(0);
            tanggal.setText(cursor.getString(0).toString());
            keterangan.setText(cursor.getString(1).toString());
            nominal.setText(cursor.getString(2).toString());
        }
    }
}