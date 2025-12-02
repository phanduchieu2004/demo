package com.example.controller.admin.quanlyhocphan;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.example.data.ChucNangSQL;
import com.example.model.tblNganh;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachhocphan", "/admin/danhsachhocphan/index" })
public class Index extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Map<String, Object>> danhsach = sql.hienThi("tblHocPhan");
        for (Map<String, Object> i : danhsach) {
            tblNganh nganh = new tblNganh();
            nganh.truyVanTheoMa(i.get("MaNganh").toString());
            i.put("TenNganh", nganh.tenNganh);
        }
        req.setAttribute("danhSachHocPhan", danhsach);
        req.getRequestDispatcher("/admin/danhsachhocphan/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] maHocPhan = req.getParameterValues("MaHocPhan");
        if (maHocPhan != null) {
            for (String ma : maHocPhan) {
                sql.xoaBanGhi("tblHocPhan", "MaHocPhan = '" + ma + "'");
            }
        }
        req.getSession().setAttribute("thongBao", "Xóa các học phần đã chọn thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachhocphan");
    }
}
