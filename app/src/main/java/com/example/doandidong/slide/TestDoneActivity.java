package com.example.doandidong.slide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doandidong.ActivityDNDK;
import com.example.doandidong.R;
import com.example.doandidong.Unit.Server;
import com.example.doandidong.question.Question;
import com.example.doandidong.viewpager.ScreenSlideActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestDoneActivity extends AppCompatActivity {
    ArrayList<Question> arr_QuesBegin = new ArrayList<>();
    int numNoAns = 0;
    int numTrue = 0;
    int numFalse = 0;
    int totalScore = 0;

    //ScoreController scoreController;

    TextView tvTrue, tvFalse, tvNotAns, tvTotalScore;
    Button btnSaveScore, btnAgain, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);

            arr_QuesBegin = ScreenSlideActivity.questionArrayList;

        begin();
        checkResult();
        totalScore = numTrue;
        tvNotAns.setText("" + numNoAns);
        tvFalse.setText("" + numFalse);
        tvTrue.setText("" + numTrue);
        tvTotalScore.setText("" + totalScore);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                builder.show();
            }
        });

        btnSaveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater = TestDoneActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.allert_dialog_save_score, null);
                builder.setView(view);

                final EditText edtName = (EditText) view.findViewById(R.id.edtName);

                TextView tvScore = (TextView) view.findViewById(R.id.tvScore);
                final int numTotal = numTrue ;
                tvScore.setText(numTotal + " điểm");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = edtName.getText().toString();
                        // scoreController.insertScore(name, numTotal, room);
                    EventLuuDiem(name,numTotal);
                        Toast.makeText(TestDoneActivity.this, "Lưu điểm thành công!", Toast.LENGTH_LONG).show();
                        finish();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog b = builder.create();
                b.show();
            }
        });

    }

    private void EventLuuDiem(final String a, final int b) {
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.duongdanInsertnguoichoi, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("idsinhvien", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(TestDoneActivity.this, "" + error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("sdt", ActivityDNDK.sdtt);
                    hashMap.put("hoten", a);
                    hashMap.put("diem", String.valueOf(b));
                    return hashMap;
                }
            };
            requestQueue.add(stringRequest);

            finish();
    }

    public void begin() {
        tvFalse = (TextView) findViewById(R.id.tvFalse);
        tvTrue = (TextView) findViewById(R.id.tvTrue);
        tvNotAns = (TextView) findViewById(R.id.tvNotAns);
        tvTotalScore = (TextView) findViewById(R.id.tvTotalPoint);
        btnAgain = (Button) findViewById(R.id.btnAgain);
        btnSaveScore = (Button) findViewById(R.id.btnSaveScore);
        btnExit = (Button) findViewById(R.id.btnExit);
    }

    //PT Check kết quả
    public void checkResult() {
        for (int i = 0; i < arr_QuesBegin.size(); i++) {
            if (arr_QuesBegin.get(i).getTraLoi().equals("") == true) {
                numNoAns++;
            } else if (arr_QuesBegin.get(i).getDapAn() == Integer.parseInt(arr_QuesBegin.get(i).getTraLoi())) {
                numTrue++;
            } else numFalse++;
        }

    }
}
