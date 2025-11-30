<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <title>Sửa viện</title>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <!-- Include CSS files -->
    <jsp:include page="/WEB-INF/views/giaodien/head.jsp" />
  </head>

  <body>
    <!-- Include header -->
    <jsp:include page="/WEB-INF/views/giaodien/header.jsp" />

    <!-- Include sidebar -->
    <jsp:include page="/WEB-INF/views/sidebar/admin.jsp" />

    <main id="main" class="main">

      <!-- Phần đầu trang -->
      <div class="pagetitle">
        <h1>Quản lý viện</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">Trang chủ</li>
            <li class="breadcrumb-item active">Sửa viện</li>

          </ol>
        </nav>
      </div>

      <!-- Mục chính -->
      <div class="container shadow p-4">
       <form
  action="${pageContext.request.contextPath}/admin/danhsachgiangvien/sua"
  method="post"
>
  <div class="row">
    <div class="form-group col-md-6 mb-3">
      <label>Mã giảng viên</label>
      <input type="text" class="form-control" name="MSGV" value="${gv.MSGV}" readonly/>
      <c:if test="${not empty loiMSGV}">
        <small class="text-danger"><c:out value="${loiMSGV}" /></small>
      </c:if>
    </div>

    <div class="form-group col-md-6 mb-3">
      <label>Họ tên giảng viên</label>
      <input type="text" class="form-control" name="HoTenGV" value="${gv.HoTenGV}" />
      <c:if test="${not empty loiHoTenGV}">
        <small class="text-danger">${loiHoTenGV}</small>
      </c:if>
    </div>

    <div class="form-group col-md-6 mb-3">
      <label>Ngày sinh</label>
      <input type="date" class="form-control" name="NgaySinhGV" value="${gv.NgaySinhGV}" />
      <c:if test="${not empty loiNgaySinhGV}">
        <small class="text-danger">${loiNgaySinhGV}</small>
      </c:if>
    </div>

    <div class="form-group col-md-6 mb-3">
      <label>Giới tính</label>
      <input type="text" class="form-control" name="GioiTinhGV" value="${gv.GioiTinhGV}" />
      <c:if test="${not empty loiGioiTinhGV}">
        <small class="text-danger">${loiGioiTinhGV}</small>
      </c:if>
    </div>

    <div class="form-group col-md-6 mb-3">
      <label>Quê quán</label>
      <input type="text" class="form-control" name="QueQuanGV" value="${gv.QueQuanGV}" />
      <c:if test="${not empty loiQueQuanGV}">
        <small class="text-danger">${loiQueQuanGV}</small>
      </c:if>
    </div>

    <div class="form-group col-md-6 mb-3">
      <label>Email</label>
      <input type="email" class="form-control" name="EmailGV" value="${gv.EmailGV}" />
      <c:if test="${not empty loiEmailGV}">
        <small class="text-danger">${loiEmailGV}</small>
      </c:if>
    </div>

    <div class="form-group col-md-6 mb-3">
      <label>Mã ngành</label>
      <input type="text" class="form-control" name="MaNganh" value="${gv.MaNganh}" />
      <c:if test="${not empty loiMaNganh}">
        <small class="text-danger">${loiMaNganh}</small>
      </c:if>
    </div>

    <div class="form-group col-md-6 mb-3">
      <label>Số điện thoại</label>
      <input type="text" class="form-control" name="SoDienThoaiGV" value="${gv.SoDienThoaiGV}" />
      <c:if test="${not empty loiSoDienThoaiGV}">
        <small class="text-danger">${loiSoDienThoaiGV}</small>
      </c:if>
    </div>

    <div class="form-group col-md-6 mb-3">
      <label>Ảnh</label>
      <input type="text" class="form-control" name="AnhGV" value="${gv.AnhGV}" />
      <c:if test="${not empty loiAnhGV}">
        <small class="text-danger">${loiAnhGV}</small>
      </c:if>
    </div>

    <div class="form-group col-md-6 mb-3">
      <label>Trạng thái</label>
      <input type="text" class="form-control" name="TrangThaiGV" value="${gv.TrangThaiGV}" />
      <c:if test="${not empty loiTrangThaiGV}">
        <small class="text-danger">${loiTrangThaiGV}</small>
      </c:if>
    </div>
  </div>

  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/danhsachgiangvien/index">Quay lại</a>
  <button type="submit" class="btn btn-primary">Sửa</button>
</form>

      </div>
    </main>

    <!-- Include footer -->
    <jsp:include page="/WEB-INF/views/giaodien/footer.jsp" />
  </body>
</html>
