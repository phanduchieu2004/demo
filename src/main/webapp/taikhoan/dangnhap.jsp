<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập - Demo Project</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .login-container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            width: 100%;
            max-width: 400px;
        }
        .login-container h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 30px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 8px;
            color: #333;
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
            transition: border-color 0.3s;
        }
        .form-group input:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 5px rgba(102, 126, 234, 0.5);
        }
        .form-group button {
            width: 100%;
            padding: 12px;
            background-color: #667eea;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .form-group button:hover {
            background-color: #5568d3;
        }
        .links {
            text-align: center;
            margin-top: 20px;
        }
        .links a {
            color: #667eea;
            text-decoration: none;
            margin: 0 10px;
        }
        .links a:hover {
            text-decoration: underline;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
        }
        .back-link a {
            color: #667eea;
            text-decoration: none;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
        .alert {
            padding: 12px;
            margin-bottom: 20px;
            border-radius: 5px;
            display: none;
        }
        .alert.error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
            display: block;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Đăng Nhập</h1>
        
        <% if (request.getParameter("error") != null) { %>
            <div class="alert error">
                Mã người dùng hoặc mật khẩu không đúng!
            </div>
        <% } %>
        
        <% if (request.getParameter("success") != null) { %>
            <div class="alert" style="background-color: #d4edda; color: #155724; border: 1px solid #c3e6cb; display: block;">
                Đăng ký thành công! Vui lòng đăng nhập.
            </div>
        <% } %>

        <form method="POST" action="<%= request.getContextPath() %>/dang-nhap">
            <div class="form-group">
                <label for="maNguoiDung">Mã Người Dùng:</label>
                <input type="text" id="maNguoiDung" name="maNguoiDung" required placeholder="Ví dụ: SV001, GV001, AD001">
            </div>

            <div class="form-group">
                <label for="matKhau">Mật khẩu:</label>
                <input type="password" id="matKhau" name="matKhau" required placeholder="Nhập mật khẩu">
            </div>

            <div class="form-group">
                <button type="submit">Đăng Nhập</button>
            </div>
        </form>

        <div class="links">
            <a href="<%= request.getContextPath() %>/taikhoan/dangky.jsp">Đăng Ký</a>
            <span> | </span>
            <a href="<%= request.getContextPath() %>/">Về Trang Chủ</a>
        </div>
    </div>
</body>
</html>
