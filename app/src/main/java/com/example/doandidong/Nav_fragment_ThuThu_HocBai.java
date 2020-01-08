package com.example.doandidong;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Nav_fragment_ThuThu_HocBai extends Fragment {
    Button buttonHocBaiLyThuyet,buttonHocBaiBienBao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_fragment_thithu_hocbai,container,false);
        buttonHocBaiBienBao = view.findViewById(R.id.buttonHocBaiBienBao);
        buttonHocBaiLyThuyet = view.findViewById(R.id.buttonHocBaiLyThuyet);

        buttonHocBaiLyThuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                fragmentTransaction.replace(R.id.fragment_container,new Nav_fragment_ThuThu_HocBai_LyThuyet());
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });

        buttonHocBaiBienBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                fragmentTransaction.replace(R.id.fragment_container, new Nav_fragment_ThuThu_HocBai_BienBao());
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
