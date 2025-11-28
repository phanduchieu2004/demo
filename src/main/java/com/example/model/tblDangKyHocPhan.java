package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblDangKyHocPhan {
    ChucNangSQL sql = new ChucNangSQL();

    public String maDangKy;
    public String maSinhVien;
    public String maHocPhan;
    public String maLopHocPhan;
    public String trangThai;
    public HttpServletRequest request;
    public Boolean bao_loi = false;

    public tblDangKyHocPhan() {
    }

    public tblDangKyHocPhan(HttpServletRequest req) {
        this.request = req;
    }

    public void them() {
        sql.themDangKyHocPhan(maSinhVien, maLopHocPhan, trangThai);
    }

    public void them(tblDangKyHocPhan d) {
        sql.themDangKyHocPhan(d.maSinhVien, d.maLopHocPhan, d.trangThai);
    }

    public void sua() {
        sql.suaDangKyHocPhan(maDangKy, maSinhVien, maLopHocPhan, trangThai);
    }

    public void sua(tblDangKyHocPhan d) {
        sql.suaDangKyHocPhan(d.maDangKy, d.maSinhVien, d.maLopHocPhan, d.trangThai);
    }

    public void xoa() {
        sql.xoaBanGhi("tblDangKyHocPhan", "MaDangKy = '" + maDangKy + "'");
    }

    public void truyVanTheoMa(String ma) {
        this.maDangKy = ma;
        this.maSinhVien = sql.timKiem("MaSinhVien", "tblDangKyHocPhan", "MaDangKy='" + ma + "'");
        this.maHocPhan = sql.timKiem("MaHocPhan", "tblDangKyHocPhan", "MaDangKy='" + ma + "'");
        this.maLopHocPhan = sql.timKiem("MaLopHocPhan", "tblDangKyHocPhan", "MaDangKy='" + ma + "'");
        this.trangThai = sql.timKiem("TrangThai", "tblDangKyHocPhan", "MaDangKy='" + ma + "'");
    }

    public void setMaDangKy(String ma) {
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("loiMaDangKy", "Mã đăng ký không được để trống");
            bao_loi = true;
        } else {
            this.maDangKy = ma;
        }
    }

    // !TODO Chua xong
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public String getMaLopHocPhan() {
        return maLopHocPhan;
    }

}
