package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblTaiKhoan {
    ChucNangSQL sql = new ChucNangSQL();

    public String maTaiKhoan;
    public String tenDangNhap;
    public String matKhau;
    public String vaiTro;
    public String maSinhVien; // optional link to student
    public HttpServletRequest request;
    public Boolean bao_loi = false;

    public tblTaiKhoan() {
    }

    public tblTaiKhoan(HttpServletRequest req) {
        this.request = req;
    }

    public void them() {
        // Use TenDangNhap as MaNguoiDung in DB
        sql.themTaiKhoan(tenDangNhap, matKhau, vaiTro);
    }

    public void them(tblTaiKhoan t) {
        sql.themTaiKhoan(t.tenDangNhap, t.matKhau, t.vaiTro);
    }

    public void sua() {
        sql.suaTaiKhoan(tenDangNhap, matKhau, vaiTro);
    }

    public void sua(tblTaiKhoan t) {
        sql.suaTaiKhoan(t.tenDangNhap, t.matKhau, t.vaiTro);
    }

    public void xoa() {
        sql.xoaBanGhi("tblTaiKhoan", "MaTaiKhoan = '" + maTaiKhoan + "'");
    }

    public void truyVanTheoMa(String ma) {
        this.maTaiKhoan = ma;
        this.tenDangNhap = sql.timKiem("MaNguoiDung", "tblTaiKhoan", "MaNguoiDung='" + ma + "'");
        this.matKhau = sql.timKiem("MatKhau", "tblTaiKhoan", "MaNguoiDung='" + ma + "'");
        this.vaiTro = sql.timKiem("ChucVu", "tblTaiKhoan", "MaNguoiDung='" + ma + "'");
        this.maSinhVien = null;
    }

    public void setMaTaiKhoan(String ma) {
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("loiMaTaiKhoan", "Mã tài khoản không được để trống");
            bao_loi = true;
        } else {
            this.maTaiKhoan = ma;
        }
    }
    // !TODO thieu

}
