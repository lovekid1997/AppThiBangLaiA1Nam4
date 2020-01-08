package com.example.doandidong;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;


public class FragmentDangNhap extends Fragment {
    //Khoi tao cac controls trong fragment dang nhap
    Button buttonDangNhapF, buttonDangKyF;
    EditText editTextTaiKhoanF, editTextMatKhauF;
    TextView textViewQuenMatKhau;
    Cursor cursor;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dangnhap,container,false);
        buttonDangNhapF = view.findViewById(R.id.buttonDangNhapF);
        buttonDangKyF = view.findViewById(R.id.buttonDangKyF);
        editTextTaiKhoanF = view.findViewById(R.id.editTextUserName);
        editTextMatKhauF = view.findViewById(R.id.editTextPassword);
        textViewQuenMatKhau = view.findViewById(R.id.textViewQuenMatKhau);
        return view;

    }

}
