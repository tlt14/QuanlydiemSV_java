-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 31, 2021 lúc 02:04 PM
-- Phiên bản máy phục vụ: 10.4.20-MariaDB
-- Phiên bản PHP: 8.0.9
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbldangnhap`
--

CREATE TABLE `tbldangnhap` (
  `TenDangNhap` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `MatKhau` text COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `HoTen` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `Email` text COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Đang đổ dữ liệu cho bảng `tbldangnhap`
--

INSERT INTO `tbldangnhap` (`TenDangNhap`, `MatKhau`, `HoTen`, `Email`) VALUES
('admin', 'admin', 'Lam Truong', 'abc@gmail.com'),
('lamtruong', 'lamtruong', 'Thái Lam Trường', 'thailamtruong05@gmail.com\r\n');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbldiem`
--

CREATE TABLE `tbldiem` (
  `MaSV` int(5) NOT NULL,
  `MaMH` int(5) NOT NULL,
  `LanThi` int(1) NOT NULL,
  `HeSo` int(1) NOT NULL,
  `Diem` int(10) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Đang đổ dữ liệu cho bảng `tbldiem`
--

INSERT INTO `tbldiem` (`MaSV`, `MaMH`, `LanThi`, `HeSo`, `Diem`, `TrangThai`) VALUES
(2, 1, 1, 1, 5, 1),
(3, 3, 1, 2, 10, 1),
(7, 1, 2, 2, 1, 0),
(7, 3, 3, 3, 10, 1),
(13, 3, 3, 3, 5, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblgiangvien`
--

CREATE TABLE `tblgiangvien` (
  `MaGV` int(10) NOT NULL,
  `TenGV` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `MaMH` int(5) NOT NULL,
  `NgaySinh` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `GioiTinh` tinyint(1) NOT NULL,
  `Email` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `DiaChi` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `SDT` varchar(10) COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Đang đổ dữ liệu cho bảng `tblgiangvien`
--

INSERT INTO `tblgiangvien` (`MaGV`, `TenGV`, `MaMH`, `NgaySinh`, `GioiTinh`, `Email`, `DiaChi`, `SDT`) VALUES
(1, 'Loan', 1, '1/1/1994', 0, 'abc@gmail.com', '123', '0123456789'),
(3, 'Sang', 3, '14/05/2001', 1, 'sang@gmail.com', '121345', '123114');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblkhoa`
--

CREATE TABLE `tblkhoa` (
  `MaKhoa` varchar(5) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `TenKhoa` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `SDT` varchar(10) COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Đang đổ dữ liệu cho bảng `tblkhoa`
--

INSERT INTO `tblkhoa` (`MaKhoa`, `TenKhoa`, `SDT`) VALUES
('CNTT', 'Công nghệ thông tin', '0923456789'),
('KT', 'Kinh tế', '0314658987'),
('NT', 'Nghệ Thuật', '1234686');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbllop`
--

CREATE TABLE `tbllop` (
  `MaLop` varchar(10) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `TenLop` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `MaKhoa` varchar(5) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `KhoaHoc` varchar(11) COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Đang đổ dữ liệu cho bảng `tbllop`
--

INSERT INTO `tbllop` (`MaLop`, `TenLop`, `MaKhoa`, `KhoaHoc`) VALUES
('DCT1191', 'Công nghệ thông tin lớp 1', 'CNTT', '2019-2023'),
('DCT1193', 'CNTT khóa 19-Lớp 4', 'CNTT', '2019-2023'),
('NT1193', 'Nghệ thuật lớp 3', 'NT', '2019-2023');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblmonhoc`
--

CREATE TABLE `tblmonhoc` (
  `MaMH` int(5) NOT NULL,
  `TenMH` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `STC` int(5) NOT NULL,
  `HinhThucThi` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `HocKy` int(5) NOT NULL,
  `PhongHoc` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Đang đổ dữ liệu cho bảng `tblmonhoc`
--

INSERT INTO `tblmonhoc` (`MaMH`, `TenMH`, `STC`, `HinhThucThi`, `HocKy`, `PhongHoc`) VALUES
(1, 'JavaBasic1', 4, 'Tự Luận', 2, 'C101'),
(2, 'C', 0, 'Tự Luận', 1, 'C101'),
(3, 'C++', 5, 'Tự Luận', 1, 'A101'),
(13, 'Cấu trúc dữ liệu', 1, 'Trắc Nghiệm', 1, 'A222');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblsinhvien`
--

CREATE TABLE `tblsinhvien` (
  `MaSV` int(5) NOT NULL,
  `HoTen` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `MaLop` varchar(15) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `HeDaoTao` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `NgaySinh` varchar(10) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `DiaChi` varchar(150) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `GioiTinh` tinyint(1) NOT NULL,
  `SDT` varchar(10) COLLATE utf8mb4_unicode_520_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Đang đổ dữ liệu cho bảng `tblsinhvien`
--

INSERT INTO `tblsinhvien` (`MaSV`, `HoTen`, `MaLop`, `HeDaoTao`, `NgaySinh`, `DiaChi`, `GioiTinh`, `SDT`) VALUES
(2, 'Thái Lam trường', 'DCT1193', 'Chính Quy', '14/05/2001', '112', 1, '0905040861'),
(3, 'Thái Lam trường', 'DCT1193', 'Chính Quy', '14/05/2001', '112', 0, '0905040861'),
(4, 'Thái Lam trường', 'DCT1193', 'Chính Quy', '14/05/2001', '112', 1, '090504086'),
(7, 'Sinh viên 1', 'NT1193', 'Cao Đẳng', '1/4/1', '131321', 0, '0347856241'),
(13, 'Sinh Viên 13', 'DCT1193', 'Chính quy', '14/05/2001', '123', 1, '0905040861'),
(43, 'Sinh viên 15', 'DCT1193', 'Chính quy', '14/05/2001', 'd', 1, '0905040861');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbldiem`
--
ALTER TABLE `tbldiem`
  ADD PRIMARY KEY (`MaSV`,`MaMH`,`LanThi`),
  ADD KEY `frk_mamh1` (`MaMH`);

--
-- Chỉ mục cho bảng `tblgiangvien`
--
ALTER TABLE `tblgiangvien`
  ADD PRIMARY KEY (`MaGV`),
  ADD KEY `frk_mamh` (`MaMH`);

--
-- Chỉ mục cho bảng `tblkhoa`
--
ALTER TABLE `tblkhoa`
  ADD PRIMARY KEY (`MaKhoa`);

--
-- Chỉ mục cho bảng `tbllop`
--
ALTER TABLE `tbllop`
  ADD PRIMARY KEY (`MaLop`),
  ADD KEY `frk_makhoa` (`MaKhoa`);

--
-- Chỉ mục cho bảng `tblmonhoc`
--
ALTER TABLE `tblmonhoc`
  ADD PRIMARY KEY (`MaMH`),
  ADD KEY `MaMH` (`MaMH`);

--
-- Chỉ mục cho bảng `tblsinhvien`
--
ALTER TABLE `tblsinhvien`
  ADD PRIMARY KEY (`MaSV`),
  ADD KEY `frk_malop` (`MaLop`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tblgiangvien`
--
ALTER TABLE `tblgiangvien`
  MODIFY `MaGV` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `tblmonhoc`
--
ALTER TABLE `tblmonhoc`
  MODIFY `MaMH` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `tblsinhvien`
--
ALTER TABLE `tblsinhvien`
  MODIFY `MaSV` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tbldiem`
--
ALTER TABLE `tbldiem`
  ADD CONSTRAINT `frk_mamh1` FOREIGN KEY (`MaMH`) REFERENCES `tblmonhoc` (`MaMH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `frk_masv` FOREIGN KEY (`MaSV`) REFERENCES `tblsinhvien` (`MaSV`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `tblgiangvien`
--
ALTER TABLE `tblgiangvien`
  ADD CONSTRAINT `frk_mamh` FOREIGN KEY (`MaMH`) REFERENCES `tblmonhoc` (`MaMH`);

--
-- Các ràng buộc cho bảng `tbllop`
--
ALTER TABLE `tbllop`
  ADD CONSTRAINT `frk_makhoa` FOREIGN KEY (`MaKhoa`) REFERENCES `tblkhoa` (`MaKhoa`);

--
-- Các ràng buộc cho bảng `tblsinhvien`
--
ALTER TABLE `tblsinhvien`
  ADD CONSTRAINT `frk_malop` FOREIGN KEY (`MaLop`) REFERENCES `tbllop` (`MaLop`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
