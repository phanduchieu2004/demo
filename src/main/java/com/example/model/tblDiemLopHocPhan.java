package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblDiemLopHocPhan {
    ChucNangSQL sql = new ChucNangSQL();

    public String maDiemLopHocPhan;
    public String maDangKyHocPhan;
    public Double diemQuaTrinh;
    public Double diemThi;
    public Double diemTongKet;
    public String xepLoai;
    public HttpServletRequest request;
    public Boolean bao_loi = false;

    public tblDiemLopHocPhan() {
    }

    public tblDiemLopHocPhan(HttpServletRequest req) {
        this.request = req;
    }

    public void them() {
        sql.themDiemLopHocPhan(maDiemLopHocPhan, maDangKyHocPhan, diemQuaTrinh, diemThi, diemTongKet, xepLoai);
    }

    public void them(tblDiemLopHocPhan d) {
        sql.themDiemLopHocPhan(d.maDiemLopHocPhan, d.maDangKyHocPhan, d.diemQuaTrinh, d.diemThi, d.diemTongKet,
                d.xepLoai);
    }

    public void sua() {
        sql.suaDiemLopHocPhan(maDiemLopHocPhan, maDangKyHocPhan, diemQuaTrinh, diemThi, diemTongKet, xepLoai);
    }

    public void sua(tblDiemLopHocPhan d) {
        sql.suaDiemLopHocPhan(d.maDiemLopHocPhan, d.maDangKyHocPhan, d.diemQuaTrinh, d.diemThi, d.diemTongKet,
                d.xepLoai);
    }

    public void xoa() {
        sql.xoaBanGhi("tblDiemLopHocPhan", "MaDiemLopHocPhan = '" + maDiemLopHocPhan + "'");
    }

    public void truyVanTheoMa(String ma) {
        this.maDiemLopHocPhan = ma;
        this.maDangKyHocPhan = sql.timKiem("MaDangKyHocPhan", "tblDiemLopHocPhan", "MaDiemLopHocPhan='" + ma + "'");
        this.diemQuaTrinh = Double
                .valueOf(sql.timKiem("DiemQuaTrinh", "tblDiemLopHocPhan", "MaDiemLopHocPhan='" + ma + "'"));
        this.diemThi = Double.valueOf(sql.timKiem("DiemThi", "tblDiemLopHocPhan", "MaDiemLopHocPhan='" + ma + "'"));
        this.diemTongKet = Double
                .valueOf(sql.timKiem("DiemTongKet", "tblDiemLopHocPhan", "MaDiemLopHocPhan='" + ma + "'"));
        this.xepLoai = sql.timKiem("XepLoai", "tblDiemLopHocPhan", "MaDiemLopHocPhan='" + ma + "'");
    }

    public void setMaDiemLopHocPhan(String ma) {
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("loiMaDiemLopHocPhan", "Mã điểm lớp học phần không được để trống");
            bao_loi = true;
        } else {
            this.maDiemLopHocPhan = ma;
        }
    }

    public void setMaDangKyHocPhan(String ma) {
        if (ma == null || ma.trim().isEmpty()) {
            request.setAttribute("loiMaDangKyHocPhan", "Mã đăng ký học phần không được để trống");
            bao_loi = true;
        } else {
            this.maDangKyHocPhan = ma;
        }
    }

    public void setDiemQuaTrinh(Double diem) {
        if (diem == null || diem < 0 || diem > 10) {
            request.setAttribute("loiDiemQuaTrinh", "Điểm quá trình phải từ 0 đến 10");
            bao_loi = true;
        } else {
            this.diemQuaTrinh = diem;
        }
    }

    public void setDiemThi(Double diem) {
        if (diem == null || diem < 0 || diem > 10) {
            request.setAttribute("loiDiemThi", "Điểm thi phải từ 0 đến 10");
            bao_loi = true;
        } else {
            this.diemThi = diem;
        }
    }

    public void setDiemTongKet() {
        this.diemTongKet = this.diemQuaTrinh * 0.5 + this.diemThi * 0.5;
    }

    public void setXepLoai() {
        if (this.diemTongKet > 8) {
            this.xepLoai = "Giỏi";
        } else if (this.diemTongKet >= 6.5) {
            this.xepLoai = "Khá";
        } else if (this.diemTongKet >= 5) {
            this.xepLoai = "Trung Bình";
        } else {
            this.xepLoai = "Yếu";
        }
        System.out.println("Xếp loại: " + this.xepLoai + "?");
    }

    // *get
    // public String getMaDangKyHocPhan() {
    // return maDangKyHocPhan;
    // }

    // * Lay tong the
    public String getTblDangKyHocPhan(String tenTruongCanLay) {
        String kq = sql.timKiem(tenTruongCanLay, "tblDangKyHocPhan",
                "MaDangKyHocPhan = (SELECT MaDangKyHocPhan FROM tblDiemLopHocPhan WHERE MaDiemLopHocPhan = '"
                        + maDiemLopHocPhan + "')");
        return kq;
    }

}
