package com.example.controller.admin.quanlyvien;

import java.io.IOException;

import com.example.data.ChucNangSQL;
import com.example.model.tblVien;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachvien/them" })
public class Them extends HttpServlet {

    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/admin/danhsachvien/them.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        final String maVien = req.getParameter("MaVien").trim();
        final String tenVien = req.getParameter("TenVien").trim();
        final String tenTruongVien = req.getParameter("TenTruongVien").trim();
        final String soDienThoaiVien = req.getParameter("SoDienThoaiVien").trim();
        final String emailVien = req.getParameter("EmailVien").trim();
        final String ngayThanhLapVien = sql.doiDinhDangNgay(req.getParameter("NgayThanhLapVien").trim());
        boolean loi = false;

        if (sql.kiemTraKhoaChinh("tblVien",
                "MaVien", maVien)) {
            req.setAttribute("loiMaVien", "Mã viện đã tồn tại");
            loi = true;
        }
        if (maVien == null || maVien.trim().isEmpty()) {
            req.setAttribute("loiMaVien", "Mã viện không được để trống");
            loi = true;
        }
        if (tenVien == null || tenVien.trim().isEmpty()) {
            req.setAttribute("loiTenVien", "Tên viện không được để trống");
            loi = true;
        }
        if (tenTruongVien == null || tenTruongVien.trim().isEmpty()) {
            req.setAttribute("loiTenTruongVien", "Tên trưởng viện không được để trống");
            loi = true;
        }
        if (soDienThoaiVien == null || soDienThoaiVien.trim().isEmpty()) {
            req.setAttribute("loiSoDienThoaiVien", "Số điện thoại viện không được để trống");
            loi = true;
        }
        if (emailVien == null || emailVien.trim().isEmpty()) {
            req.setAttribute("loiEmailVien", "Email viện không được để trống");
            loi = true;
        }

        if (loi) {
            // Trả lại dữ liệu đã nhập
            req.setAttribute("MaVien", maVien);
            req.setAttribute("TenVien", tenVien);
            req.setAttribute("TenTruongVien", tenTruongVien);
            req.setAttribute("SoDienThoaiVien", soDienThoaiVien);
            req.setAttribute("EmailVien", emailVien);
            req.setAttribute("NgayThanhLapVien",
                    ngayThanhLapVien);
            // System.err.println("Lỗi rồi");
            req.getRequestDispatcher("/admin/danhsachvien/them.jsp").forward(req, resp);
            return;
        }

        tblVien vien = new tblVien(maVien, tenVien, tenTruongVien,
                soDienThoaiVien, emailVien, ngayThanhLapVien);

        vien.them(vien);
        System.out.println("Thêm viện thành công");

        // sql.themVien(maVien, tenVien, tenTruongVien, soDienThoaiVien, emailVien,
        // ngayThanhLapVien);
        req.getSession().setAttribute("thongBao", "Thêm viện thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachvien/index");
    }

}
