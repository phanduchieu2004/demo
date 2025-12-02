<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký - Demo Project</title>
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
            padding: 20px;
        }
        .register-container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            width: 100%;
            max-width: 500px;
        }
        .register-container h1 {
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
        .form-group input,
        .form-group select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
            transition: border-color 0.3s;
        }
        .form-group input:focus,
        .form-group select:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 5px rgba(102, 126, 234, 0.5);
        }
        .form-row {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
        }
        .form-row .form-group {
            margin-bottom: 0;
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
        .alert.success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
            display: block;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h1>Đăng Ký Tài Khoản</h1>
        
        <% if (request.getParameter("error") != null) { 
            String error = request.getParameter("error");
            String errorMsg = "";
            if ("password".equals(error)) {
                errorMsg = "Mật khẩu không khớp!";
            } else if ("exists".equals(error)) {
                errorMsg = "Mã người dùng đã tồn tại!";
            } else if ("required".equals(error)) {
                errorMsg = "Vui lòng điền đầy đủ thông tin bắt buộc!";
            } else {
                errorMsg = "Đăng ký thất bại! Vui lòng thử lại.";
            }
        %>
            <div class="alert error">
                <%= errorMsg %>
            </div>
        <% } %>

        <form method="POST" action="<%= request.getContextPath() %>/dang-ky">
            <div class="form-group">
                <label for="maNguoiDung">Mã Người Dùng:</label>
                <input type="text" id="maNguoiDung" name="maNguoiDung" required placeholder="Ví dụ: SV001, GV001, AD001">
            </div>

            <div class="form-group">
                <label for="matKhau">Mật khẩu:</label>
                <input type="password" id="matKhau" name="matKhau" required placeholder="Nhập mật khẩu">
            </div>

            <div class="form-group">
                <label for="xacNhanMatKhau">Xác nhận mật khẩu:</label>
                <input type="password" id="xacNhanMatKhau" name="xacNhanMatKhau" required placeholder="Nhập lại mật khẩu">
            </div>

            <div class="form-group">
                <label for="chucVu">Chức Vụ:</label>
                <select id="chucVu" name="chucVu" required>
                    <option value="">-- Chọn chức vụ --</option>
                    <option value="SinhVien">Sinh Viên</option>
                    <option value="GiangVien">Giảng Viên</option>
                    <option value="Admin">Quản Trị</option>
                </select>
            </div>

            <div class="form-group">
                <button type="submit">Đăng Ký</button>
            </div>
        </form>

        <div class="links">
            <a href="<%= request.getContextPath() %>/taikhoan/dangnhap.jsp">Đăng Nhập</a>
            <span> | </span>
            <a href="<%= request.getContextPath() %>/">Về Trang Chủ</a>
        </div>
    </div>
</body>
</html>
