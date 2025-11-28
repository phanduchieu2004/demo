package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblLopHocPhan {
    ChucNangSQL sql = new ChucNangSQL();

    public String maLopHocPhan;
    public String tenLopHocPhan;
    public String maHocPhan;
    public String msgv;
    public String thoiGian;
    public Integer soBuoi;
    public String phongHoc;
    public HttpServletRequest request;
    public Boolean bao_loi = false;

    public tblLopHocPhan() {
    }

    public tblLopHocPhan(String maLopHocPhan, String tenLopHocPhan, String maHocPhan, String msgv, String thoiGian,
            Integer soBuoi, String phongHoc) {
        this.maLopHocPhan = maLopHocPhan;
        this.tenLopHocPhan = tenLopHocPhan;
        this.maHocPhan = maHocPhan;
        this.msgv = msgv;
        this.thoiGian = thoiGian;
        this.soBuoi = soBuoi;
        this.phongHoc = phongHoc;
    }

    public tblLopHocPhan(HttpServletRequest req) {
        this.request = req;
    }

    public void them() {
        sql.themLopHocPhan(maLopHocPhan, tenLopHocPhan, maHocPhan, msgv, thoiGian, soBuoi, phongHoc);
    }

    public void them(tblLopHocPhan l) {
        sql.themLopHocPhan(l.maLopHocPhan, l.tenLopHocPhan, l.maHocPhan, l.msgv, l.thoiGian, l.soBuoi, l.phongHoc);
    }

    public void sua() {
        sql.suaLopHocPhan(maLopHocPhan, tenLopHocPhan, maHocPhan, msgv, thoiGian, soBuoi, phongHoc);
    }

    public void sua(tblLopHocPhan l) {
        sql.suaLopHocPhan(l.maLopHocPhan, l.tenLopHocPhan, l.maHocPhan, l.msgv, l.thoiGian, l.soBuoi, l.phongHoc);
    }

    public void xoa() {
        sql.xoaBanGhi("tblLopHocPhan", "MaLopHocPhan = '" + this.maLopHocPhan + "'");
    }

    public void truyVanTheoMa(String ma) {
        this.maLopHocPhan = ma;
        this.tenLopHocPhan = sql.timKiem("TenLopHocPhan", "tblLopHocPhan", "MaLopHocPhan = '" + ma + "'");
        this.maHocPhan = sql.timKiem("MaHocPhan", "tblLopHocPhan", "MaLopHocPhan = '" + ma + "'");
        this.msgv = sql.timKiem("MSGV", "tblLopHocPhan", "MaLopHocPhan = '" + ma + "'");
        this.thoiGian = sql.timKiem("ThoiGian", "tblLopHocPhan", "MaLopHocPhan = '" + ma + "'");
        this.soBuoi = Integer.valueOf(sql.timKiem("SoBuoi", "tblLopHocPhan", "MaLopHocPhan = '" + ma + "'"));
        this.phongHoc = sql.timKiem("PhongHoc", "tblLopHocPhan", "MaLopHocPhan = '" + ma + "'");
    }

    public void setMaLopHocPhan(String ma) {
        if (sql.kiemTraKhoaChinh("tblLopHocPhan", "MaLopHocPhan", ma)) {
            request.setAttribute("loiMaLopHocPhan", "Mã lớp học phần đã tồn tại");
            bao_loi = true;
        } else if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("loiMaLopHocPhan", "Mã lớp học phần không được để trống");
            bao_loi = true;
        } else {
            this.maLopHocPhan = ma;
        }
    }
    // !TODO Chua xong

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public String getMSGV() {
        return msgv;
    }

}
