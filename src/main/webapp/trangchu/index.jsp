<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ - Demo Project</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            color: #333;
        }
        header {
            background-color: #2c3e50;
            color: white;
            padding: 20px 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px 40px;
        }
        header h1 {
            flex: 1;
            text-align: center;
        }
        .auth-buttons {
            display: flex;
            gap: 10px;
        }
        .auth-buttons a {
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .auth-buttons a:hover {
            background-color: #2980b9;
        }
        .auth-buttons a.login {
            background-color: #e74c3c;
        }
        .auth-buttons a.login:hover {
            background-color: #c0392b;
        }
        nav {
            background-color: #34495e;
            padding: 10px 0;
        }
        nav a {
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            display: inline-block;
        }
        nav a:hover {
            background-color: #2c3e50;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        .content {
            background-color: #ecf0f1;
            padding: 30px;
            border-radius: 5px;
            margin: 20px 0;
        }
        .features {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin: 30px 0;
        }
        .feature-card {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .feature-card h3 {
            color: #2c3e50;
            margin-bottom: 10px;
        }
        footer {
            background-color: #2c3e50;
            color: white;
            text-align: center;
            padding: 20px 0;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Quản lý sinh viên</h1>
        <div class="auth-buttons">
            <a href="${pageContext.request.contextPath}/taikhoan/dangnhap.jsp" class="login">Đăng Nhập</a>
            <a href="${pageContext.request.contextPath}/taikhoan/dangky.jsp">Đăng Ký</a>
        </div>
    </header>
    
    <nav>
        <a href="${pageContext.request.contextPath}/">Trang Chủ</a>
        <a href="#">Về Chúng Tôi</a>
        <a href="#">Dịch Vụ</a>
        <a href="#">Liên Hệ</a>
    </nav>
    
    <div class="container">
        <div class="content">
            <h2>Chào mừng đến với cổng quản lý sinh viên</h2>
            <p>Đây là một ứng dụng quản lý học tập được xây dựng với Java Web.</p>
            <p>Ngày hôm nay: <%= new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date()) %></p>
        </div>

        <h2>Giới thiệu tính năng chính của hệ thống</h2>
        <div class="features">
            <div class="feature-card">
                <h3>Quản lý Viện</h3>
                <p>Theo dõi và quản lý thông tin viện một cách hiệu quả.</p>
            </div>
            <div class="feature-card">
                <h3>Quản lý Khoa</h3>
                <p>Theo dõi và quản lý thông tin khoa một cách hiệu quả.</p>
            </div>
            <div class="feature-card">
                <h3>Quản lý ngành</h3>
                <p>Theo dõi và quản lý thông tin ngành một cách hiệu quả.</p>
            </div>
            <div class="feature-card">
                <h3>Quản lý lớp</h3>
                <p>Theo dõi và quản lý thông tin lớp một cách hiệu quả.</p>
            </div>
            <div class="feature-card">
                <h3>Quản lý sinh viên</h3>
                <p>Theo dõi và quản lý thông tin sinh viên một cách hiệu quả.</p>
            </div>
            <div class="feature-card">
                <h3>Quản lý giảng viên</h3>
                <p>Quản lý hồ sơ và lịch giảng dạy của các giảng viên.</p>
            </div>
            <div class="feature-card">
                <h3>Quản lý học phần</h3>
                <p>Tổ chức và quản lý các học phần và lớp học phần.</p>
            </div>
            <div class="feature-card">
                <h3>Quản lý lớp học phần</h3>
                <p>Quản lý các lớp học phần được tạo ra để sinh viên đăng ký.</p>
            </div>
            <div class="feature-card">
                <h3>Đăng ký học</h3>
                <p>Cho phép sinh viên đăng ký học và kiểm tra đăng ký, huỷ đăng ký.</p>
            </div>
            <div class="feature-card">
                <h3>Quản lý điểm</h3>
                <p>Ghi nhận và quản lý điểm số của sinh viên.</p>
            </div>
            
            
        </div>
    </div>
    
    <footer>
        <p>&copy; 2025 Demo Project. All rights reserved.</p>
    </footer>
</body>
</html>