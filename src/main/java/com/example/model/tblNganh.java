package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblNganh {
    ChucNangSQL sql = new ChucNangSQL();

    public String maNganh;
    public String tenNganh;
    public String maKhoa;
    public String moTaNganh;
    public HttpServletRequest request;
    public Boolean bao_loi = false;

    public tblNganh() {
    }

    public tblNganh(String maNganh, String tenNganh, String maKhoa, String moTaNganh) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.maKhoa = maKhoa;
        this.moTaNganh = moTaNganh;
    }

    public tblNganh(HttpServletRequest req) {
        this.request = req;
    }

    public void them() {
        sql.themNganh(maNganh, tenNganh, maKhoa, moTaNganh);
    }

    public void them(tblNganh n) {
        sql.themNganh(n.maNganh, n.tenNganh, n.maKhoa, n.moTaNganh);
    }

    public void sua() {
        sql.suaNganh(maNganh, tenNganh, maKhoa, moTaNganh);
    }

    public void sua(tblNganh n) {
        sql.suaNganh(n.maNganh, n.tenNganh, n.maKhoa, n.moTaNganh);
    }

    public void xoa() {
        sql.xoaBanGhi("tblNganh", "MaNganh = '" + this.maNganh + "'");
    }

    public void truyVanTheoMa(String ma) {
        this.maNganh = ma;
        this.tenNganh = sql.timKiem("TenNganh", "tblNganh", "MaNganh = '" + ma + "'");
        this.maKhoa = sql.timKiem("MaKhoa", "tblNganh", "MaNganh = '" + ma + "'");
        this.moTaNganh = sql.timKiem("MoTaNganh", "tblNganh", "MaNganh = '" + ma + "'");
    }

    public void setMaNganh(String maNganh) {
        if (sql.kiemTraKhoaChinh("tblNganh", "MaNganh", maNganh)) {
            request.setAttribute("loiMaNganh", "Mã ngành đã tồn tại");
            bao_loi = true;
        } else if (maNganh == null || maNganh.trim().isEmpty()) {
            request.setAttribute("loiMaNganh", "Mã ngành không được để trống");
            bao_loi = true;
        } else {
            this.maNganh = maNganh;
        }
    }

    public void setTenNganh(String tenNganh) {
        if (tenNganh == null || tenNganh.trim().isEmpty()) {
            request.setAttribute("loiTenNganh", "Tên ngành không được để trống");
            bao_loi = true;
        } else {
            this.tenNganh = tenNganh;
        }
    }
    // !TODO Chua xong

    public String getMaKhoa() {
        return maKhoa;
    }

}
