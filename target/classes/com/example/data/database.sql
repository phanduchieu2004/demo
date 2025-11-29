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
    MoTaKhoa TEXT NULL,
    TrangThaiKhoa TEXT NULL
);
-- Tạo bảng tblNganh
CREATE TABLE IF NOT EXISTS tblNganh (
    IDNganh INTEGER PRIMARY KEY AUTOINCREMENT,
    MaNganh TEXT NULL,
    TenNganh TEXT NULL,
    MaKhoa TEXT NULL,
    MoTaNganh TEXT NULL,
    TrangThaiNganh TEXT NULL
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
    HocKy INTEGER NULL,
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
    SoBuoi INTEGER NULL,
    SoTiet INTEGER NULL,
    SoTuanHoc TEXT NULL,
    ThuTiet TEXT NULL,
    PhongHoc TEXT NULL,
    ThoiGianBatDau TEXT NULL,
    ThoiGianKetThuc TEXT NULL,
    ThoiGianHoc TEXT NULL,
    SoLuongToiDa INTEGER NULL,
    TrangThaiLopHocPhan TEXT NULL
);
--tblDangKyHocPhan
CREATE TABLE IF NOT EXISTS tblDangKyHocPhan (
    IDDangKyHocPhan INTEGER PRIMARY KEY AUTOINCREMENT,
    MaDangKyHocPhan TEXT NULL,
    MSSV TEXT NULL,
    MaLopHocPhan TEXT NULL,
    TrangThaiDangKyHocPhan TEXT NULL
);
--tblDiemLopHocPhan
CREATE TABLE IF NOT EXISTS tblDiemLopHocPhan (
    IDDiemLopHocPhan INTEGER PRIMARY KEY AUTOINCREMENT,
    MaDiemLopHocPhan TEXT NULL,
    MaDangKyHocPhan INTEGER NULL,
    DiemQuaTrinh REAL NULL,
    DiemThi REAL NULL,
    DiemTongKet REAL NULL,
    XepLoai TEXT NULL
);

--tblDiemDanh 
CREATE TABLE IF NOT EXISTS tblDiemDanh (
    IDDiemDanh INTEGER PRIMARY KEY AUTOINCREMENT,
    MaDiemDanh TEXT NULL,
    MaDangKyHocPhan INTEGER NULL,
    ChuoiDiemDanh TEXT NULL,
    GhiChu TEXT NULL
);
--tblTaiKhoan
CREATE TABLE IF NOT EXISTS tblTaiKhoan (
    IDTaiKhoan INTEGER PRIMARY KEY AUTOINCREMENT,
    MaNguoiDung TEXT NULL,
    MatKhau TEXT NULL,
    ChucVu TEXT NULL,
    TrangThaiTaiKhoan TEXT NULL
);
---- ! Them du lieu
-- tblVien
INSERT INTO tblVien (MaVien, TenVien, TenTruongVien, SoDienThoaiVien, EmailVien, NgayThanhLapVien) VALUES
('V001', 'Viện CNTT', 'Nguyễn Văn A', '0901111111', 'viencntt@uni.edu.vn', '01/09/2000'),
('V002', 'Viện Kỹ thuật', 'Trần Thị B', '0902222222', 'vienkt@uni.edu.vn', '15/08/2001'),
('V003', 'Viện Khoa học', 'Lê Văn C', '0903333333', 'vienkh@uni.edu.vn', '20/07/2002'),
('V004', 'Viện Quản trị', 'Phạm Văn D', '0904444444', 'vienqt@uni.edu.vn', '10/06/2003');

-- tblKhoa
INSERT INTO tblKhoa (MaKhoa, TenKhoa, MaVien, TenTruongKhoa, SoDienThoaiKhoa, EmailKhoa, NgayThanhLapKhoa, MoTaKhoa, TrangThaiKhoa) VALUES
('K001', 'Khoa CNTT', 'V001', 'Nguyễn Văn E', '0911111111', 'khoacntt@uni.edu.vn', '01/09/2000', 'Đào tạo CNTT', 'Hoạt động'),
('K002', 'Khoa Điện', 'V002', 'Trần Thị F', '0912222222', 'khoadien@uni.edu.vn', '15/08/2001', 'Đào tạo Điện', 'Hoạt động'),
('K003', 'Khoa KH', 'V003', 'Lê Văn G', '0913333333', 'khoakh@uni.edu.vn', '20/07/2002', 'Đào tạo KH', 'Hoạt động'),
('K004', 'Khoa QT', 'V004', 'Phạm Văn H', '0914444444', 'khoaqt@uni.edu.vn', '10/06/2003', 'Đào tạo QT', 'Hoạt động');

-- tblNganh
INSERT INTO tblNganh (MaNganh, TenNganh, MaKhoa, MoTaNganh, TrangThaiNganh) VALUES
('N001', 'Khoa học máy tính', 'K001', 'Lập trình, hệ thống', 'Hoạt động'),
('N002', 'Kỹ thuật điện', 'K002', 'Điện, điện tử', 'Hoạt động'),
('N003', 'Khoa học vật liệu', 'K003', 'Vật liệu mới', 'Hoạt động'),
('N004', 'Quản trị kinh doanh', 'K004', 'Quản lý doanh nghiệp', 'Hoạt động');

-- tblLop
INSERT INTO tblLop (MaLop, KhoaHoc, TenLop, MaNganh) VALUES
('L001', 2021, 'CNTT01', 'N001'),
('L002', 2021, 'Dien01', 'N002'),
('L003', 2021, 'VatLieu01', 'N003'),
('L004', 2021, 'QT01', 'N004');

