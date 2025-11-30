package com.example.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.example.data.ChucNangSQL;
import com.example.model.tblDangKyHocPhan;
import com.example.model.tblKhoa;
import com.example.model.tblLopHocPhan;
import com.example.model.tblNganh;
import com.example.model.tblSinhVien;
import com.example.model.tblVien;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/index", "/admin/" })
public class Index extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("");

        req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        // *Lay duoc thong tin sinh vien lop hoc phan
        // vien khoa nganh hien tenvien tenkhoa trong bang nganh
      List<Map<String, Object>> danhsach = sql.hienThi("tblDangKyHocPhan");
        for (Map<String, Object> i : danhsach) {
            tblDangKyHocPhan dk = new tblDangKyHocPhan();
            dk.truyVanTheoMa(i.get("MaDangKyHocPhan").toString());
            tblSinhVien sv = new tblSinhVien();
            sv.truyVanTheoMa(dk.mssv);
            tblLopHocPhan l = new tblLopHocPhan();
            l.truyVanTheoMa(dk.maLopHocPhan);
            System.out.println(dk.maDangKyHocPhan +"-------"+sv.hoTenSV + "-----"+ l.tenLopHocPhan + "---"+ l.soTuanHoc);
        }

        req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
    }
}
