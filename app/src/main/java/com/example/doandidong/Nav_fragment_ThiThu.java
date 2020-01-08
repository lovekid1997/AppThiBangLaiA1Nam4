package com.example.doandidong;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.doandidong.viewpager.ScreenSlideActivity;

import maes.tech.intentanim.CustomIntent;

public class Nav_fragment_ThiThu extends Fragment {
    //Khai bao anh xa cac controls trong Nav_fragmentThiThu
    Button buttonThiThu, buttonOnTapCauHoi, buttonCacBienBao, buttonMeo,buttonHocBai;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_fragment_thithu, container, false);

        //Anh xa cac controls
        buttonThiThu = view.findViewById(R.id.buttonThiThu);
        buttonOnTapCauHoi = view.findViewById(R.id.buttonOnTapCauHoi);
        buttonCacBienBao = view.findViewById(R.id.buttonCacBienBao);
        buttonMeo = view.findViewById(R.id.buttonMeo);
        buttonHocBai = view.findViewById(R.id.buttonHocBai);

        //Xu ly su kien click button thi thu
        ClickButtonThiThu();


        //Xu ly su kien click button OnTap
        CLickButtonOnTap();

        //xu lý su kien click button hoc bai
        ClickButtonHocBai();

        //Click button meo
        ClickButtonMeo();
        return view;

    }

    private void ClickButtonMeo() {
        buttonMeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                fragmentTransaction.replace(R.id.fragment_container, new HuongDan());
                fragmentTransaction.addToBackStack("b");
                fragmentTransaction.commit();
            }
        });
    }

    private void ClickButtonHocBai() {
        buttonHocBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                fragmentTransaction.replace(R.id.fragment_container, new Nav_fragment_ThuThu_HocBai());
                fragmentTransaction.addToBackStack("b");
                fragmentTransaction.commit();
            }
        });
    }

    private void CLickButtonOnTap() {
        buttonOnTapCauHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                fragmentTransaction.replace(R.id.fragment_container,new Nav_fragment_ThiThu_OnTap());
                fragmentTransaction.addToBackStack("b");
                fragmentTransaction.commit();
            }
        });
    }

    private void ClickButtonThiThu() {
        buttonThiThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ScreenSlideActivity.class);
                startActivity(i);
                CustomIntent.customType(getActivity(),"up-to-bottom");
            }
        });

    }
}
