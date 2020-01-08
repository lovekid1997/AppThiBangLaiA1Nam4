package com.example.doandidong;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Nav_fragment_MucDoHoanThanh extends Fragment {
    //anh xa controls
    ListView listVewMucDoHOanThanh;
    //khoi tao adapter cho list view
    AdapterMDHT adapter;
    //Tao du lieu
    List<Integer> integerArrayListsoCauDung = new ArrayList<Integer>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_fragment_mucdohoanthanh, container, false);
        //anh xa list view
        listVewMucDoHOanThanh = view.findViewById(R.id.listVewMucDoHOanThanh);

        //Lay du lieu tu csdl
         Cursor cursor = MainActivity.database.query("NguoiChoi", null, "ID = ?", new String[]{String.valueOf(NavigationDrawerActivity.id)}, null, null, null, null);

        //Do du lieu vao  integerArrayListsoCauDung
        for (int i = 6; i < 14; i++) {
            cursor.moveToFirst();
            int kq= 0;
            if(String.valueOf(cursor.getInt(i)).isEmpty())
            {
                integerArrayListsoCauDung.add(kq);
            }
            else{
                integerArrayListsoCauDung.add(cursor.getInt(i));
            }
        }
        adapter = new AdapterMDHT(getActivity(), R.layout.custom_dong_listview, integerArrayListsoCauDung);
        listVewMucDoHOanThanh.setAdapter(adapter);

        return view;

    }

    @Override
    public void onStart() {
        adapter.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    public void onResume() {
        adapter.notifyDataSetChanged();
        super.onResume();
    }
}