-- tblGiangVien
INSERT INTO tblGiangVien (MSGV, HoTenGV, NgaySinhGV, GioiTinhGV, QueQuanGV, EmailGV, MaNganh, SoDienThoaiGV, AnhGV, TrangThaiGV) VALUES
('GV001', 'Nguyễn Văn I', '10/10/1980', 'Nam', 'Hà Nội', 'nguyenvani@uni.edu.vn', 'N001', '0921111111', '', 'Hoạt động'),
('GV002', 'Trần Thị J', '12/12/1982', 'Nữ', 'Hải Phòng', 'tranthij@uni.edu.vn', 'N002', '0922222222', '', 'Hoạt động'),
('GV003', 'Lê Văn K', '15/05/1979', 'Nam', 'Đà Nẵng', 'levank@uni.edu.vn', 'N003', '0923333333', '', 'Hoạt động'),
('GV004', 'Phạm Văn L', '20/08/1985', 'Nam', 'Huế', 'phamvanl@uni.edu.vn', 'N004', '0924444444', '', 'Hoạt động');

-- tblSinhVien
INSERT INTO tblSinhVien (MSSV, HoTenSV, NgaySinhSV, GioiTinhSV, QueQuanSV, EmailSV, MaLop, SoDienThoaiSV, AnhSV, TrangThaiSV) VALUES
('SV001', 'Phạm Văn M', '01/01/2003', 'Nam', 'Hà Nội', 'phamvanm@uni.edu.vn', 'L001', '0931111111', '', 'Hoạt động'),
('SV002', 'Ngô Thị N', '02/02/2003', 'Nữ', 'Hải Phòng', 'ngothin@uni.edu.vn', 'L002', '0932222222', '', 'Hoạt động'),
('SV003', 'Đỗ Văn O', '03/03/2003', 'Nam', 'Đà Nẵng', 'dovano@uni.edu.vn', 'L003', '0933333333', '', 'Hoạt động'),
('SV004', 'Lê Thị P', '04/04/2003', 'Nữ', 'Huế', 'lethip@uni.edu.vn', 'L004', '0934444444', '', 'Hoạt động');

-- tblHocPhan
INSERT INTO tblHocPhan (MaHocPhan, TenHocPhan, SoTinChi, HocKy, MaNganh, MoTaHocPhan) VALUES
('HP001', 'Lập trình Java', 3, 1, 'N001', 'Java cơ bản'),
('HP002', 'Mạch điện tử', 3, 1, 'N002', 'Điện tử cơ bản'),
('HP003', 'Vật liệu nano', 2, 1, 'N003', 'Vật liệu nano'),
('HP004', 'Quản trị học', 2, 1, 'N004', 'Quản trị doanh nghiệp');

-- tblLopHocPhan
INSERT INTO tblLopHocPhan (MaLopHocPhan, TenLopHocPhan, MaHocPhan, MSGV, SoBuoi, SoTiet, SoTuanHoc, ThuTiet, PhongHoc, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianHoc, SoLuongToiDa, TrangThaiLopHocPhan) VALUES
('LHP001', 'Java 01', 'HP001', 'GV001', 15, 45, '15', 'Thứ 2', 'A101', '01/09/2025', '15/12/2025', '8:00-10:00', 40, 'Hoạt động'),
('LHP002', 'Điện tử 01', 'HP002', 'GV002', 15, 45, '15', 'Thứ 3', 'B202', '01/09/2025', '15/12/2025', '10:00-12:00', 40, 'Hoạt động'),
('LHP003', 'Nano 01', 'HP003', 'GV003', 12, 36, '12', 'Thứ 4', 'C303', '01/09/2025', '15/12/2025', '13:00-15:00', 35, 'Hoạt động'),
('LHP004', 'Quản trị 01', 'HP004', 'GV004', 12, 36, '12', 'Thứ 5', 'D404', '01/09/2025', '15/12/2025', '15:00-17:00', 35, 'Hoạt động');

-- tblDangKyHocPhan
INSERT INTO tblDangKyHocPhan (MaDangKyHocPhan, MSSV, MaLopHocPhan, TrangThaiDangKyHocPhan) VALUES
('DK001', 'SV001', 'LHP001', 'Đã đăng ký'),
('DK002', 'SV002', 'LHP002', 'Đã đăng ký'),
('DK003', 'SV003', 'LHP003', 'Đã đăng ký'),
('DK004', 'SV004', 'LHP004', 'Đã đăng ký');

-- tblDiemLopHocPhan
INSERT INTO tblDiemLopHocPhan (MaDiemLopHocPhan, MaDangKyHocPhan, DiemQuaTrinh, DiemThi, DiemTongKet, XepLoai) VALUES
('DLHP001', 1, 8.0, 7.5, 7.8, 'Khá'),
('DLHP002', 2, 7.0, 6.5, 6.8, 'Trung bình'),
('DLHP003', 3, 9.0, 8.5, 8.8, 'Giỏi'),
('DLHP004', 4, 8.5, 8.0, 8.3, 'Khá');

-- tblDiemDanh
INSERT INTO tblDiemDanh (MaDiemDanh, MaDangKyHocPhan, ChuoiDiemDanh, GhiChu) VALUES
('DD001', 1, '111110000111', 'Đầy đủ'),
('DD002', 2, '111111111111', 'Đầy đủ'),
('DD003', 3, '110011001100', 'Thiếu'),
('DD004', 4, '111100001111', 'Đầy đủ');

-- tblTaiKhoan
INSERT INTO tblTaiKhoan (MaNguoiDung, MatKhau, ChucVu, TrangThaiTaiKhoan) VALUES
('SV001', '123456', 'SinhVien', 'Hoạt động'),
('GV001', 'abcdef', 'GiangVien', 'Hoạt động'),
('AD001', 'admin', 'Admin', 'Hoạt động'),
('SV002', '654321', 'SinhVien', 'Hoạt động');