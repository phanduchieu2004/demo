<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <title>Thêm sinh viên</title>
    <jsp:include page="/WEB-INF/views/giaodien/head.jsp" />
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/giaodien/header.jsp" />
    <jsp:include page="/WEB-INF/views/sidebar/admin.jsp" />
    <main id="main" class="main">
      <div class="pagetitle">
        <h1>Quản lý sinh viên</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">Trang chủ</li>
            <li class="breadcrumb-item active">Thêm sinh viên</li>
          </ol>
        </nav>
      </div>
      <div class="container shadow p-4">
        <form action="${pageContext.request.contextPath}/admin/danhsachsinhvien/them" method="post" enctype="multipart/form-data">
          <div class="row">
            <div class="form-group col-md-6 mb-3">
              <label>Mã sinh viên</label>
              <input type="text" class="form-control" name="MSSV" value="${not empty MSSV ? MSSV : ''}" />
              <c:if test="${not empty loiMSSV}"><small class="text-danger">${loiMSSV}</small></c:if>
            </div>
            <div class="form-group col-md-6 mb-3">
              <label>Họ tên</label>
              <input type="text" class="form-control" name="HoTenSV" value="${not empty HoTenSV ? HoTenSV : ''}" />
              <c:if test="${not empty loiHoTenSV}"><small class="text-danger">${loiHoTenSV}</small></c:if>
            </div>
            <div class="form-group col-md-6 mb-3">
              <label>Ngày sinh</label>
              <input type="date" class="form-control" name="NgaySinhSV" value="${not empty NgaySinhSV ? NgaySinhSV : ''}" />
              <c:if test="${not empty loiNgaySinhSV}"><small class="text-danger">${loiNgaySinhSV}</small></c:if>
            </div>
            <div class="form-group col-md-6 mb-3">
              <label>Giới tính</label>
              <select name="GioiTinhSV" class="form-select">
                <option value="">-- Chọn giới tính --</option>
                <option value="Nam" <c:if test="${GioiTinhSV == 'Nam'}">selected</c:if>>Nam</option>
                <option value="Nữ" <c:if test="${GioiTinhSV == 'Nữ'}">selected</c:if>>Nữ</option>
              </select>
              <c:if test="${not empty loiGioiTinhSV}"><small class="text-danger">${loiGioiTinhSV}</small></c:if>
            </div>
            <div class="form-group col-md-6 mb-3">
              <label>Quê quán</label>
              <input type="text" class="form-control" name="QueQuanSV" value="${not empty QueQuanSV ? QueQuanSV : ''}" />
              <c:if test="${not empty loiQueQuanSV}"><small class="text-danger">${loiQueQuanSV}</small></c:if>
            </div>
            <div class="form-group col-md-6 mb-3">
              <label>Email</label>
              <input type="email" class="form-control" name="EmailSV" value="${not empty EmailSV ? EmailSV : ''}" />
              <c:if test="${not empty loiEmailSV}"><small class="text-danger">${loiEmailSV}</small></c:if>
            </div>
            <div class="form-group col-md-6 mb-3">
              <label>Lớp</label>
              <select name="MaLop" class="form-select">
                <option value="">-- Chọn lớp --</option>
                <c:forEach var="lop" items="${danhSachLop}">
                  <option value="${lop.MaLop}" <c:if test="${not empty MaLop and MaLop == lop.MaLop}">selected</c:if>>${lop.TenLop}</option>
                </c:forEach>
              </select>
              <c:if test="${not empty loiMaLop}"><small class="text-danger">${loiMaLop}</small></c:if>
            </div>
            <div class="form-group col-md-6 mb-3">
              <label>Số điện thoại</label>
              <input type="text" class="form-control" name="SoDienThoaiSV" value="${not empty SoDienThoaiSV ? SoDienThoaiSV : ''}" />
              <c:if test="${not empty loiSoDienThoaiSV}"><small class="text-danger">${loiSoDienThoaiSV}</small></c:if>
            </div>
          </div>
          <div class="form-group col-md-6 mb-3">
              <label>Ảnh sinh viên</label>
              <input type="file" class="form-control" name="AnhSV" id="AnhSV" accept="image/*"/>
              <c:if test="${not empty AnhSV}"><small class="text-danger">${loiAnhSV}</small></c:if>
            </div>
          </div>
          <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/danhsachsinhvien/index">Quay lại</a>
          <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
      </div>
    </main>
    <jsp:include page="/WEB-INF/views/giaodien/footer.jsp" />
  </body>
</html>
