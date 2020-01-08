package com.example.doandidong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class AdapterLyThuyet extends BaseAdapter {
    public AdapterLyThuyet(Context context, int layout, List<Integer> text) {
        this.context = context;
        this.layout = layout;
        this.text = text;
    }

    private Context context;
    private int layout;
    private List<Integer> text;



    @Override
    public int getCount() {
        return text.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout,null);

        ImageView imageView = view.findViewById(R.id.imaaaaa);
        imageView.setImageResource(text.get(i));
        return view;
    }
}
