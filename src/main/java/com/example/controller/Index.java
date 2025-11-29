package com.example.controller;

import java.io.IOException;
import java.util.Map;

import com.example.data.ChucNangSQL;
import com.example.model.tblKhoa;
import com.example.model.tblNganh;
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
        int count = 0;
        String lenhDieuKien = "MaNganh = 'N001' OR MaNganh = 'N002'";
        for (Map<String, Object> i : sql.hienThi_DieuKien("tblNganh", lenhDieuKien)) {
            // !long bang
            System.out.println("----- Nganh thu " + (++count) + " -----");
            tblNganh nganh = new tblNganh();
            nganh.truyVanTheoMa(i.get("MaNganh").toString());
            tblKhoa khoa = new tblKhoa();
            khoa.truyVanTheoMa(nganh.maKhoa);
            System.out.println("ten khoa: " + khoa.tenKhoa);
            tblVien vien = new tblVien();
            vien.truyVanTheoMa(khoa.maVien);
            System.out.println("ten vien: " + vien.tenVien);
        }

        req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
    }
}
