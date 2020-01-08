package com.example.doandidong;

public class LyThuyet {
    private String tieuDe;
    private String duLieu;

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getDuLieu() {
        return duLieu;
    }

    public void setDuLieu(String duLieu) {
        this.duLieu = duLieu;
    }

    public LyThuyet(String tieuDe, String duLieu) {
        this.tieuDe = tieuDe;
        this.duLieu = duLieu;
    }
}
