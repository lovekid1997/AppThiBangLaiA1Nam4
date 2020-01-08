package com.example.doandidong.viewpager;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.doandidong.R;
import com.example.doandidong.question.Question;

import java.util.ArrayList;

public class CheckAnswerAdapter extends BaseAdapter {

    ArrayList data;
    LayoutInflater inflater;

    public CheckAnswerAdapter(ArrayList data, Context context) {
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question question = (Question) getItem(position);
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder() ;
            convertView = inflater.inflate(R.layout.item_gridview,null);
            holder.tvNumA = convertView.findViewById(R.id.tvNumAns);
            holder.tvAnswer = convertView.findViewById(R.id.tvAnswer);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        int i =1+ position;
        holder.tvNumA.setText("Câu "+ i+":");
        holder.tvAnswer.setText(""+question.getTraLoi());
        return convertView;
    }
    private  static class ViewHolder{
        TextView tvNumA, tvAnswer;
    }


}
