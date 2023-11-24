package com.example.karaoke.model;

import android.arch.persistence.room.Entity;

@Entity(tableName = "BaiHat_TBL")
public class room {
    private String maBH;

    private String tenBH;

    private String loiBH;

    private String tacgia;

    private String theloai;

    private boolean yeuThich;

    public String getMaBH() {
        return maBH;
    }

    public void setMaBH(String maBH) {
        this.maBH = maBH;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getLoiBH() {
        return loiBH;
    }

    public void setLoiBH(String loiBH) {
        this.loiBH = loiBH;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public boolean isYeuThich() {
        return yeuThich;
    }

    public void setYeuThich(boolean yeuThich) {
        this.yeuThich = yeuThich;
    }

    public room(String maBH, String tenBH, String loiBH, String tacgia, String theloai, boolean yeuThich) {
        this.maBH = maBH;
        this.tenBH = tenBH;
        this.loiBH = loiBH;
        this.tacgia = tacgia;
        this.theloai = theloai;
        this.yeuThich = yeuThich;
    }

    public room() {
    }
}
