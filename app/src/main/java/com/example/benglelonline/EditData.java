package com.example.benglelonline;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.benglelonline.helper.Helper;

public class EditData extends AppCompatActivity {

    protected Cursor cursor;
    Helper db;
    Button simpan;
    EditText keterangan, tanggal, nominal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        db = new Helper(this);
        tanggal = (EditText) findViewById(R.id.tanggal);
        keterangan = (EditText) findViewById(R.id.keterangan);
        nominal = (EditText) findViewById(R.id.nominal);
        simpan = (Button) findViewById(R.id.btnEditData);

        SQLiteDatabase database = db.getReadableDatabase();
        cursor = database.rawQuery("SELECT * FROM dataPengeluaran WHERE keterangan = '"+getIntent().getStringExtra("keterangan")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            cursor.moveToPosition(0);
            tanggal.setText(cursor.getString(0).toString());
            keterangan.setText(cursor.getString(1).toString());
            nominal.setText(cursor.getString(2).toString());
        }
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database = db.getWritableDatabase();
                database.execSQL("UPDATE dataPengeluaran SET keterangan = '"+keterangan.getText().toString()+"', tanggal = '"+tanggal.getText().toString()+"' WHERE tanggal = '"+tanggal.getText().toString()+"'");
                Toast.makeText(EditData.this, "Update Data Berhasil", Toast.LENGTH_SHORT).show();
                Pengeluaran.p.RefreshList();
                finish();
            }
        });
    }
}