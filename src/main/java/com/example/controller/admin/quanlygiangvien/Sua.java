package com.example.controller.admin.quanlygiangvien;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.example.data.ChucNangSQL;
import com.example.model.tblGiangVien;
import com.example.model.tblNganh;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachgiangvien/sua" })
public class Sua extends HttpServlet {

        ChucNangSQL sql = new ChucNangSQL();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                String msgv = req.getParameter("MSGV");

                // ?Lấy danh sách viện có điều kiện theo Mã Viện
                List<Map<String, Object>> danhSach = sql.hienThi_DieuKien("tblGiangVien", "MSGV='" + msgv + "'");
                for (Map<String,Object> i : danhSach) {
                   tblGiangVien gv = new tblGiangVien();

                    tblNganh ng = new tblNganh();
                    ng.truyVanTheoMa(i.get("MaNganh").toString());
                     i.put("TenNganh", ng.tenNganh);

                }

                req.setAttribute("gv", danhSach.get(0));

                req.getRequestDispatcher("/admin/danhsachgiangvien/sua.jsp")
                                .forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                final String msgv = req.getParameter("MSGV").trim();
    final String hoTenGV = req.getParameter("HoTenGV").trim();
    final String ngaySinhGV = sql.doiDinhDangNgay(req.getParameter("NgaySinhGV").trim());
    final String gioiTinhGV = req.getParameter("GioiTinhGV").trim();
    final String queQuanGV = req.getParameter("QueQuanGV").trim();
    final String emailGV = req.getParameter("EmailGV").trim();
    final String maNganh = req.getParameter("MaNganh").trim();
    final String soDienThoaiGV = req.getParameter("SoDienThoaiGV").trim();
    final String anhGV = req.getParameter("AnhGV").trim();
    final String trangThaiGV = req.getParameter("TrangThaiGV").trim();
                
                tblGiangVien gv = new tblGiangVien(msgv, hoTenGV, ngaySinhGV,
                                   gioiTinhGV, queQuanGV, emailGV,
                                   maNganh, soDienThoaiGV, anhGV, trangThaiGV);
gv.sua(gv);

                req.getSession().setAttribute("thongBao", "Sửa viện thành công");
                resp.sendRedirect(req.getContextPath() + "/admin/danhsachgiangvien/index");
        }
        
}
