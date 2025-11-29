package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblTaiKhoan {
    ChucNangSQL sql = new ChucNangSQL();

    public String maNguoiDung;
    public String matKhau;
    public String chucVu;
    public String trangThaiTaiKhoan;
    public HttpServletRequest request;
    public Boolean bao_loi = false;

    public tblTaiKhoan() {
    }

    public tblTaiKhoan(HttpServletRequest req) {
        this.request = req;
    }

    public void them() {
        sql.themTaiKhoan(maNguoiDung, matKhau, chucVu, trangThaiTaiKhoan);
    }

    public void them(tblTaiKhoan t) {
        sql.themTaiKhoan(t.maNguoiDung, t.matKhau, t.chucVu, t.trangThaiTaiKhoan);
    }

    public void sua() {
        sql.suaTaiKhoan(maNguoiDung, matKhau, chucVu, trangThaiTaiKhoan);
    }

    public void sua(tblTaiKhoan t) {
        sql.suaTaiKhoan(t.maNguoiDung, t.matKhau, t.chucVu, t.trangThaiTaiKhoan);
    }

    public void xoa() {
        sql.xoaBanGhi("tblTaiKhoan", "MaNguoiDung = '" + maNguoiDung + "'");
    }

    public void truyVanTheoMa(String ma) {
        this.maNguoiDung = ma;
        this.matKhau = sql.timKiem("MatKhau", "tblTaiKhoan", "MaNguoiDung='" + ma + "'");
        this.chucVu = sql.timKiem("ChucVu", "tblTaiKhoan", "MaNguoiDung='" + ma + "'");
        this.trangThaiTaiKhoan = sql.timKiem("TrangThaiTaiKhoan", "tblTaiKhoan", "MaNguoiDung='" + ma + "'");
    }

    public void setMaNguoiDung(String ma) {
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("loiMaNguoiDung", "Mã người dùng không được để trống");
            bao_loi = true;
        } else {
            this.maNguoiDung = ma;
        }
    }
    // !TODO thieu tim ma nguoi dung theo chuc vu
    // public void get

}
