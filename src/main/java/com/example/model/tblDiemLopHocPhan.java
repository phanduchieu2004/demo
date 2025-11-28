package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblDiemLopHocPhan {
    ChucNangSQL sql = new ChucNangSQL();

    public String maDiem;
    public String maLopHocPhan;
    public String maSinhVien;
    public Double diemQuaTrinh;
    public Double diemCuoiKy;
    public Double diemTong;
    public String ketQua;
    public HttpServletRequest request;
    public Boolean bao_loi = false;

    public tblDiemLopHocPhan() {
    }

    public tblDiemLopHocPhan(HttpServletRequest req) {
        this.request = req;
    }

    public void them() {
        sql.themDiemLopHocPhan(maSinhVien, maLopHocPhan, diemQuaTrinh, diemCuoiKy, diemTong);
    }

    public void them(tblDiemLopHocPhan d) {
        sql.themDiemLopHocPhan(d.maSinhVien, d.maLopHocPhan, d.diemQuaTrinh, d.diemCuoiKy, d.diemTong);
    }

    public void sua() {
        sql.suaDiemLopHocPhan(maDiem, maSinhVien, maLopHocPhan, diemQuaTrinh, diemCuoiKy, diemTong);
    }

    public void sua(tblDiemLopHocPhan d) {
        sql.suaDiemLopHocPhan(d.maDiem, d.maSinhVien, d.maLopHocPhan, d.diemQuaTrinh, d.diemCuoiKy, d.diemTong);
    }

    public void xoa() {
        sql.xoaBanGhi("tblDiemLopHocPhan", "MaDiem = '" + maDiem + "'");
    }

    public void truyVanTheoMa(String ma) {
        this.maDiem = ma;
        this.maLopHocPhan = sql.timKiem("IDDangKyHocPhan", "tblDiemLopHocPhan", "IDDiemLopHocPhan='" + ma + "'");
        this.maSinhVien = sql.timKiem("MSSV", "tblDiemLopHocPhan", "IDDiemLopHocPhan='" + ma + "'");
        this.diemQuaTrinh = Double
                .valueOf(sql.timKiem("DiemQuaTrinh", "tblDiemLopHocPhan", "IDDiemLopHocPhan='" + ma + "'"));
        this.diemCuoiKy = Double
                .valueOf(sql.timKiem("DiemThi", "tblDiemLopHocPhan", "IDDiemLopHocPhan='" + ma + "'"));
        this.diemTong = Double
                .valueOf(sql.timKiem("DiemTongKet", "tblDiemLopHocPhan", "IDDiemLopHocPhan='" + ma + "'"));

    }

    public void setMaDiem(String ma) {
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("loiMaDiem", "Mã điểm không được để trống");
            bao_loi = true;
        } else {
            this.maDiem = ma;
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
