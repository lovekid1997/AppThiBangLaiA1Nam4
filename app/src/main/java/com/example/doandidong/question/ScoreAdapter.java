package com.example.doandidong.question;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doandidong.ActivityDNDK;
import com.example.doandidong.R;

import java.util.ArrayList;
import java.util.List;

public class ScoreAdapter extends BaseAdapter {
    List<ScoreClass> arrayList = new ArrayList<>();
    Context context;

    public ScoreAdapter(List<ScoreClass> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView tvNameStudent,dat, tvScore;
        ImageView check;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list_score, null);
            viewHolder.tvNameStudent = convertView.findViewById(R.id.tvNameStudent);
            viewHolder.tvScore = convertView.findViewById(R.id.tvScore);
            viewHolder.check = convertView.findViewById(R.id.check);
            viewHolder.dat = convertView.findViewById(R.id.dat);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ScoreClass s = (ScoreClass) getItem(position);
        if (ActivityDNDK.TrangTrai == 1) {

        } else {
            viewHolder.tvNameStudent.setText(s.getHoten());

            viewHolder.tvScore.setText(s.getDiem());
        }
        if(Integer.parseInt(s.getDiem()) > 16){
            viewHolder.dat.setText("Đạt");
            viewHolder.check.setImageResource(R.drawable.checksuccess);
        }else{
            viewHolder.dat.setText("Không đạt");
            viewHolder.check.setImageResource(R.drawable.checkedrror);
        }
        return convertView;
    }
}
