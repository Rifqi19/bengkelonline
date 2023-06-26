package com.example.benglelonline;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.benglelonline.helper.Helper;

public class Pengeluaran extends AppCompatActivity {

    String[] daftar;
    ListView listView;
    protected Cursor cursor;
    Helper db;
    public static Pengeluaran p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);

        Button tambahData = (Button) findViewById(R.id.tambahData);

        tambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tambahData = new Intent(Pengeluaran.this, TambahData.class);
                startActivity(tambahData);
            }
        });
        p = this;
        db = new Helper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase database = db.getReadableDatabase();
        cursor = database.rawQuery("SELECT * FROM dataPengeluaran",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i=0 ; i<cursor.getCount() ; i++){
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(1).toString();
        }
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listView.setSelected(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                final String selection = daftar[i];
                final CharSequence[] dialogitem = {"Lihat Data","Update Data", "Hapus Data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(Pengeluaran.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0 :
                                Intent lihat = new Intent(getApplicationContext(), TampilData.class);
                                lihat.putExtra("keterangan", selection);
                                startActivity(lihat);
                                break;
                            case 1 :
                                Intent tambah = new Intent(getApplicationContext(), EditData.class);
                                tambah.putExtra("keterangan", selection);
                                startActivity(tambah);
                                break;
                            case 2:
                                SQLiteDatabase database = db.getWritableDatabase();
                                database.execSQL("DELETE FROM dataPengeluaran WHERE keterangan = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) listView.getAdapter()).notifyDataSetInvalidated();
    }
}