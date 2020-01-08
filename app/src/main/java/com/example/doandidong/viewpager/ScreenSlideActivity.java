package com.example.doandidong.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.doandidong.R;
import com.example.doandidong.question.Question;
import com.example.doandidong.question.QuestionController;
import com.example.doandidong.slide.TestDoneActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import maes.tech.intentanim.CustomIntent;

public class ScreenSlideActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 20;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;
    QuestionController questionController;
    public static ArrayList<Question> questionArrayList;
    TextView tvKiemTra,tvTimer,tvScore;
    CounterClass timer;
    public int checkans = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());

        timer = new CounterClass(15*60*1000,1500);

        questionController = new QuestionController(this);
        questionArrayList = new ArrayList<>();
        questionArrayList = questionController.getQuestionRanDom();

        tvKiemTra = findViewById(R.id.tvKiemTra);
        tvTimer = findViewById(R.id.tvTimer);
        tvScore = findViewById(R.id.tvScore);
        tvKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer();
            }
        });
        tvScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(ScreenSlideActivity.this, TestDoneActivity.class);
                //Bundle args = new Bundle();
               // args.putSerializable("ARRAYLIST",(Serializable)questionArrayList);
                //intent.putParcelableArrayListExtra("arr_Ques",questionArrayList);
                startActivity(intent);
                CustomIntent.customType(ScreenSlideActivity.this,"up-to-bottom");
            }
        });
        timer.start();

    }
    public void CheckAnswer(){
        final Dialog dialog  = new Dialog(this);
        dialog.setContentView(R.layout.check_answer_dialog);
        dialog.setTitle("Danh sách câu trả lời");
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.70);

        dialog.getWindow().setLayout(width, height);
        CheckAnswerAdapter checkAnswerAdapter = new CheckAnswerAdapter(questionArrayList,this);
        GridView gridView = dialog.findViewById(R.id.gvLsQuestion);
        gridView.setAdapter(checkAnswerAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();

            }
        });

        Button btnCancle, btnFinsh;
        btnCancle = dialog.findViewById(R.id.btnCancle);
        btnFinsh = dialog.findViewById(R.id.btnFinish);
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnFinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                dialog.dismiss();

                result();
            }
        });
        dialog.show();
    }

    private void result() {
        checkans = 1;
        if(mPager.getCurrentItem() >= 5) mPager.setCurrentItem(mPager.getCurrentItem() - 4);
        else if ( mPager.getCurrentItem()<= 5) mPager.setCurrentItem(mPager.getCurrentItem() + 4);
        tvScore.setVisibility(View.VISIBLE);
        tvKiemTra.setVisibility(View.GONE);
    }

    public ArrayList<Question> getData(){
        return questionArrayList;
    }
    @Override
    public void onBackPressed() {
            dialogExit();
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position,checkans);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1f);
                view.setTranslationX(0f);
                view.setScaleX(1f);
                view.setScaleY(1f);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }
    public class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */


        //millisInFuture: 60*1000
        //countDownInterval:  1000
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvTimer.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tvTimer.setText("00:00");  //SetText cho textview hiện thị thời gian.
            result();
        }
    }
    public void dialogExit(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(ScreenSlideActivity.this);
        builder.setIcon(R.drawable.exit);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát hay không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timer.cancel();
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }
}