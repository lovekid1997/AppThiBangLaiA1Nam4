package com.example.doandidong;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Nav_fragment_ThuThu_HocBai_BienBao extends Fragment {
    Button buttonHocBienBaoHinh1, buttonHocBienBaoHinh2;
    TextView textViewTieuDeGhiChu,textViewGhiChu;
    ImageView imageViewHinh;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_fragment_thithu_hocbai_bienbao,container,false);
        buttonHocBienBaoHinh1 = view.findViewById(R.id.buttonHocBienBao1);
        imageViewHinh = view.findViewById(R.id.imageViewHinhBienBao);
        buttonHocBienBaoHinh2 = view.findViewById(R.id.buttonHocBienBao2);
        textViewTieuDeGhiChu = view.findViewById(R.id.textViewGhiChuTieuDe);
        textViewGhiChu = view.findViewById(R.id.textViewGhiChu);

        imageViewHinh.setImageResource(R.drawable.meohocbienbaomot);

        buttonHocBienBaoHinh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewHinh.setImageResource(R.drawable.meohocbienbaomot);
            }
        });
        buttonHocBienBaoHinh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewHinh.setImageResource(R.drawable.meohocbienbaohai);
            }
        });
        textViewTieuDeGhiChu.setText("Chú ý: ");
        textViewGhiChu.setText("Biển cấm rẽ trái : Cấm cả quay đầu.\n" +
                "\n" +
                "Biển cấm quay đầu: Được rẽ trái.");
        return view;
    }
}
