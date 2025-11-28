-- Tạo bảng tblVien
CREATE TABLE IF NOT EXISTS tblVien (
    IDVien INTEGER PRIMARY KEY AUTOINCREMENT,
    MaVien TEXT NULL,
    TenVien TEXT NULL,
    TenTruongVien TEXT NULL,
    SoDienThoaiVien TEXT NULL,
    EmailVien TEXT NULL,
    NgayThanhLapVien TEXT NULL
);
--Tạo bảng tblKhoa
CREATE TABLE IF NOT EXISTS tblKhoa (
    IDKhoa INTEGER PRIMARY KEY AUTOINCREMENT,
    MaKhoa TEXT NULL,
    TenKhoa TEXT NULL,
    MaVien TEXT NULL,
    TenTruongKhoa TEXT NULL,
    SoDienThoaiKhoa TEXT NULL,
    EmailKhoa TEXT NULL,
    NgayThanhLapKhoa TEXT NULL,
    MoTaKhoa TEXT NULL
);
-- Tạo bảng tblNganh
CREATE TABLE IF NOT EXISTS tblNganh (
    IDNganh INTEGER PRIMARY KEY AUTOINCREMENT,
    MaNganh TEXT NULL,
    TenNganh TEXT NULL,
    MaKhoa TEXT NULL,
    MoTaNganh TEXT NULL
);

-- Tạo bảng tblLop
CREATE TABLE IF NOT EXISTS tblLop (
    IDLop INTEGER PRIMARY KEY AUTOINCREMENT,
    MaLop TEXT NULL,
    KhoaHoc INTEGER NULL,
    TenLop TEXT NULL,
    MaNganh TEXT NULL
);

-- Tạo bảng tblGiangVien
CREATE TABLE IF NOT EXISTS tblGiangVien (
    IDGiangVien INTEGER PRIMARY KEY AUTOINCREMENT,
    MSGV TEXT NULL,
    HoTenGV TEXT NULL,
    NgaySinhGV TEXT NULL,
    GioiTinhGV TEXT NULL,
    QueQuanGV TEXT NULL,
    EmailGV TEXT NULL,
    MaNganh TEXT NULL,
    SoDienThoaiGV TEXT NULL,
    AnhGV TEXT NULL,
    TrangThaiGV TEXT NULL
);
--tblSinhVien
CREATE TABLE IF NOT EXISTS tblSinhVien (
    IDSinhVien INTEGER PRIMARY KEY AUTOINCREMENT,
    MSSV TEXT NULL,
    HoTenSV TEXT NULL,
    NgaySinhSV TEXT NULL,
    GioiTinhSV TEXT NULL,
    QueQuanSV TEXT NULL,
    EmailSV TEXT NULL,
    MaLop TEXT NULL,
    SoDienThoaiSV TEXT NULL,
    AnhSV TEXT NULL,
    TrangThaiSV TEXT NULL
);
--tblHocPhan
CREATE TABLE IF NOT EXISTS tblHocPhan (
    IDHocPhan INTEGER PRIMARY KEY AUTOINCREMENT,
    MaHocPhan TEXT NULL,
    TenHocPhan TEXT NULL,
    SoTinChi INTEGER NULL,
    MaNganh TEXT NULL,
    MoTaHocPhan TEXT NULL
);
--tblLopHocPhan
CREATE TABLE IF NOT EXISTS tblLopHocPhan (
    IDLopHocPhan INTEGER PRIMARY KEY AUTOINCREMENT,
    MaLopHocPhan TEXT NULL,
    TenLopHocPhan TEXT NULL,
    MaHocPhan TEXT NULL,
    MSGV TEXT NULL,
    ThoiGian TEXT NULL,
    SoBuoi INTEGER NULL,
    PhongHoc TEXT NULL
);
--tblDiemLopHocPhan
CREATE TABLE IF NOT EXISTS tblDiemLopHocPhan (
    IDDiemLopHocPhan INTEGER PRIMARY KEY AUTOINCREMENT,
    MSSV TEXT NULL,
    MaLopHocPhan TEXT NULL,
    DiemQuaTrinh INTEGER NULL,
    DiemThi INTEGER NULL,
    DiemTongKet INTEGER NULL
);

