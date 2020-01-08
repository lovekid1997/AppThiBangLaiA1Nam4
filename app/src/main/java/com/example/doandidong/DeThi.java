package com.example.doandidong;

public class DeThi {
    private int soDe;
    private int soCau;
    private int dapAn;
    private byte[] cauHoi;

    public byte[] getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(byte[] cauHoi) {
        this.cauHoi = cauHoi;
    }

    public DeThi(int soDe, int soCau, int dapAn, byte[] cauHoi) {
        this.soDe = soDe;
        this.soCau = soCau;
        this.dapAn = dapAn;
        this.cauHoi = cauHoi;
    }

    public int getSoDe() {
        return soDe;
    }

    public void setSoDe(int soDe) {
        this.soDe = soDe;
    }

    public int getSoCau() {
        return soCau;
    }

    public void setSoCau(int soCau) {
        this.soCau = soCau;
    }

    public int getDapAn() {
        return dapAn;
    }

    public void setDapAn(int dapAn) {
        this.dapAn = dapAn;
    }



    public DeThi() {
    }
}
