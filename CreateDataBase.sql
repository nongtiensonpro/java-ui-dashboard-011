/**
 *
 * @author Nong_Tien_Son
 */
USE MASTER
GO
CREATE DATABASE SD18312_TEAM_6
GO
CREATE TABLE TaiKhoanNhanVien
(
    Ma_NhanVien VARCHAR(36) PRIMARY KEY DEFAULT NEWID(),
    SoDienThoai VARCHAR(20) UNIQUE,
    MatKhau VARCHAR(50)
)
GO
CREATE TABLE ThongTinNhanVien
(
    SoDienThoai VARCHAR(20) PRIMARY KEY,
    HoTen NVARCHAR(35),
    GioiTinh BIT,
    NgaySinh DATE,
    DiaChi NVARCHAR(255),
    Email VARCHAR(35)
)

SELECT * FROM ThongTinNhanVien
GO
CREATE TABLE ChucVuNhanVien
(
    SoDienThoai VARCHAR(20) PRIMARY KEY,
    VaiTro BIT,
    NgayTao DATE,
    NgaySua DATE,
    TrangThai BIT
)
CREATE TABLE MaXacNhanTaiKhoan
(
    Ma_MaXacNhan VARCHAR(36) PRIMARY KEY DEFAULT NEWID(),
    SoDienThoai VARCHAR(20),
    NgaySuDung DATE,
    TrangThai BIT
)
GO
DROP TABLE HANG
GO
CREATE TABLE Hang
(
    MaHang varchar(20) primary key,
    TenHang nvarchar(50),
    TrangThai bit,
    NgayTao Date,
    NgaySua Date,
    MoTa nvarchar(Max)
)
GO

DROP TABLE MauSac
GO
CREATE TABLE MauSac
(
    MaMauSac VARCHAR(20) PRIMARY key,
    TenMauSac NVARCHAR(50),
    TrangThai bit,
    NgayTao Date,
    NgaySua Date,
    MoTa NVARCHAR(Max)
)
GO

DROP TABLE NhaSanXuat
GO
CREATE TABLE NhaSanXuat
(
    MaNSX varchar(20) PRIMARY KEY,
    TenNSX NVARCHAR(50),
    QuocGia NVARCHAR(50),
    TrangThai bit,
    NgayTao date,
    NgaySua date,
    MoTa NVARCHAR(Max)
)
GO

CREATE TABLE ChatLieu
(
    MaChatLieu VARCHAR(20) PRIMARY KEY,
    Ten NVARCHAR(50),
    MoTa NVARCHAR(MAX),
    NgayTao DATE,
    NgaySua DATE,
    TrangThai BIT
)

CREATE TABLE Size
(
    MaSize VARCHAR(20) PRIMARY KEY,
    SoSize int,
    MoTa NVARCHAR(MAX)
)


CREATE TABLE ChiTietSanPham
(
    Ma_SanPhamChiTiet VARCHAR(20) PRIMARY KEY,
    MaSize VARCHAR(20),
    Ten NVARCHAR(50),
    MaSanXuat VARCHAR(20),
    MaMauSac VARCHAR(20),
    MaHang VARCHAR(20),
    AnhSanPham VARBINARY(MAX),
    MaChatLieu VARCHAR(20),
    GiaNhap FLOAT,
    GiaBan FLOAT,
    SoLuong INT,
    TrangThai BIT,
    NgayTao DATE,
    NgaySua DATE,
    MoTa NVARCHAR(MAX)
)
SELECT * FROM ChiTietSanPham

DROP TABLE ChiTietSanPham

CREATE TABLE KhachHang(
    Ma_KhachHang NVARCHAR(20) PRIMARY KEY,
    Ten NVARCHAR(50),
    NgaySinh Date,
    GioiTinh Bit,
    SDT VARCHAR(20),
    DiaChi NVARCHAR(MAX),
    TrangThai bit
)
INSERT INTO KhachHang (Ma_KhachHang, Ten, NgaySinh, GioiTinh, SDT, DiaChi, TrangThai)
VALUES 
('KH001', N'Nguyễn Văn A', '1990-05-15', 1, '0123456789', N'Hà Nội', 1),
('KH002', N'Phạm Thị B', '1985-09-20', 0, '0987654321', N'Hồ Chí Minh', 1),
('KH003', N'Trần Văn C', '1995-12-10', 1, '0369852147', N'Đà Nẵng', 1),
('KH004', N'Lê Thị D', '1992-04-25', 0, '0932147856', N'Hải Phòng', 1),
('KH005', N'Huỳnh Văn E', '1988-08-05', 1, '0852147963', N'Cần Thơ', 1),
('KH006', N'Mai Thị F', '1997-03-18', 0, '0765214938', N'Bình Dương', 1),
('KH007', N'Ngô Văn G', '1993-11-30', 1, '0658741239', N'Hưng Yên', 1),
('KH008', N'Đặng Thị H', '1986-07-12', 0, '0541236987', N'Hà Tĩnh', 1),
('KH009', N'Lý Văn I', '1998-06-22', 1, '0978523641', N'Hải Dương', 1),
('KH010', N'Trần Thị K', '1991-02-28', 0, '0321456987', N'Thái Bình', 1);
SELECT * FROM KhachHang





