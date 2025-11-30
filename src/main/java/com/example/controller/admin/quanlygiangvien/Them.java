package com.example.controller.admin.quanlygiangvien;

import java.io.IOException;
import java.util.List;

import com.example.data.ChucNangSQL;
import com.example.model.tblGiangVien;
import com.example.model.tblNganh; // giả sử bạn có model ngành

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachgiangvien/them" })
public class Them extends HttpServlet {

    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        // Lấy danh sách ngành từ DB
       var  listNganh = sql.hienThi("tblNganh");
        req.setAttribute("listNganh", listNganh);

        req.getRequestDispatcher("/admin/danhsachgiangvien/them.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        final String MSGV = req.getParameter("MSGV").trim();
        final String HoTenGV = req.getParameter("HoTenGV").trim();
        final String NgaySinhGV = req.getParameter("NgaySinhGV").trim();
        final String GioiTinhGV = req.getParameter("GioiTinhGV").trim();
        final String QueQuanGV = req.getParameter("QueQuanGV").trim();
        final String EmailGV = req.getParameter("EmailGV").trim();
        final String MaNganh = req.getParameter("MaNganh").trim();
        final String SoDienThoaiGV = req.getParameter("SoDienThoaiGV").trim();
        final String AnhGV = req.getParameter("AnhGV").trim();
        final String TrangThaiGV = req.getParameter("TrangThaiGV").trim();

        tblGiangVien gv = new tblGiangVien();
        gv.setMSGV(MSGV);
        gv.setHoTenGV(HoTenGV);
        gv.setNgaySinhGV(NgaySinhGV);
        gv.setGioiTinhGV(GioiTinhGV);
        gv.setQueQuanGV(QueQuanGV);
        gv.setEmailGV(EmailGV);
        gv.setMaNganh(MaNganh);
        gv.setSoDienThoaiGV(SoDienThoaiGV);
        gv.setAnhGV(AnhGV);
        gv.setTrangThaiGV(TrangThaiGV);

        if (gv.bao_loi) {
            // giữ lại dữ liệu nhập và danh sách ngành để hiển thị lại form
            req.setAttribute("MSGV", MSGV);
            req.setAttribute("HoTenGV", HoTenGV);
            req.setAttribute("NgaySinhGV", NgaySinhGV);
            req.setAttribute("GioiTinhGV", GioiTinhGV);
            req.setAttribute("QueQuanGV", QueQuanGV);
            req.setAttribute("EmailGV", EmailGV);
            req.setAttribute("MaNganh", MaNganh);
            req.setAttribute("SoDienThoaiGV", SoDienThoaiGV);
            req.setAttribute("AnhGV", AnhGV);
            req.setAttribute("TrangThaiGV", TrangThaiGV);

          var listNganh = sql.hienThi("tblNganh");
            req.setAttribute("listNganh", listNganh);

            req.getRequestDispatcher("/admin/danhsachgiangvien/them.jsp").forward(req, resp);
            return;
        } else {
            gv.them();
        }
        req.getSession().setAttribute("thongBao", "Thêm giảng viên thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachgiangvien/index");
    }
}
