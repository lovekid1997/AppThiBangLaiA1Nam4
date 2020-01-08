package com.example.doandidong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doandidong.question.DBHelper;
import com.example.doandidong.viewpager.ScreenSlideActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {
    //Thêm cơ sở dữ liệu SQLite
    public static String DATABASE_NAME ="dbA1test.sqlite";
    public static String DB_PATH_SUFFIX ="/databases/";
    public static SQLiteDatabase database = null;
    public static int X = 0;
    //Khoi tao cac controls Main
    Button buttonDangNhap, buttonDangKy;
    TextView textViewQuenMatKHau;

    ImageView imageView3;
    CounterClass1 timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Thêm cơ sở dữ liệu vào app
        ThemCSDL();

        //Khởi tạo database
        KhoiTaoDataBase();

        //Tham chieu toi cac controls
        AnhXa();

        //Su kien click button dang nhap tren activity main

        timer = new CounterClass1(3*1000,1000);
        timer.start();
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityDNDK.class);
                startActivity(intent);
                CustomIntent.customType(MainActivity.this,"right-to-left");
                timer.cancel();
            }
        });



    }
    private class CounterClass1 extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        //millisInFuture: 60*1000
        //countDownInterval:  1000
        public CounterClass1(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(MainActivity.this,ActivityDNDK.class);
            startActivity(intent);
            CustomIntent.customType(MainActivity.this,"right-to-left");
        }
    }


    //Su kien click button dang nhap show dialog
    private void ClickBuuttonDangNhap() {
        buttonDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityDNDK.class);
                intent.putExtra("id",1);
                startActivity(intent);
                CustomIntent.customType(MainActivity.this,"up-to-button");
            }
        });
    }



    //Tham chieu toi cac controls
    private void AnhXa() {
        imageView3 = findViewById(R.id.imageView3);
    }

    private void KhoiTaoDataBase() {
        database = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
    }

    //Thêm cơ sở dữ liệu
    private void ThemCSDL() {
        try{
            File dbFile = getDatabasePath(DATABASE_NAME);
            if(!dbFile.exists()){
                //
                CopyTuFileAssets();
                Toast.makeText(this, "Da xong", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception ex){
            Toast.makeText(this, ""+ex.toString(), Toast.LENGTH_LONG).show();
            Log.d("aaa",ex.toString());
        }
    }

    //Copy từ file assets
    private void CopyTuFileAssets() {
        try{
            InputStream myInput = getAssets().open(DATABASE_NAME);
            String outFileName = getDatabasePath();
            File f = new File(getApplicationInfo().dataDir+DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream myOutPut = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length;
            while((length = myInput.read(buff)) > 0){
                myOutPut.write(buff,0,length);
            }
            myOutPut.flush();
            myOutPut.close();
            myInput.close();
        }
        catch (Exception ex){
            Log.e("loi", ex.toString());

        }
    }
    //Trả đường dẫn
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }



}