INSERT INTO Size
    (MaSize, SoSize, MoTa)
VALUES
    ('S001', 35, N'Kích thước 35'),
    ('S002', 36, N'Kích thước 36'),
    ('S003', 37, N'Kích thước 37'),
    ('S004', 38, N'Kích thước 38'),
    ('S005', 39, N'Kích thước 39'),
    ('S006', 40, N'Kích thước 40'),
    ('S007', 41, N'Kích thước 41'),
    ('S008', 42, N'Kích thước 42'),
    ('S009', 43, N'Kích thước 43'),
    ('S010', 44, N'Kích thước 44');
INSERT INTO ChatLieu
    (MaChatLieu, Ten, MoTa, NgayTao, NgaySua, TrangThai)
VALUES
    ('CL001', N'Vải', N'Chất liệu vải thông thường', '2024-03-15', '2024-03-15', 1),
    ('CL002', N'Da tổng hợp', N'Chất liệu da tổng hợp chất lượng cao', '2024-03-15', '2024-03-15', 1),
    ('CL003', N'Da bò', N'Chất liệu da bò thật tự nhiên', '2024-03-15', '2024-03-15', 1),
    ('CL004', N'Nỉ', N'Chất liệu nỉ mềm mại và thoải mái', '2024-03-15', '2024-03-15', 1),
    ('CL005', N'Nhựa', N'Chất liệu nhựa nhẹ và dẻo', '2024-03-15', '2024-03-15', 1),
    ('CL006', N'Gỗ', N'Chất liệu gỗ cứng cáp và bền bỉ', '2024-03-15', '2024-03-15', 1),
    ('CL007', N'Lụa', N'Chất liệu lụa mịn màng và sang trọng', '2024-03-15', '2024-03-15', 1),
    ('CL008', N'Cao su', N'Chất liệu cao su chống trượt tốt', '2024-03-15', '2024-03-15', 1),
    ('CL009', N'Polyester', N'Chất liệu polyester chống thấm nước', '2024-03-15', '2024-03-15', 1),
    ('CL010', N'Denim', N'Chất liệu denim bền đẹp và phong cách', '2024-03-15', '2024-03-15', 1);

INSERT INTO NhaSanXuat
    (MaNSX, TenNSX, QuocGia, TrangThai, NgayTao, NgaySua, MoTa)
VALUES
    ('NSX01', N'Nike', N'Mỹ', 1, '2024-03-15', '2024-03-15', N'Thương hiệu giày thể thao nổi tiếng thế giới'),
    ('NSX02', N'Adidas', N'Đức', 1, '2024-03-15', '2024-03-15', N'Thương hiệu giày thể thao nổi tiếng thế giới'),
    ('NSX03', N'Bitis', N'Việt Nam', 1, '2024-03-15', '2024-03-15', N'Thương hiệu giày dép nổi tiếng Việt Nam'),
    ('NSX04', N'Converse', N'Mỹ', 1, '2024-03-15', '2024-03-15', N'Thương hiệu giày thời trang nổi tiếng thế giới'),
    ('NSX05', N'Gucci', N'Ý', 1, '2024-03-15', '2024-03-15', N'Thương hiệu thời trang cao cấp thế giới'),
    ('NSX06', N'Louis Vuitton', N'Pháp', 1, '2024-03-15', '2024-03-15', N'Thương hiệu thời trang cao cấp thế giới'),
    ('NSX07', N'Pedro', N'Tây Ban Nha', 1, '2024-03-15', '2024-03-15', N'Thương hiệu giày dép thời trang cao cấp'),
    ('NSX08', N'Clarks', N'Anh', 1, '2024-03-15', '2024-03-15', N'Thương hiệu giày dép nổi tiếng với chất lượng cao'),
    ('NSX09', N'Ecco', N'Đan Mạch', 1, '2024-03-15', '2024-03-15', N'Thương hiệu giày dép nổi tiếng với thiết kế công thái học'),
    ('NSX10', N'Cole Haan', N'Mỹ', 1, '2024-03-15', '2024-03-15', N'Thương hiệu giày dép cao cấp dành cho nam và nữ')

INSERT INTO MauSac
    (MaMauSac, TenMauSac, TrangThai, NgayTao, NgaySua, MoTa)
