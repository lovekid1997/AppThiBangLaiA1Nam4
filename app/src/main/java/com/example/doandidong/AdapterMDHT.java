package com.example.doandidong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class AdapterMDHT extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Integer> soCauDung;

    public AdapterMDHT(Context context, int layout, List<Integer> soCauDung) {
        this.context = context;
        this.layout = layout;
        this.soCauDung = soCauDung;
    }

    @Override
    public int getCount() {
        return soCauDung.size();
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

        TextView textViewMucDoHoanThanhDe = view.findViewById(R.id.textViewMucDoHoanThanhDe);
        TextView textViewMucDoHoanThanh = view.findViewById(R.id.textViewMucDoHoanThanh);
        ProgressBar progressBarDe = view.findViewById(R.id.progressBarDe);

        int soCau = soCauDung.get(i);
        progressBarDe.setProgress(soCau);
        textViewMucDoHoanThanhDe.setText("Đề "+ (i + 1));
        textViewMucDoHoanThanh.setText("Bạn đã hoàn thành được "+ soCau + "/20" +"câu!");
        return view;
    }
}
