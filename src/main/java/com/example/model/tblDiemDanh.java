package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblDiemDanh {
    ChucNangSQL sql = new ChucNangSQL();

    public String maDiemDanh;
    public String maLopHocPhan;
    public String maSinhVien;
    public String ngayDiemDanh; // stored as text
    public Boolean coMat;
    public HttpServletRequest request;
    public Boolean bao_loi = false;

    public tblDiemDanh() {
    }

    public tblDiemDanh(HttpServletRequest req) {
        this.request = req;
    }

    public void them() {
        // Map fields into DB columns: MSSV, IDLopHocPhan, ChuoiDiemDanh, GhiChu
        String chuoi = ngayDiemDanh == null ? "" : ngayDiemDanh;
        String ghi = (coMat == null ? "0" : (coMat ? "1" : "0"));
        sql.themDiemDanh(maSinhVien, maLopHocPhan, chuoi, ghi);
    }

    public void them(tblDiemDanh d) {
        sql.themDiemDanh(d.maSinhVien, d.maLopHocPhan, d.ngayDiemDanh == null ? "" : d.ngayDiemDanh,
                (d.coMat == null ? "0" : (d.coMat ? "1" : "0")));
    }

    public void sua() {
        String chuoi = ngayDiemDanh == null ? "" : ngayDiemDanh;
        String ghi = (coMat == null ? "0" : (coMat ? "1" : "0"));
        sql.suaDiemDanh(maDiemDanh, maSinhVien, maLopHocPhan, chuoi, ghi);
    }

    public void sua(tblDiemDanh d) {
        sql.suaDiemDanh(d.maDiemDanh, d.maSinhVien, d.maLopHocPhan, d.ngayDiemDanh == null ? "" : d.ngayDiemDanh,
                (d.coMat == null ? "0" : (d.coMat ? "1" : "0")));
    }

    public void xoa() {
        sql.xoaBanGhi("tblDiemDanh", "MaDiemDanh = '" + maDiemDanh + "'");
    }

    public void truyVanTheoMa(String ma) {
        this.maDiemDanh = ma;
        this.maLopHocPhan = sql.timKiem("MaLopHocPhan", "tblDiemDanh", "MaDiemDanh='" + ma + "'");
        this.maSinhVien = sql.timKiem("MaSinhVien", "tblDiemDanh", "MaDiemDanh='" + ma + "'");
        this.ngayDiemDanh = sql.timKiem("NgayDiemDanh", "tblDiemDanh", "MaDiemDanh='" + ma + "'");
        String cm = sql.timKiem("CoMat", "tblDiemDanh", "MaDiemDanh='" + ma + "'");
        this.coMat = "1".equals(cm) || "true".equalsIgnoreCase(cm);
    }

    public void setMaDiemDanh(String ma) {
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("loiMaDiemDanh", "Mã điểm danh không được để trống");
            bao_loi = true;
        } else {
            this.maDiemDanh = ma;
        }
    }

    // !TODO Chua xong
    public String getMaLopHocPhan() {
        return maLopHocPhan;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

}
