package com.example.doandidong;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class Nav_fragment_ThiThu_OnTap_De extends Fragment {
    //KHai bao cac controls
    ImageView imageViewOnTap_De_CauHoi;
    CheckBox checkBoxCau1, checkBoxCau2, checkBoxCau3, checkBoxCau4;
    Button buttonOnTap_De_CauTruoc, buttonOnTap_De_DapAn, buttonOnTap_De_CauTiepTheo, buttonOnTap_De_XemCauTL,
            buttonOnTap_De_NopBai, buttonOnTap_De_QuayLai;

    //Tao button trong dialog hoi xac nhan co quay lai hay khong
    Button buttonDialogDongYQuaylai, buttonDialogHuyQuayLai;

    //Khia bao textview cho nguoi dung biet dang o cau hoi nao
    TextView texyaaa;

    //khai bao textView bao nguoi dung da hoan thanh duoc bao nhieu cau
    TextView textViewKEtQua;
    Button buttonDongYChonDeKhac;

    //Tao list chua cau hoi, cau tra loi, de, dap an
    List<DeThi> deThiList = new ArrayList<>();

    //Tao list chua dap an nguoi dung tra loi
    List<DapAn> dapAnList = new ArrayList<>();

    //Vi tri cua cau hoi
    int viTriCau = 0;

    //so de nguoi dung chon
    int soDe = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_fragment_thithu_ontap_de, container, false);

        //Anh xa cac controls
        imageViewOnTap_De_CauHoi = view.findViewById(R.id.imageViewCauHoiOnTap_De);
        checkBoxCau1 = view.findViewById(R.id.checkBoxCau1);
        checkBoxCau2 = view.findViewById(R.id.checkBoxCau2);
        checkBoxCau3 = view.findViewById(R.id.checkBoxCau3);
        checkBoxCau4 = view.findViewById(R.id.checkBoxCau4);
        buttonOnTap_De_CauTruoc = view.findViewById(R.id.buttonOnTap_De_CauTruoc);
        buttonOnTap_De_CauTiepTheo = view.findViewById(R.id.buttonOnTap_De_CauTiepTheo);
        buttonOnTap_De_DapAn = view.findViewById(R.id.buttonOnTap_De_XemDapAn);
        buttonOnTap_De_NopBai = view.findViewById(R.id.buttonOnTap_De_NopBAi);
        buttonOnTap_De_NopBai.setVisibility(View.INVISIBLE);
        //buttonOnTap_De_XemCauTL = view.findViewById(R.id.buttonOnTap_De_XemCauTraLoi);
        buttonOnTap_De_QuayLai = view.findViewById(R.id.buttonOnTap_De_QuayLai);

        //anh xa controls tren dialog bao cao ket qua
        textViewKEtQua = view.findViewById(R.id.textViewKEtQua);

        //Cho nguoi dung biet dang o cau nao`
        texyaaa = view.findViewById(R.id.texyaaa);

        //Khoi tao csdl
        LayDuLieuDoVaoList();

        //set cau hoi mac dinh cau 1
        XuLyTaoCauHoi();

        //Tao dap an
        TaoListDapAnMau();

        //Click button cau truoc
        ClickButtonCauTruoc();

        //Click button cau tiep theo,
        // hien ra cau hoi tiep theo, cap nhat index, luu dap an nguoi dung chon
        ClickButtonCauTiepTheo();

        //CLick button dap an
        ClickButtonDapAn();

        //CLick button Quay lai, popbackstack
        ClickButtonQuayLai();

        //click button nop bai, kiem tra da lam xong chua bao ket qua cho nguoi dung, cap nhat csdl
        ClickButtonNopBai();


        //Click button xem cau tra loi
        //buttonOnTap_De_XemCauTL.setVisibility(View.INVISIBLE);
        return view;
    }

    private void ClickButtonNopBai() {
        buttonOnTap_De_NopBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkBoxCau1.isChecked() && !checkBoxCau2.isChecked() && !checkBoxCau3.isChecked() && !checkBoxCau4.isChecked()) {
                    Toast.makeText(getActivity(), "Xin hãy chọn đáp án!", Toast.LENGTH_SHORT).show();
                } else
                    //Show dialog cho nguoi dung biet da dung bao nhieu cau
                    dapAnList.get(viTriCau).setDapAn1(checkBoxCau1.isChecked());
                    dapAnList.get(viTriCau).setDapAn2(checkBoxCau2.isChecked());
                  dapAnList.get(viTriCau).setDapAn3(checkBoxCau3.isChecked());
                  dapAnList.get(viTriCau).setDapAn4(checkBoxCau4.isChecked());
                    ShowDiaLogBaoCaoKetQua();
            }
        });
    }

    private void ShowDiaLogBaoCaoKetQua() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog_baocaonguoidung);
        dialog.show();

        buttonDongYChonDeKhac = dialog.findViewById(R.id.buttonDialogDongYQuaylai);
        textViewKEtQua = dialog.findViewById(R.id.textViewKEtQua);

        //So cau lam dung
        int text = 0;

        //dong y chon de khac pop backstack
        buttonDongYChonDeKhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                getFragmentManager().popBackStack();
            }
        });

        //Xu ly su kien luu du lieu nguoi dung da lam duoc bao nhieu cau

        //Lay du lieu
        int kq = 0;
        for (int i = 0; i < deThiList.size(); i++) {
            int dapAnDataBase = deThiList.get(i).getDapAn();
            int dapAnNguoiDung = 0;

            if (dapAnList.get(i).isDapAn1()) {
                dapAnNguoiDung = 1;
            }
            if (dapAnList.get(i).isDapAn2()) {
                dapAnNguoiDung = dapAnNguoiDung * 10 + 2;
            }
            if (dapAnList.get(i).isDapAn3()) {
                dapAnNguoiDung = dapAnNguoiDung * 10 + 3;
            }
            if (dapAnList.get(i).isDapAn4()) {
                dapAnNguoiDung = dapAnNguoiDung * 10 + 4;
            }
            if (dapAnNguoiDung == dapAnDataBase) {
                //update du lieu
                kq = kq * 10 + deThiList.get(i).getSoCau();
                text++;
            }
        }
        //set du lieu datase
        ContentValues values = new ContentValues();
        String[] a = {"Demot", "Dehai", "Deba", "Debon", "Denam", "Desau", "Debay", "Detam"};
        String de = a[soDe - 1];
        values.put(de, text);
        //update databseq
        MainActivity.database.update("NguoiChoi", values, "ID = ?", new String[]{String.valueOf((NavigationDrawerActivity.id))});
        textViewKEtQua.setText("Số câu làm đúng: " + text);
        dialog.setCanceledOnTouchOutside(false);
    }

    private void ClickButtonQuayLai() {
        buttonOnTap_De_QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TAo dialog hoi nguoi dung muon quay lai hay khong
                CreateDialogQuestion();
            }
        });
    }

    //Tao dialog
    private void CreateDialogQuestion() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog_quaylai_xacnhan);
        dialog.show();


        //anh xa button trong dialog
        buttonDialogHuyQuayLai = dialog.findViewById(R.id.buttonDialogHuyQuayLai);
        buttonDialogDongYQuaylai = dialog.findViewById(R.id.buttonDialogDongYQuaylai);

        buttonDialogHuyQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        buttonDialogDongYQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
                dialog.dismiss();
            }
        });
    }

    private void ClickButtonDapAn() {
        buttonOnTap_De_DapAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Chức năng này chưa được cập nhật!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void TaoListDapAnMau() {
        for (int i = 0; i < 20; i++) {
            dapAnList.add(new DapAn(false, false, false, false));
        }
    }

    private void ClickButtonCauTiepTheo() {
        buttonOnTap_De_CauTiepTheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (viTriCau < 19) {
                    if (!checkBoxCau1.isChecked() && !checkBoxCau2.isChecked() && !checkBoxCau3.isChecked() && !checkBoxCau4.isChecked()) {
                        Toast.makeText(getActivity(), "Xin hãy chọn đáp án!", Toast.LENGTH_SHORT).show();
                    } else {
                        //set lai vi tri cau
                        viTriCau++;
                        texyaaa.setText("Câu " + (viTriCau + 1));
                        //set lai cau hoi
                        Bitmap bm = BitmapFactory.decodeByteArray(deThiList.get(viTriCau).getCauHoi(), 0, deThiList.get(viTriCau).getCauHoi().length);
                        imageViewOnTap_De_CauHoi.setImageBitmap(bm);

                        dapAnList.get(viTriCau - 1).setDapAn1(checkBoxCau1.isChecked());
                        dapAnList.get(viTriCau - 1).setDapAn2(checkBoxCau2.isChecked());
                        dapAnList.get(viTriCau - 1).setDapAn3(checkBoxCau3.isChecked());
                        dapAnList.get(viTriCau - 1).setDapAn4(checkBoxCau4.isChecked());

                        checkBoxCau1.setChecked(dapAnList.get(viTriCau).isDapAn1());
                        checkBoxCau2.setChecked(dapAnList.get(viTriCau).isDapAn2());
                        checkBoxCau3.setChecked(dapAnList.get(viTriCau).isDapAn3());
                        checkBoxCau4.setChecked(dapAnList.get(viTriCau).isDapAn4());
                    }
                } else {
                    buttonOnTap_De_NopBai.setVisibility(View.VISIBLE);
                    //luu 4 dap an
                    dapAnList.get(viTriCau).setDapAn1(checkBoxCau1.isChecked());
                    dapAnList.get(viTriCau).setDapAn2(checkBoxCau2.isChecked());
                    dapAnList.get(viTriCau).setDapAn3(checkBoxCau3.isChecked());
                    dapAnList.get(viTriCau).setDapAn4(checkBoxCau4.isChecked());

                    Toast.makeText(getActivity(), "Bạn đã hoàn thành xong 20 câu!", Toast.LENGTH_SHORT).show();
                }


                if (viTriCau == 19) {
                    buttonOnTap_De_CauTiepTheo.setText("Hoàn thành");
                }
            }
        });
    }

    private void ClickButtonCauTruoc() {
        buttonOnTap_De_CauTruoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viTriCau > 0) {
                    viTriCau--;
                    buttonOnTap_De_CauTiepTheo.setText("Câu tiếp theo");
                    //set lai vi tri cau
                    texyaaa.setText("Câu " + (viTriCau + 1));

                    //cap nhat lai cau hoi truoc neu nguoi dung co sua
                    dapAnList.get(viTriCau + 1).setDapAn1(checkBoxCau1.isChecked());
                    dapAnList.get(viTriCau + 1).setDapAn2(checkBoxCau2.isChecked());
                    dapAnList.get(viTriCau + 1).setDapAn3(checkBoxCau3.isChecked());
                    dapAnList.get(viTriCau + 1).setDapAn4(checkBoxCau4.isChecked());

                    //set lai cac checkbox o cau hoi viTriCau - 1
                    checkBoxCau1.setChecked(dapAnList.get(viTriCau).isDapAn1());
                    checkBoxCau2.setChecked(dapAnList.get(viTriCau).isDapAn2());
                    checkBoxCau3.setChecked(dapAnList.get(viTriCau).isDapAn3());
                    checkBoxCau4.setChecked(dapAnList.get(viTriCau).isDapAn4());

                    //set lai cau hoi
                    Bitmap bm = BitmapFactory.decodeByteArray(deThiList.get(viTriCau).getCauHoi(), 0, deThiList.get(viTriCau).getCauHoi().length);
                    imageViewOnTap_De_CauHoi.setImageBitmap(bm);
                } else {
                    Toast.makeText(getActivity(), "Bạn đang ở câu 1!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void XuLyTaoCauHoi() {
        //Tao cau hoi 1 mac dinh
        TaoCauHoiMacDinh();
    }

    private void TaoCauHoiMacDinh() {
        DeThi dt = deThiList.get(0);
        //parse blob to bitmap
        Bitmap bm = BitmapFactory.decodeByteArray(dt.getCauHoi(), 0, dt.getCauHoi().length);

        //set cai gia tri show len cho nguoi dung
        imageViewOnTap_De_CauHoi.setImageBitmap(bm);

        texyaaa.setText("" + (viTriCau + 1));
    }


    private void LayDuLieuDoVaoList() {
        //Tao bundle nhan du lieu tu fragment_ThiThu_OnTap || soDe = số đề người dùng chọn
        Bundle bundle = getArguments();
        soDe = bundle.getInt("soDe");
        Cursor cursor = MainActivity.database.query(
                "DeThi", null,
                "SoDe = ?", new String[]{String.valueOf(soDe)},
                null, null, null);
        while (cursor.moveToNext()) {
            byte[] cauHoi = cursor.getBlob(0);
            deThiList.add(new DeThi(cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cauHoi));
        }
        cursor.close();
    }


}
