package com.example.benglelonline.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.tv.TvView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.benglelonline.R;
import com.example.benglelonline.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> lists;
    private Object View;

    public Adapter(Activity activity, List<Data> lists){
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(View == null && inflater != null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (View == null && inflater != null){
            view = inflater.inflate(R.layout.list_user, null);
        }

        if (view != null) {
            TextView nama = view.findViewById(R.id.text_nama);
            TextView email = view.findViewById(R.id.text_email);

            Data data = lists.get(i);
            nama.setText(data.getNama());
            email.setText(data.getEmail());
        }

        return view;
    }
}
