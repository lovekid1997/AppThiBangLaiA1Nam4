package com.example.doandidong.question;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Question implements Parcelable {
    private byte[] CauHoi;
    private int SoDe;
    private int SoCau;
    private int DapAn;
    private String TraLoi = null;

    public Question(byte[] cauHoi, int soDe, int soCau, int dapAn, String traLoi) {
        CauHoi = cauHoi;
        SoDe = soDe;
        SoCau = soCau;
        DapAn = dapAn;
        TraLoi = traLoi;
    }

    public String getTraLoi() {
        return TraLoi;
    }

    public void setTraLoi(String traLoi) {
        TraLoi = traLoi;
    }

    public byte[] getCauHoi() {
        return CauHoi;
    }

    public void setCauHoi(byte[] cauHoi) {
        CauHoi = cauHoi;
    }

    public int getSoDe() {
        return SoDe;
    }

    public void setSoDe(int soDe) {
        SoDe = soDe;
    }

    public int getSoCau() {
        return SoCau;
    }

    public void setSoCau(int soCau) {
        SoCau = soCau;
    }

    public int getDapAn() {
        return DapAn;
    }

    public void setDapAn(int dapAn) {
        DapAn = dapAn;
    }

//    public Question(byte[] cauHoi, int soDe, int soCau, int dapAn) {
//        CauHoi = cauHoi;
//        SoDe = soDe;
//        SoCau = soCau;
//        DapAn = dapAn;
//    }

    public Question() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        private byte[] CauHoi;
//        private int SoDe;
//        private int SoCau;
//        private int DapAn;
//        private String TraLoi = null;
        dest.writeByteArray(CauHoi);
        dest.writeInt(SoDe);
        dest.writeInt(SoCau);
        dest.writeInt(DapAn);
        dest.writeString(TraLoi);
    }
}
