package com.example.controller.admin.quanlylophocphan;

import java.io.IOException;

import com.example.data.ChucNangSQL;
import com.example.model.tblLopHocPhan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachlophocphan/them" })
public class Them extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("danhSachHocPhan", sql.hienThi("tblHocPhan"));
        req.setAttribute("danhSachGiangVien", sql.hienThi("tblGiangVien"));
        req.getRequestDispatcher("/admin/danhsachlophocphan/them.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String maLopHocPhan = req.getParameter("MaLopHocPhan").trim();
        final String tenLopHocPhan = req.getParameter("TenLopHocPhan").trim();
        final String maHocPhan = req.getParameter("MaHocPhan").trim();
        final String msgv = req.getParameter("MSGV").trim();
        final String soBuoiStr = req.getParameter("SoBuoi").trim();
        final String soTietStr = req.getParameter("SoTiet").trim();
        final String soTuanHoc = req.getParameter("SoTuanHoc").trim();
        final String thuTiet = req.getParameter("ThuTiet").trim();
        final String phongHoc = req.getParameter("PhongHoc").trim();
        final String thoiGianBatDau = req.getParameter("ThoiGianBatDau").trim();
        final String thoiGianKetThuc = req.getParameter("ThoiGianKetThuc").trim();
        final String thoiGianHoc = req.getParameter("ThoiGianHoc").trim();
        final String soLuongToiDaStr = req.getParameter("SoLuongToiDa").trim();
        final String trangThai = req.getParameter("TrangThaiLopHocPhan").trim();

        Integer soBuoi = null, soTiet = null, soLuongToiDa = null;
        try {
            soBuoi = Integer.valueOf(soBuoiStr);
        } catch (Exception e) {
        }
        try {
            soTiet = Integer.valueOf(soTietStr);
        } catch (Exception e) {
        }
        try {
            soLuongToiDa = Integer.valueOf(soLuongToiDaStr);
        } catch (Exception e) {
        }

        tblLopHocPhan lhp = new tblLopHocPhan(req);
        lhp.setMaLopHocPhan(maLopHocPhan);
        lhp.setTenLopHocPhan(tenLopHocPhan);
        lhp.setMaHocPhan(maHocPhan);
        lhp.setMSGV(msgv);
        lhp.setSoBuoi(soBuoi);
        lhp.setSoTiet(soTiet);
        lhp.setSoTuanHoc(soTuanHoc);
        lhp.setThuTiet(thuTiet);
        lhp.setPhongHoc(phongHoc);
        lhp.setThoiGianBatDau(thoiGianBatDau);
        lhp.setThoiGianKetThuc(thoiGianKetThuc);
        lhp.setThoiGianHoc(thoiGianHoc);
        lhp.setSoLuongToiDa(soLuongToiDa);
        lhp.setTrangThaiLopHocPhan(trangThai);

        if (lhp.bao_loi) {
            req.setAttribute("danhSachHocPhan", sql.hienThi("tblHocPhan"));
            req.setAttribute("danhSachGiangVien", sql.hienThi("tblGiangVien"));
            req.getRequestDispatcher("/admin/danhsachlophocphan/them.jsp").forward(req, resp);
            return;
        } else {
            lhp.them();
        }
        req.getSession().setAttribute("thongBao", "Thêm lớp học phần thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachlophocphan");
    }
}