--tblDangKyHocPhan
CREATE TABLE IF NOT EXISTS tblDangKyHocPhan (
    IDDangKyHocPhan INTEGER PRIMARY KEY AUTOINCREMENT,
    MSSV TEXT NULL,
    MaLopHocPhan TEXT NULL,
    TrangThai TEXT NULL
);
--tblDiemDanh 
CREATE TABLE IF NOT EXISTS tblDiemDanh (
    IDDiemDanh INTEGER PRIMARY KEY AUTOINCREMENT,
    MSSV TEXT NULL,
    IDLopHocPhan INTEGER NULL,
    ChuoiDiemDanh TEXT NULL,
    GhiChu TEXT NULL
);
--tblTaiKhoan
CREATE TABLE IF NOT EXISTS tblTaiKhoan (
    IDTaiKhoan INTEGER PRIMARY KEY AUTOINCREMENT,
    MaNguoiDung TEXT NULL,
    MatKhau TEXT NULL,
    ChucVu TEXT NULL
);

----!Thêm bản ghi 
-- Thêm bản ghi cho tblVien
INSERT INTO tblVien (MaVien, TenVien, TenTruongVien, SoDienThoaiVien, EmailVien, NgayThanhLapVien) VALUES
('V001', 'Viện Công Nghệ', 'Nguyễn Văn A', '0123456789', 'vien1@univ.edu', '01/01/2020'),
('V002', 'Viện Khoa Học', 'Trần Thị B', '0222333444', 'vien2@univ.edu', '15/03/2021'),
('V003', 'Viện Kinh Tế', 'Lê Văn C', '0333444555', 'vien3@univ.edu', '28/11/2025');

-- Thêm bản ghi cho tblKhoa
INSERT INTO tblKhoa (MaKhoa, TenKhoa, MaVien, TenTruongKhoa, SoDienThoaiKhoa, EmailKhoa, NgayThanhLapKhoa, MoTaKhoa) VALUES
('K001', 'Khoa CNTT', 'V001', 'Phạm Văn D', '0444555666', 'khoa1@univ.edu', '01/09/2020', 'Công nghệ thông tin'),
('K002', 'Khoa Sinh', 'V002', 'Ngô Thị E', '0555666777', 'khoa2@univ.edu', '10/10/2021', 'Khoa học sinh học'),
('K003', 'Khoa Quản Trị', 'V003', 'Đỗ Văn F', '0666777888', 'khoa3@univ.edu', '28/11/2025', 'Quản trị kinh doanh');

-- Thêm bản ghi cho tblNganh
INSERT INTO tblNganh (MaNganh, TenNganh, MaKhoa, MoTaNganh) VALUES
('N001', 'Kỹ thuật phần mềm', 'K001', 'Đào tạo kỹ sư phần mềm'),
('N002', 'Sinh học ứng dụng', 'K002', 'Đào tạo chuyên ngành sinh học'),
('N003', 'Quản trị doanh nghiệp', 'K003', 'Đào tạo quản trị doanh nghiệp');

-- Thêm bản ghi cho tblLop
INSERT INTO tblLop (MaLop, KhoaHoc, TenLop, MaNganh) VALUES
('L001', 2021, 'KTPM01', 'N001'),
('L002', 2022, 'SH01', 'N002'),
('L003', 2023, 'QTDN01', 'N003');

-- Thêm bản ghi cho tblGiangVien
INSERT INTO tblGiangVien (MSGV, HoTenGV, NgaySinhGV, GioiTinhGV, QueQuanGV, EmailGV, MaNganh, SoDienThoaiGV, AnhGV, TrangThaiGV) VALUES
('GV001', 'Nguyễn Văn G', '05/05/1980', 'Nam', 'Hà Nội', 'gv1@univ.edu', 'N001', '0777888999', 'gv1.jpg', 'Đang công tác'),
('GV002', 'Trần Thị H', '12/12/1985', 'Nữ', 'Đà Nẵng', 'gv2@univ.edu', 'N002', '0888999000', 'gv2.jpg', 'Đang công tác'),
('GV003', 'Lê Văn I', '20/08/1975', 'Nam', 'TP.HCM', 'gv3@univ.edu', 'N003', '0999000111', 'gv3.jpg', 'Nghỉ phép');

