package com.example.controller.taikhoan;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.data.ChucNangSQL;

@WebServlet("/dang-ky")
public class DangKy extends HttpServlet {
    private ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/taikhoan/dangky.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maNguoiDung = request.getParameter("maNguoiDung");
        String matKhau = request.getParameter("matKhau");
        String xacNhanMatKhau = request.getParameter("xacNhanMatKhau");
        String chucVu = request.getParameter("chucVu");

        // Kiểm tra mật khẩu khớp
        if (!matKhau.equals(xacNhanMatKhau)) {
            response.sendRedirect(request.getContextPath() + "/taikhoan/dangky.jsp?error=password");
            return;
        }

        // Kiểm tra mã người dùng đã tồn tại
        if (sql.kiemTraKhoaChinh("tblTaiKhoan", "MaNguoiDung", maNguoiDung)) {
            response.sendRedirect(request.getContextPath() + "/taikhoan/dangky.jsp?error=exists");
            return;
        }

        // Kiểm tra thông tin bắt buộc
        if (maNguoiDung == null || maNguoiDung.trim().isEmpty() ||
            matKhau == null || matKhau.trim().isEmpty() ||
            chucVu == null || chucVu.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/taikhoan/dangky.jsp?error=required");
            return;
        }

        try {
            // Thêm tài khoản mới
            // Chức vụ: GiangVien, SinhVien, Admin
            sql.themTaiKhoan(maNguoiDung, matKhau, chucVu, "Hoạt động");

            System.out.println("Đăng ký tài khoản thành công: " + maNguoiDung);
            // Chuyển hướng đến trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/taikhoan/dangnhap.jsp?success=1");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi khi đăng ký: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/taikhoan/dangky.jsp?error=server");
        }
    }
}