VALUES
    ('MS01', N'Đen', 1, '2024-03-15', '2024-03-15', N'Màu đen basic, dễ phối đồ'),
    ('MS02', N'Trắng', 1, '2024-03-15', '2024-03-15', N'Màu trắng trẻ trung, năng động'),
    ('MS03', N'Nâu', 1, '2024-03-15', '2024-03-15', N'Màu nâu sang trọng, lịch lãm'),
    ('MS04', N'Xanh navy', 1, '2024-03-15', '2024-03-15', N'Màu xanh navy thanh lịch, cá tính'),
    ('MS05', N'Xanh rêu', 1, '2024-03-15', '2024-03-15', N'Màu xanh rêu độc đáo, thời trang'),
    ('MS06', N'Vàng', 1, '2024-03-15', '2024-03-15', N'Màu vàng nổi bật, thu hút'),
    ('MS07', N'Bạc', 1, '2024-03-15', '2024-03-15', N'Màu bạc sang trọng, đẳng cấp'),
    ('MS08', N'Đa sắc', 1, '2024-03-15', '2024-03-15', N'Kết hợp nhiều màu sắc')
GO

INSERT INTO Hang
    (MaHang, TenHang, TrangThai, NgayTao, NgaySua, MoTa)
VALUES
    ('GI01', N'Giày da nam cao cấp', 1, '2024-03-15', '2024-03-15', N'Giày da bò cao cấp, kiểu dáng sang trọng, lịch lãm'),
    ('GI02', N'Giày thể thao nam', 1, '2024-03-15', '2024-03-15', N'Giày thể thao năng động, thoải mái, phù hợp cho nhiều hoạt động'),
    ('GI03', N'Giày lười nam', 1, '2024-03-15', '2024-03-15', N'Giày lười tiện lợi, dễ dàng mang vào tháo ra'),
    ('GI04', N'Sandal nam', 0, '2024-03-15', '2024-03-15', N'Sandal thoáng mát, phù hợp cho mùa hè'),
    ('GI05', N'Bốt nam', 1, '2024-03-15', '2024-03-15', N'Bốt thời trang, cá tính, giữ ấm tốt'),
    ('GI06', N'Giày tây nam', 1, '2024-03-15', '2024-03-15', N'Giày tây lịch lãm, phù hợp cho công sở'),
    ('GI07', N'Giày mọi nam', 0, '2024-03-15', '2024-03-15', N'Giày mọi đơn giản, dễ phối đồ'),
    ('GI08', N'Giày dép nam', 1, '2024-03-15', '2024-03-15', N'Tổng hợp các loại giày dép nam đa dạng'),
    ('GI09', N'Giày nam giá rẻ', 0, '2024-03-15', '2024-03-15', N'Giày nam chất lượng tốt với giá cả phải chăng'),
    ('GI10', N'Giày nam cao cấp', 1, '2024-03-15', '2024-03-15', N'Giày nam thương hiệu cao cấp, đẳng cấp');
GO

CREATE TABLE KhuyenMai(
    MaKhuyenMai VARCHAR(20) PRIMARY KEY,
    TenKhuyenMai VARCHAR(50),
    GiaTri int,
    LoaiKhuyenMai bit,
    NgayBatDau date,
    NgayKetThuc date,
    TrangThai bit
)

INSERT INTO KhuyenMai (MaKhuyenMai, TenKhuyenMai, GiaTri, LoaiKhuyenMai, NgayBatDau, NgayKetThuc, TrangThai)
VALUES
    ('KM001', 'Xuat Sach Mieng', 100000, 1, '2023-01-01', '2023-01-31', 1),
    ('KM002', 'Giam Gia 10%', 0, 0, '2023-02-01', '2023-02-28', 1),
    ('KM003', 'Tang Luong 10%', 0, 0, '2023-03-01', '2023-03-31', 1),
    ('KM004', 'Qua Tang Mat Hang', 150000, 1, '2023-04-01', '2023-04-30', 1),
    ('KM005', 'Giam Gia 20%', 0, 0, '2023-05-01', '2023-05-31', 1),
    ('KM006', 'Tang Luong 20%', 0, 0, '2023-06-01', '2023-06-30', 1),
    ('KM007', 'Phan Tram 50%', 50000, 0, '2023-07-01', '2023-07-31', 1),
    ('KM008', 'Gia Tri Don Hang 100000', 50000, 1, '2023-08-01','2023-08-31', 1),
    ('KM009', 'Giam Gia 30%', 0, 0, '2023-09-01', '2023-09-30', 1),
    ('KM010', 'Tang Luong 30%', 0, 0, '2023-10-01', '2023-10-31', 1);


select * from MauSac where MaMauSac like 'MS02'

