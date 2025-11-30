package com.example.controller.admin.quanlygiangvien;

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

@WebServlet({ "/admin/danhsachgiangvien", "/admin/danhsachgiangvien/index" })
public class Index extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
                List<Map<String, Object>> danhsach = sql.hienThi("tblGiangVien");
        for (Map<String, Object> i : danhsach) {
            tblNganh nganh = new tblNganh();
            nganh.truyVanTheoMa(i.get("MaNganh").toString());
            i.put("TenNganh", nganh.tenNganh);
        }
        // List<Map<String, Object>> danhsach = sql.hienThi("tblGiangVien");

        // sql.boSungDS(danhsach, "TenNganh", "tblNganh", "MaNganh");
        req.setAttribute("danhSachGiangVien", danhsach);
        req.getRequestDispatcher("/admin/danhsachgiangvien/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] maKhoa = req.getParameterValues("MSGV");
        if (maKhoa != null) {
            for (String ma : maKhoa) {
                sql.xoaBanGhi("tblGiangVien", "MSGV = '" + ma + "'");
            }
        }
        req.getSession().setAttribute("thongBao", "Xóa các khoa đã chọn thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachgiangvien");
    }
}
