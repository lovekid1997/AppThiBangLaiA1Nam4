package com.example.doandidong.question;

public class ScoreClass {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ScoreClass(int id, String sdt, String hoten, String diem) {
        this.id = id;
        this.sdt = sdt;
        this.hoten = hoten;
        this.diem = diem;
    }

    private String sdt;
    private String hoten;
    private String diem;

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }


}
