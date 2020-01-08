package com.example.doandidong;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class Nav_fragment_ThuThu_HocBai_LyThuyet extends Fragment {
    List<Integer> lyThuyets = new ArrayList<Integer>();
    ListView listView;
    AdapterLyThuyet adapterLyThuyet;
    ArrayAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_fragment_thithu_hocbai_lythuyet,container,false);
        listView = view.findViewById(R.id.listViewLyThuyet);
       // lyThuyets.add(R.drawable.lythuyet_mot);
       // lyThuyets.add(R.drawable.lythuyet_mot);
       // adapterLyThuyet = new AdapterLyThuyet(getActivity(),R.layout.custom_dong_listview_lythuyet,lyThuyets);
      String[] arr = getResources().getStringArray(R.array.string_array);
      adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);
        return view;
    }
}
