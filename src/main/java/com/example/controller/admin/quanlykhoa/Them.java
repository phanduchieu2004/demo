package com.example.controller.admin.quanlykhoa;

import java.io.IOException;

import com.example.data.ChucNangSQL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachkhoa/them" })
public class Them extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("danhSachVien", sql.hienThi("tblVien"));
        req.getRequestDispatcher("/admin/danhsachkhoa/them.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String maKhoa = req.getParameter("MaKhoa").trim();
        final String tenKhoa = req.getParameter("TenKhoa").trim();
        final String maVien = req.getParameter("MaVien").trim();
        final String tenTruongKhoa = req.getParameter("TenTruongKhoa").trim();
        final String soDienThoaiKhoa = req.getParameter("SoDienThoaiKhoa").trim();
        final String emailKhoa = req.getParameter("EmailKhoa").trim();
        final String ngayThanhLapKhoa = req.getParameter("NgayThanhLapKhoa").trim();
        final String moTaKhoa = req.getParameter("MoTaKhoa").trim();

        boolean loi = false;
        if (sql.kiemTraKhoaChinh("tblKhoa", "MaKhoa", maKhoa)) {
            req.setAttribute("loiMaKhoa", "Mã khoa đã tồn tại");
            loi = true;
        }
        if (maKhoa == null || maKhoa.isEmpty()) {
            req.setAttribute("loiMaKhoa", "Mã khoa không được để trống");
            loi = true;
        }
        if (tenKhoa == null || tenKhoa.isEmpty()) {
            req.setAttribute("loiTenKhoa", "Tên khoa không được để trống");
            loi = true;
        }
        if (maVien == null || maVien.isEmpty()) {
            req.setAttribute("loiMaVien", "Viện không được để trống");
            loi = true;
        }
        if (loi) {
            req.setAttribute("MaKhoa", maKhoa);
            req.setAttribute("TenKhoa", tenKhoa);
            req.setAttribute("MaVien", maVien);
            req.setAttribute("TenTruongKhoa", tenTruongKhoa);
            req.setAttribute("SoDienThoaiKhoa", soDienThoaiKhoa);
            req.setAttribute("EmailKhoa", emailKhoa);
            req.setAttribute("NgayThanhLapKhoa", ngayThanhLapKhoa);
            req.setAttribute("MoTaKhoa", moTaKhoa);
            req.setAttribute("danhSachVien", sql.hienThi("tblVien"));
            req.getRequestDispatcher("/admin/danhsachkhoa/them.jsp").forward(req, resp);
            return;
        }

        // sql.themKhoa(maKhoa, tenKhoa, maVien, tenTruongKhoa, soDienThoaiKhoa,
        // emailKhoa, ngayThanhLapKhoa, moTaKhoa);
        req.getSession().setAttribute("thongBao", "Thêm khoa thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachkhoa/index");
    }
}
