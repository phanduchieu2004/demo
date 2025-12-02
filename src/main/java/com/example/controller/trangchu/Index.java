package com.example.controller.trangchu;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/", "/trangchu", "/trangchu/index"})
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập các attribute cho trang chủ
        request.setAttribute("pageTitle", "Trang Chủ");
        request.setAttribute("currentDate", new java.util.Date());
        
        // Forward đến trang chủ JSP
        request.getRequestDispatcher("/trangchu/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
