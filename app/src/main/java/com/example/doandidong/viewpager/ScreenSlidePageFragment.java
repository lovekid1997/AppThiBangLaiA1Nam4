package com.example.doandidong.viewpager;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doandidong.R;
import com.example.doandidong.question.Question;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {
    ArrayList<Question> questionArrayList;
    public static final String key = "page";
    private int mPageNumber; //so trang hien tai
    TextView tvNum, tvQuestion;
    ImageView img;
    RadioGroup radioGroup;
    RadioButton rad1, rad2, rad3, rad4;
    public int checkans;

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        tvNum = rootView.findViewById(R.id.tvNum);
        tvQuestion = rootView.findViewById(R.id.tvQuestion);
        radioGroup = rootView.findViewById(R.id.radGroup);
        rad1 = rootView.findViewById(R.id.radA);
        rad2 = rootView.findViewById(R.id.radB);
        rad3 = rootView.findViewById(R.id.radC);
        rad4 = rootView.findViewById(R.id.radD);
        img = rootView.findViewById(R.id.CauHoi);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionArrayList = new ArrayList<>();
        ScreenSlideActivity screenSlideActivity = (ScreenSlideActivity) getActivity();
        questionArrayList = screenSlideActivity.getData();
        mPageNumber = getArguments().getInt(key);
        checkans = getArguments().getInt("checkans");

    }

    //ham kiem tra cau dung, neu cau dung thi doi mau background cua radio button
    private void getCheckAns(int a) {
        if (a == 1) {
            rad1.setBackgroundColor(Color.RED);
        } else if (a == 2) {
            rad2.setBackgroundColor(Color.RED);
        } else if (a == 3) {
            rad3.setBackgroundColor(Color.RED);
        } else if (a == 4) {
            rad4.setBackgroundColor(Color.RED);
        } else ;

    }

    public static ScreenSlidePageFragment create(int pageNumber, int checkAns) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page", pageNumber);
        bundle.putInt("checkans", checkAns);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] a = {"Nhất", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín", "Mười", "Mười Một", "Mười Hai",
                "Mười Ba", "Mười Bốn", "Mười Năm", "Mười Sáu", "Mười Bảy", "Mười Tám", "Mười Chín", "Hai Mươi"};

        // tvNum.setText("Câu "+ questionArrayList.get(mPageNumber).getSoCau());
        tvNum.setText("Câu " + (mPageNumber + 1));
        //tvQuestion.setVisibility(View.INVISIBLE);
        tvQuestion.setText("Câu hỏi thứ " + a[mPageNumber]);
        Bitmap bm = BitmapFactory.decodeByteArray(questionArrayList.get(mPageNumber).getCauHoi()
                , 0, questionArrayList.get(mPageNumber).getCauHoi().length);
        img.setImageBitmap(bm);

        if (checkans != 0) {
            rad1.setClickable(false);
            rad2.setClickable(false);
            rad3.setClickable(false);
            rad4.setClickable(false);
            getCheckAns(questionArrayList.get(mPageNumber).getDapAn());
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int i = getTraLoi(checkedId);
                questionArrayList.get(mPageNumber).setTraLoi(String.valueOf(i));
            }
        });
    }

    private int getTraLoi(int id) {
        int i = -1;
        if (id == R.id.radA)
            i = 1;
        else if (id == R.id.radB)
            i = 2;
        else if (id == R.id.radC)
            i = 3;
        else if (id == R.id.radD)
            i = 4;
        return i;
    }
}
