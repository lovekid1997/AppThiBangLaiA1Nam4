package com.example.doandidong.question;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doandidong.MainActivity;

import java.util.ArrayList;
import java.util.Random;

public class QuestionController {
    private DBHelper dbHelper;

    public QuestionController(Context context) {
        dbHelper = new DBHelper(context);

    }
//    public ArrayList<Question> getQuestion(int sode){
//        ArrayList<Question> lsdata = new ArrayList<>();
//        //SQLiteDatabase db = dbHelper.getWritableDatabase();
//        //Cursor cursor = db.rawQuery("SELECT * FROM DeThi WHERE SoDe = "+"'sode'",null);
//        Cursor cursor = MainActivity.database.query(
//                "DeThi", null,
//                "SoDe = ?", new String[]{String.valueOf(sode)},
//                null, null, null);
//        cursor.moveToFirst();
//        do {
//            Question item;
//            byte[] a = cursor.getBlob(0);
//            item = new Question(a,cursor.getInt(1),cursor.getInt(2),cursor.getInt(3));
//            lsdata.add(item);
//        }while(cursor.moveToNext());
//        return lsdata;
//    }
    public ArrayList<Question> getQuestionRanDom(){
        ArrayList<Question> lsdata = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = MainActivity.database.rawQuery("select * from DeThi", null);
       // Cursor cursor = MainActivity.database.rawQuery("select * from DeThi", null);
        cursor.moveToFirst();
        do {
            Question item;
            item = new Question(cursor.getBlob(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),"");
            lsdata.add(item);
        }while(cursor.moveToNext());
        ArrayList<Question> lstrandom = new ArrayList<>();


        for(int i = 0 ; i < 20 ;i++) {
            Random rd = new Random();
            int as= rd.nextInt(lsdata.size());

            lstrandom.add(lsdata.get(as));
            lsdata.remove(as);
        }
        return lstrandom;
    }

}
