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

public class Nav_fragment_ThiThu_OnTap extends Fragment {
    //KHoi tao cac controls trong fragmentThiThuOnTap
    Button buttonThiThuOnTap1, buttonThiThuOnTap2, buttonThiThuOnTap3, buttonThiThuOnTap4,
            buttonThiThuOnTap5, buttonThiThuOnTap6, buttonThiThuOnTap7, buttonThiThuOnTap8, buttonQuayLaiOnTap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_fragment_thithu_ontap, container, false);

        //Anh xa cac button
        buttonThiThuOnTap1 = view.findViewById(R.id.buttonOnTapDe1);
        buttonThiThuOnTap2 = view.findViewById(R.id.buttonOnTapDe2);
        buttonThiThuOnTap3 = view.findViewById(R.id.buttonOnTapDe3);
        buttonThiThuOnTap4 = view.findViewById(R.id.buttonOnTapDe4);
        buttonThiThuOnTap5 = view.findViewById(R.id.buttonOnTapDe5);
        buttonThiThuOnTap6 = view.findViewById(R.id.buttonOnTapDe6);
        buttonThiThuOnTap7 = view.findViewById(R.id.buttonOnTapDe7);
        buttonThiThuOnTap8 = view.findViewById(R.id.buttonOnTapDe8);
        buttonQuayLaiOnTap = view.findViewById(R.id.buttonOnTapQuayLai);

        //Xu ly su kien click button quay lai trong fragment thi thu on tap
        ClickButtonQuayLaiOnTap();

        //Truyen du lieu xac nhan de thi 1
        ClickButtonThiThuOnTap1();

        //Truyen du lieu xac nhan de thi 2
        ClickButtonThiThuOnTap2();

        //Truyen du lieu xac nhan de thi 3
        ClickButtonThiThuOnTap3();

        //Truyen du lieu xac nhan de thi 4
        ClickButtonThiThuOnTap4();

        //Truyen du lieu xac nhan de thi 5
        ClickButtonThiThuOnTap5();

        //Truyen du lieu xac nhan de thi 6
        ClickButtonThiThuOnTap6();

        //Truyen du lieu xac nhan de thi 7
        ClickButtonThiThuOnTap7();

        //Truyen du lieu xac nhan de thi 8
        ClickButtonThiThuOnTap8();
        return view;


    }

    private void ClickButtonThiThuOnTap8() {
        buttonThiThuOnTap8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tao bundle truyen du lieu
                Bundle bundle = new Bundle();
                bundle.putInt("soDe",8);

                //Khoi tao fragment_ThiThu_OnTap_de
                Nav_fragment_ThiThu_OnTap_De nav_fragment_thiThu_onTap_de = new Nav_fragment_ThiThu_OnTap_De();

                //tao fragmentTransaction replace va add to back stack
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                //Truyen du lieu vao fragment_ThiThu_OnTap_de
                nav_fragment_thiThu_onTap_de.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container,nav_fragment_thiThu_onTap_de);
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });
    }

    private void ClickButtonThiThuOnTap7() {
        buttonThiThuOnTap7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tao bundle truyen du lieu
                Bundle bundle = new Bundle();
                bundle.putInt("soDe",7);

                //Khoi tao fragment_ThiThu_OnTap_de
                Nav_fragment_ThiThu_OnTap_De nav_fragment_thiThu_onTap_de = new Nav_fragment_ThiThu_OnTap_De();

                //tao fragmentTransaction replace va add to back stack
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                //Truyen du lieu vao fragment_ThiThu_OnTap_de
                nav_fragment_thiThu_onTap_de.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container,nav_fragment_thiThu_onTap_de);
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });
    }

    private void ClickButtonThiThuOnTap6() {
        buttonThiThuOnTap6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tao bundle truyen du lieu
                Bundle bundle = new Bundle();
                bundle.putInt("soDe",6);

                //Khoi tao fragment_ThiThu_OnTap_de
                Nav_fragment_ThiThu_OnTap_De nav_fragment_thiThu_onTap_de = new Nav_fragment_ThiThu_OnTap_De();

                //tao fragmentTransaction replace va add to back stack
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                //Truyen du lieu vao fragment_ThiThu_OnTap_de
                nav_fragment_thiThu_onTap_de.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container,nav_fragment_thiThu_onTap_de);
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });
    }

    private void ClickButtonThiThuOnTap5() {
        buttonThiThuOnTap5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tao bundle truyen du lieu
                Bundle bundle = new Bundle();
                bundle.putInt("soDe",5);

                //Khoi tao fragment_ThiThu_OnTap_de
                Nav_fragment_ThiThu_OnTap_De nav_fragment_thiThu_onTap_de = new Nav_fragment_ThiThu_OnTap_De();

                //tao fragmentTransaction replace va add to back stack
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                //Truyen du lieu vao fragment_ThiThu_OnTap_de
                nav_fragment_thiThu_onTap_de.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container,nav_fragment_thiThu_onTap_de);
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });
    }

    private void ClickButtonThiThuOnTap4() {
        buttonThiThuOnTap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tao bundle truyen du lieu
                Bundle bundle = new Bundle();
                bundle.putInt("soDe", 4);

                //Khoi tao fragment_ThiThu_OnTap_de
                Nav_fragment_ThiThu_OnTap_De nav_fragment_thiThu_onTap_de = new Nav_fragment_ThiThu_OnTap_De();

                //tao fragmentTransaction replace va add to back stack
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

                //Truyen du lieu vao fragment_ThiThu_OnTap_de
                nav_fragment_thiThu_onTap_de.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container, nav_fragment_thiThu_onTap_de);
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });
    }

    private void ClickButtonThiThuOnTap3() {
        buttonThiThuOnTap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tao bundle truyen du lieu
                Bundle bundle = new Bundle();
                bundle.putInt("soDe", 3);

                //Khoi tao fragment_ThiThu_OnTap_de
                Nav_fragment_ThiThu_OnTap_De nav_fragment_thiThu_onTap_de = new Nav_fragment_ThiThu_OnTap_De();

                //tao fragmentTransaction replace va add to back stack
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

                //Truyen du lieu vao fragment_ThiThu_OnTap_de
                nav_fragment_thiThu_onTap_de.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container, nav_fragment_thiThu_onTap_de);
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });
    }

    private void ClickButtonThiThuOnTap2() {
        buttonThiThuOnTap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tao bundle truyen du lieu
                Bundle bundle = new Bundle();
                bundle.putInt("soDe", 2);

                //Khoi tao fragment_ThiThu_OnTap_de
                Nav_fragment_ThiThu_OnTap_De nav_fragment_thiThu_onTap_de = new Nav_fragment_ThiThu_OnTap_De();

                //tao fragmentTransaction replace va add to back stack
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

                //Truyen du lieu vao fragment_ThiThu_OnTap_de
                nav_fragment_thiThu_onTap_de.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container, nav_fragment_thiThu_onTap_de);
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });
    }

    private void ClickButtonThiThuOnTap1() {
        buttonThiThuOnTap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tao bundle truyen du lieu
                Bundle bundle = new Bundle();
                bundle.putInt("soDe", 1);

                //Khoi tao fragment_ThiThu_OnTap_de
                Nav_fragment_ThiThu_OnTap_De nav_fragment_thiThu_onTap_de = new Nav_fragment_ThiThu_OnTap_De();

                //tao fragmentTransaction replace va add to back stack
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

                //Truyen du lieu vao fragment_ThiThu_OnTap_de
                nav_fragment_thiThu_onTap_de.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container, nav_fragment_thiThu_onTap_de);
                fragmentTransaction.addToBackStack("c");
                fragmentTransaction.commit();
            }
        });
    }

    //pop back stack
    private void ClickButtonQuayLaiOnTap() {
        buttonQuayLaiOnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
    }
}
