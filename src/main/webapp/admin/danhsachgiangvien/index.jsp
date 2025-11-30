<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <title>Danh sách giảng viên</title>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <!-- CSS files -->
    <jsp:include page="/WEB-INF/views/giaodien/head.jsp" />
  </head>

  <body>
    <!-- Header -->
    <jsp:include page="/WEB-INF/views/giaodien/header.jsp" />

    <!-- Sidebar -->
    <jsp:include page="/WEB-INF/views/sidebar/admin.jsp" />

    <main id="main" class="main">
      <!-- Phần thông báo -->
      <c:if test="${not empty thongBao}">
        <div
          class="alert alert-success alert-dismissible fade show"
          role="alert"
        >
          <strong>Thông báo:</strong>
          <c:out value="${thongBao}" />
          <c:remove scope="session" var="thongBao" />
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="alert"
            aria-label="Close"
          ></button>
        </div>
      </c:if>

      <!-- Phần đầu trang -->
      <div class="pagetitle">
        <h1>Quản lý giảng viên</h1>
        <nav>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">Trang chủ</li>
            <li class="breadcrumb-item active">Danh sách giảng viên</li>
          </ol>
        </nav>
      </div>


      <!-- Nút Thêm viện -->
      <a
        class="btn btn-danger btn-sm"
        href="${pageContext.request.contextPath}/admin/danhsachgiangvien/them"
        >Thêm</a
      >
      <br /><br />
      <!-- Mục chính -->
      <section class="section dashboard">
        <form
          action="${pageContext.request.contextPath}/admin/danhsachgiangvienx"
          method="post"
        >
          <button
            class="btn btn-primary btn-sm"
            type="submit"
            style="margin-bottom: 10px"
            onclick="return confirm('Bạn có chắc chắn muốn xóa các mục đã chọn không?');"
          >
            Xóa các mục đã chọn
          </button>
          <br />
          <div class="row">
            <div class="col-lg-12">
              <div
                class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns"
              >
                <table class="table datatable table-bordered table-striped">
                  <thead>
                <tr>
                                            <th class="col text-center"
                                                scope="col"></th>
                                            <th class="col text-center"
                                                scope="col">Mã giảng viên</th>
                                            <th class="col text-center"
                                                scope="col">Họ tên giảng viên</th>
                                            <th class="col text-center"
                                                scope="col">Ngày sinh</th>
                                            <th class="col text-center"
                                                scope="col">Giới tính</th>
                                            <th class="col text-center"
                                                scope="col">Quê quán</th>
                                            <th class="col text-center"
                                                scope="col">Email</th>
                                            <th class="col text-center"
                                                scope="col">Tên ngành</th>

                                            <th class="col text-center"
                                                scope="col">Số điện thoại</th>

                                            <th class="col text-center"
                                                scope="col">Ảnh</th>
                                            <th class="col text-center"
                                                scope="col">Trạng thái</th>

                                            <th class="col text-center"
                                                scope="col">Hành động</th>
                                        </tr>
                  </thead>
                  <tbody>
                    <!-- Danh sách -->
                    <c:forEach var="gv" items="${danhSachGiangVien}">
                     <tr>
                                                <td class="col text-center"
                                                    scope="row">
                                                    <input
                                                        type="checkbox"
                                                        name="MSGV"
                                                        value="${gv.MSGV}" />
                                                </td>
                                                 <td class="col text-center"
                                                    scope="row">
                                                    <c:out
                                                        value="${gv.MSGV}" />
                                                </td>
                                                <td class="col text-center"
                                                    scope="row">
                                                    <c:out
                                                        value="${gv.HoTenGV}" />
                                                </td>
                                                <td class="col text-center"
                                                    scope="row">
                                                    <c:out
                                                        value="${gv.NgaySinhGV}" />
                                                </td>
                                                <td class="col text-center"
                                                    scope="row">
                                                    <c:out
                                                        value="${gv.GioiTinhGV}" />
                                                </td>
                                                <td class="col text-center"
                                                    scope="row">
                                                    <c:out
                                                        value="${gv.QueQuanGV}" />
                                                </td>
                                                <td class="col text-center"
                                                    scope="row">
                                                    <c:out
                                                        value="${gv.EmailGV}" />
                                                </td>
                                                <td class="col text-center"
                                                    scope="row">
                                                    <c:out
                                                        value="${gv.TenNganh}" />
                                                </td>
                                                <td class="col text-center"
                                                    scope="row">
                                                    <c:out
                                                        value="${gv.SoDienThoaiGV}" />
                                                   <td class="col text-center" scope="row">
                          <img
                            src="${pageContext.request.contextPath}/static/uploads/${gv.AnhGV}"
                            alt="${gv.AnhGV}"
                            style="width: 60px; height: 70px; object-fit: cover"
                          />
                        </td>
                                                    <td class="col text-center"
                                                        scope="row">
                                                        <c:out
                                                            value="${gv.TrangThaiGV}" />
                                                    </td>
                        <td class="col text-center" scope="row">
                          <a
                            class="btn btn-primary btn-sm"
                            href="${pageContext.request.contextPath}/admin/danhsachgiangvien/sua?MSGV=${gv.MSGV}"
                            >Sửa</a
                          >
                          <a
                            class="btn btn-danger btn-sm"
                            href="${pageContext.request.contextPath}/admin/danhsachgiangvien/xoa?MSGV=${gv.MSGV}"
                            onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"
                            >Xóa</a
                          >
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </form>
      </section>
    </main>

    <!-- Footer -->
    <jsp:include page="/WEB-INF/views/giaodien/footer.jsp" />
  </body>
</html>
