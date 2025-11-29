package com.example.controller.admin.quanlykhoa;

import java.io.IOException;
import java.util.Map;

import com.example.data.ChucNangSQL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachkhoa/sua" })
public class Sua extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String maKhoa = req.getParameter("MaKhoa");
        Map<String, Object> khoa = sql.hienThi_DieuKien("tblKhoa", "MaKhoa='" + maKhoa + "'").get(0);
        req.setAttribute("danhSachVien", sql.hienThi("tblVien"));
        req.setAttribute("khoa", khoa);
        req.getRequestDispatcher("/admin/danhsachkhoa/sua.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String maKhoa = req.getParameter("MaKhoa");
        String tenKhoa = req.getParameter("TenKhoa");
        String maVien = req.getParameter("MaVien");
        String tenTruongKhoa = req.getParameter("TenTruongKhoa");
        String soDienThoaiKhoa = req.getParameter("SoDienThoaiKhoa");
        String emailKhoa = req.getParameter("EmailKhoa");
        String ngayThanhLapKhoa = req.getParameter("NgayThanhLapKhoa");
        String moTaKhoa = req.getParameter("MoTaKhoa");

        // sql.suaKhoa(maKhoa, tenKhoa, maVien, tenTruongKhoa, soDienThoaiKhoa,
        // emailKhoa, ngayThanhLapKhoa, moTaKhoa);
        req.getSession().setAttribute("thongBao", "Sửa khoa thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachkhoa/index");
    }
}
