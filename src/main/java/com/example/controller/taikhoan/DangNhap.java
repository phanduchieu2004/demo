package com.example.controller.taikhoan;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.data.ChucNangSQL;

@WebServlet("/dang-nhap")
public class DangNhap extends HttpServlet {
    private ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/taikhoan/dangnhap.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maNguoiDung = request.getParameter("maNguoiDung");
        String matKhau = request.getParameter("matKhau");

        // Kiểm tra tài khoản trong cơ sở dữ liệu
        String matKhauTuDB = sql.timKiem("MatKhau", "tblTaiKhoan", "MaNguoiDung = '" + maNguoiDung + "'");
        String trangThaiTuDB = sql.timKiem("TrangThaiTaiKhoan", "tblTaiKhoan", "MaNguoiDung = '" + maNguoiDung + "'");
        
        if (!matKhauTuDB.isEmpty() && matKhauTuDB.equals(matKhau) && "Hoạt động".equals(trangThaiTuDB)) {
            // Lấy thông tin người dùng
            String chucVu = sql.timKiem("ChucVu", "tblTaiKhoan", "MaNguoiDung = '" + maNguoiDung + "'");

            // Lưu vào session
            HttpSession session = request.getSession();
            session.setAttribute("maNguoiDung", maNguoiDung);
            session.setAttribute("chucVu", chucVu);
            session.setMaxInactiveInterval(30 * 60); // 30 phút

            System.out.println("Đăng nhập thành công: " + maNguoiDung + " - Chức vụ: " + chucVu);

            // Chuyển hướng đến trang admin
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            // Trả về lỗi
            System.out.println("Đăng nhập thất bại: " + maNguoiDung);
            response.sendRedirect(request.getContextPath() + "/taikhoan/dangnhap.jsp?error=1");
        }
    }
}