-- Thêm bản ghi cho tblSinhVien
INSERT INTO tblSinhVien (MSSV, HoTenSV, NgaySinhSV, GioiTinhSV, QueQuanSV, EmailSV, MaLop, SoDienThoaiSV, AnhSV, TrangThaiSV) VALUES
('SV001', 'Phạm Thị J', '10/10/2003', 'Nữ', 'Hải Phòng', 'sv1@univ.edu', 'L001', '0111222333', 'sv1.jpg', 'Đang học'),
('SV002', 'Ngô Văn K', '22/02/2002', 'Nam', 'Quảng Ninh', 'sv2@univ.edu', 'L002', '0222333444', 'sv2.jpg', 'Đang học'),
('SV003', 'Đỗ Thị L', '30/03/2004', 'Nữ', 'Bắc Giang', 'sv3@univ.edu', 'L003', '0333444555', 'sv3.jpg', 'Đã tốt nghiệp');

-- Thêm bản ghi cho tblHocPhan
INSERT INTO tblHocPhan (MaHocPhan, TenHocPhan, SoTinChi, MaNganh, MoTaHocPhan) VALUES
('HP001', 'Lập trình Java', 3, 'N001', 'Lập trình hướng đối tượng'),
('HP002', 'Sinh học phân tử', 2, 'N002', 'Sinh học nâng cao'),
('HP003', 'Quản trị dự án', 3, 'N003', 'Quản lý dự án doanh nghiệp');

-- Thêm bản ghi cho tblLopHocPhan
INSERT INTO tblLopHocPhan (MaLopHocPhan, TenLopHocPhan, MaHocPhan, MSGV, ThoiGian, SoBuoi, PhongHoc) VALUES
('LHP001', 'Java cơ bản', 'HP001', 'GV001', 'Thứ 2, 7h00', 15, 'A101'),
('LHP002', 'Sinh học nâng cao', 'HP002', 'GV002', 'Thứ 3, 9h00', 10, 'B202'),
('LHP003', 'Quản trị dự án', 'HP003', 'GV003', 'Thứ 4, 13h30', 12, 'C303');

-- Thêm bản ghi cho tblDiemLopHocPhan
INSERT INTO tblDiemLopHocPhan (MSSV, MaLopHocPhan, DiemQuaTrinh, DiemThi, DiemTongKet) VALUES
('SV001', 'LHP001', 8, 7, 7),
('SV002', 'LHP002', 9, 8, 8),
('SV003', 'LHP003', 7, 6, 6);

-- Thêm bản ghi cho tblDangKyHocPhan
INSERT INTO tblDangKyHocPhan (MSSV, MaLopHocPhan, TrangThai) VALUES
('SV001', 'LHP001', 'Đã đăng ký'),
('SV002', 'LHP002', 'Đã đăng ký'),
('SV003', 'LHP003', 'Đã đăng ký');

-- Thêm bản ghi cho tblDiemDanh
INSERT INTO tblDiemDanh (MSSV, IDLopHocPhan, ChuoiDiemDanh, GhiChu) VALUES
('SV001', 1, '1010101010', 'Đi học đầy đủ'),
('SV002', 2, '1111000011', 'Vắng 2 buổi'),
('SV003', 3, '1100110011', 'Đi học đủ');

-- Thêm bản ghi cho tblTaiKhoan
INSERT INTO tblTaiKhoan (MaNguoiDung, MatKhau, ChucVu) VALUES
('SV001', 'matkhau1', 'SinhVien'),
('GV001', 'matkhau2', 'GiangVien'),
('SV003', 'matkhau3', 'SinhVien');