CREATE TABLE HoaDon(
    MaHoaDon VARCHAR(20) PRIMARY KEY,
    SDTNhanVien VARCHAR(20),
    SDTKhachHang VARCHAR(20),
    MaKhuyenMai VARCHAR(20),
    TongTien INT,
    NgayTao DATE,
    NgaySua DATE,
    TrangThai bit,
    GhiChu NVARCHAR(100)
)


CREATE TABLE HoaDonChiTiet(
    MaHoaDonChiTiet VARCHAR(20) PRIMARY KEY,
    MaHoaDon VARCHAR(20),
    MaSanPhamChiTiet VARCHAR(20),
    TenSanPham NVARCHAR(50),
    SoLuong INT,
    DonGia INT,
    TongTienCT INT
)

DROP TABLE HoaDonChiTiet
DROP TABLE HoaDon
SELECT * FROM HoaDon

INSERT INTO HoaDon ( MaHoaDon, SDTNhanVien, SDTKhachHang,MaKhuyenMai, TongTien, NgayTao, NgaySua, TrangThai, GhiChu)
VALUES ( 'HD001', '0944214116', '0944214116','KM001', 0, '2023-03-21', '2023-03-21', 1, 'Hóa đơn đầu tiên'),
       ( 'HD002', '0944214116', '0944214116','KM001', 0, '2023-03-22', '2023-03-22', 1, 'Hóa đơn thứ hai'),
       ( 'HD003', '0944214116', '0944214116','KM001', 0, '2023-03-23', '2023-03-23', 0, 'Hóa đơn bị hủy'),
       ( 'HD004', '0944214116', '0944214116','KM001', 0, '2023-03-24', '2023-03-24', 1, 'Hóa đơn thứ tư'),
       ( 'HD005', '0944214116', '0944214116','KM001', 0, '2023-03-25', '2023-03-25', 1, 'Hóa đơn thứ năm');







SELECT * FROM HoaDon 

SELECT * FROM HoaDonChiTiet


SELECT * FROM HoaDon INNER JOIN HoaDonChiTiet ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon WHERE HoaDonChiTiet.MaHoaDon = 'HD003'
















-- drop Table Hang
-- SELECT *
-- FROM Hang
-- INSERT INTO MaXacNhanTaiKhoan
--     (TrangThai)
-- VALUES(1)
SELECT *
FROM MaXacNhanTaiKhoan
-- UPDATE MaXacNhanTaiKhoan 
-- SET TrangThai = 0,
-- SET SoDienThoai
-- = '123456789',
-- SET NgaySuDung
-- = getDate
-- ();
-- WHERE Ma_MaXacNhan='D329F69E-3806-406D-B42F-94F1C78A137B'

-- UPDATE TaiKhoanNhanVien
-- SET MatKhau = '1234'
-- WHERE SoDienThoai = '123456789'

-- UPDATE MaXacNhanTaiKhoan 
-- SET TrangThai = 0,
--     SoDienThoai = '123456789',
--     NgaySuDung = GETDATE()
-- WHERE Ma_MaXacNhan = 'B06481B1-4752-483D-845B-991D0C6EE8EF'
-- UPDATE TaiKhoanNhanVien
-- SET MatKhau = '1234'
-- WHERE SoDienThoai = '123456789'




-- INSERT INTO TaiKhoanNhanVien
--     (SoDienThoai, MatKhau)
-- VALUES
--     ('123456789', '123456789')
-- INSERT INTO ChucVuNhanVien
--     (SoDienThoai, VaiTro,NgayTao,NgaySua,TrangThai)
-- VALUES
--     ('123456789', 1, GETDATE(), GETDATE(), 1)

-- INSERT INTO ThongTinNhanVien
--     (SoDienThoai,HoTen,GioiTinh,NgaySinh,DiaChi,Email)
-- VALUES
--     ('123456789', N'Nông Tiến Sơn', 1, GETDATE(), N'Hà Nội', 'nongtiensonpro@gmail.com')
-- INSERT INTO ChucVuNhanVien
--     (SoDienThoai, VaiTro,NgayTao,NgaySua,TrangThai)
-- VALUES
--     ('123456789', 1, GETDATE(), GETDATE(), 1)
SELECT Ma_NhanVien, SoDienThoai, MatKhau
FROM TaiKhoanNhanVien
SELECT *
FROM ChucVuNhanVien
SELECT *
FROM ThongTinNhanVien

-- SELECT *
-- FROM TaiKhoanNhanVien
--     INNER JOIN ChucVuNhanVien ON ChucVuNhanVien.SoDienThoai= TaiKhoanNhanVien.SoDienThoai
--     INNER JOIN ThongTinNhanVien ON ThongTinNhanVien.SoDienThoai = TaiKhoanNhanVien.SoDienThoai