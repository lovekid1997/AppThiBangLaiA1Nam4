package com.example.doandidong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doandidong.Unit.CheckConnection;

import maes.tech.intentanim.CustomIntent;

public class ActivityDNDK extends AppCompatActivity {
    Button buttonDangNhapF;
    EditText editTextTaiKhoanF;
    public static String sdtt = "";
    public static int TrangTrai = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dndk);
        AnhXa();
        buttonDangNhapF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sdtt = editTextTaiKhoanF.getText().toString();

                if (!CheckConnection.haveNetworkConnection(getApplicationContext())) {
                    CheckConnection.Show_Toast(getApplicationContext(),
                            "Không có wifi bạn sẽ không lưu được điểm!");
                    TrangTrai = 1;
                }
                Intent intent = new Intent(ActivityDNDK.this,NavigationDrawerActivity.class);
                startActivity(intent);
                CustomIntent.customType(ActivityDNDK.this,"right-to-left");
            }
        });
    }

    private void AnhXa() {
        buttonDangNhapF = findViewById(R.id.buttonDangNhapF);

        editTextTaiKhoanF = findViewById(R.id.editTextUserName);

    }

}
