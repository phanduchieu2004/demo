package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblHocPhan {
    ChucNangSQL sql = new ChucNangSQL();

    public String maHocPhan;
    public String tenHocPhan;
    public Integer soTinChi;
    public String maNganh;
    public String moTaHocPhan;
    public HttpServletRequest request;
    public Boolean bao_loi = false;

    public tblHocPhan() {
    }

    public tblHocPhan(String maHocPhan, String tenHocPhan, Integer soTinChi, String maNganh, String moTaHocPhan) {
        this.maHocPhan = maHocPhan;
        this.tenHocPhan = tenHocPhan;
        this.soTinChi = soTinChi;
        this.maNganh = maNganh;
        this.moTaHocPhan = moTaHocPhan;
    }

    public tblHocPhan(HttpServletRequest req) {
        this.request = req;
    }

    public void them() {
        sql.themHocPhan(maHocPhan, tenHocPhan, soTinChi, maNganh, moTaHocPhan);
    }

    public void them(tblHocPhan h) {
        sql.themHocPhan(h.maHocPhan, h.tenHocPhan, h.soTinChi, h.maNganh, h.moTaHocPhan);
    }

    public void sua() {
        sql.suaHocPhan(maHocPhan, tenHocPhan, soTinChi, maNganh, moTaHocPhan);
    }

    public void sua(tblHocPhan h) {
        sql.suaHocPhan(h.maHocPhan, h.tenHocPhan, h.soTinChi, h.maNganh, h.moTaHocPhan);
    }

    public void xoa() {
        sql.xoaBanGhi("tblHocPhan", "MaHocPhan = '" + this.maHocPhan + "'");
    }

    public void truyVanTheoMa(String ma) {
        this.maHocPhan = ma;
        this.tenHocPhan = sql.timKiem("TenHocPhan", "tblHocPhan", "MaHocPhan = '" + ma + "'");
        this.soTinChi = Integer.valueOf(sql.timKiem("SoTinChi", "tblHocPhan", "MaHocPhan = '" + ma + "'"));
        this.maNganh = sql.timKiem("MaNganh", "tblHocPhan", "MaHocPhan = '" + ma + "'");
        this.moTaHocPhan = sql.timKiem("MoTaHocPhan", "tblHocPhan", "MaHocPhan = '" + ma + "'");
    }

    public void setMaHocPhan(String ma) {
        if (sql.kiemTraKhoaChinh("tblHocPhan", "MaHocPhan", ma)) {
            request.setAttribute("loiMaHocPhan", "Mã học phần đã tồn tại");
            bao_loi = true;
        } else if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("loiMaHocPhan", "Mã học phần không được để trống");
            bao_loi = true;
        } else {
            this.maHocPhan = ma;
        }
    }

    public void setTenHocPhan(String ten) {
        if (ten == null || ten.trim().isEmpty()) {
            request.setAttribute("loiTenHocPhan", "Tên học phần không được để trống");
            bao_loi = true;
        } else {
            this.tenHocPhan = ten;
        }
    }

    public String getTenNganh() {
        String tenNganh = sql.timKiem("TenNganh", "tblNganh", "MaNganh = '" + this.maNganh + "'");
        if (tenNganh == null) {
            tenNganh = "";
        }
        return tenNganh;
    }

}
