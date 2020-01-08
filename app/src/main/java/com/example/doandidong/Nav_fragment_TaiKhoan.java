package com.example.doandidong;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doandidong.Unit.CheckConnection;
import com.example.doandidong.Unit.Server;
import com.example.doandidong.question.ScoreAdapter;
import com.example.doandidong.question.ScoreClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nav_fragment_TaiKhoan extends Fragment {
    List<ScoreClass> arrlist = new ArrayList<>();
    List<ScoreClass> arrlist1 = new ArrayList<>();
    ListView listview;
    ScoreAdapter adapter;

    int id = 0;
    String sdt = "";
    String hoten = "";
    String diem = "";

    int positionn = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_fragment_taikhoan, container, false);
        listview = view.findViewById(R.id.lvScore);

        adapter = new ScoreAdapter(arrlist1, getContext());
        listview.setAdapter(adapter);
        registerForContextMenu(listview);
       listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               positionn = position;
               return false;
           }
       });
       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               positionn = position;
           }
       });
        return view;

    }


    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.updateordelete, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuDelete)
        {
            XoaThanhTich();

        }
        return super.onContextItemSelected(item);
    }

    private void XoaThanhTich() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.duongdanDeleteSinhVien, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("idsinhvien", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id", String.valueOf(arrlist1.get(positionn).getId()));
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
        Toast.makeText(getContext(), "" + "Thành công!", Toast.LENGTH_SHORT).show();
        arrlist1.remove(positionn);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onResume() {
        LayHetNguoiChoi();
        super.onResume();
    }

    private void LayHetNguoiChoi() {
        arrlist.clear();
        arrlist1.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        final JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(Server.duongdanlayhetnguoichoi,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                if (response != null) {
                                    for (int i = 0; i < response.length(); i++) {
                                        try {
                                            JSONObject jsonObject = response.getJSONObject(i);
                                            id = jsonObject.getInt("id");
                                            sdt = jsonObject.getString("sdt");
                                            hoten = jsonObject.getString("hoten");
                                            diem = jsonObject.getString("diem");
                                            arrlist.add(new ScoreClass(id, sdt, hoten, diem));
                                            if(sdt.trim().equalsIgnoreCase(ActivityDNDK.sdtt.trim()))
                                                arrlist1.add(new ScoreClass(id, sdt, hoten, diem));
                                            adapter.notifyDataSetChanged();
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                            Toast.makeText(getContext(), "" + e.toString(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        CheckConnection.Show_Toast(getContext(), error.toString());
                    }
                });

        requestQueue.add(jsonArrayRequest);
    }
}
