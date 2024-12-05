SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
USE donghodb;

--
-- Database: `dongho`
--

-- --------------------------------------------------------

--
-- Table structure for table `binh_luan`
--

CREATE TABLE `binh_luan` (
                             `mabl` varchar(255) NOT NULL,
                             `noidung` varchar(255) DEFAULT NULL,
                             `ngaybinhluan` datetime(6) DEFAULT NULL,
                             `makh` varchar(255) DEFAULT NULL,
                             `masp` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `binh_luan`
--

INSERT INTO `binh_luan` (`mabl`, `noidung`, `ngaybinhluan`, `makh`, `masp`) VALUES
                                                                                ('BL3068872', 'kakakka', '2024-07-30 11:17:48.000000', 'KH7735424', 'SP01'),
                                                                                ('BL3132058', '100 diem', '2024-07-30 11:18:52.000000', 'KH7735424', 'SP01'),
                                                                                ('BL3177625', 'không có từ nào để diễn tả được', '2024-07-30 11:19:37.000000', 'KH7735424', 'SP01'),
                                                                                ('BL7567344', 'ahahhahhaha', '2024-07-29 22:39:27.000000', 'KH1493613', 'SP01'),
                                                                                ('BL7576719', '999999999', '2024-07-29 22:39:36.000000', 'KH1493613', 'SP01');

-- --------------------------------------------------------

--
-- Table structure for table `ct_don_nhap_hang`
--

CREATE TABLE `ct_don_nhap_hang` (
                                    `gia` float NOT NULL,
                                    `soluong` int(11) NOT NULL,
                                    `madnh` varchar(255) NOT NULL,
                                    `masp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ct_don_nhap_hang`
--

INSERT INTO `ct_don_nhap_hang` (`gia`, `soluong`, `madnh`, `masp`) VALUES
                                                                       (20, 30, 'DNH01', 'SP01'),
                                                                       (50, 50, 'DNH02', 'SP02'),
                                                                       (30, 30, 'DNH03', 'SP03'),
                                                                       (100, 90, 'DNH04', 'SP04');

-- --------------------------------------------------------

--
-- Table structure for table `ct_don_hang`
--

CREATE TABLE `ct_don_hang` (
                               `gia` float NOT NULL,
                               `soluong` int(11) NOT NULL,
                               `madh` varchar(255) NOT NULL,
                               `masp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ct_don_hang`
--

INSERT INTO `ct_don_hang` (`gia`, `soluong`, `madh`, `masp`) VALUES
                                                                 (30, 27, 'DH194688', 'SP03'),
                                                                 (50, 7, 'DH4739103', 'SP02'),
                                                                 (50, 9, 'DH4916938', 'SP02'),
                                                                 (30, 1, 'DH5225622', 'SP03'),
                                                                 (20, 4, 'DH6725800', 'SP01'),
                                                                 (30, 2, 'DH7889284', 'SP03'),
                                                                 (20, 1, 'DH7894580', 'SP01'),
                                                                 (100, 1, 'DH7894580', 'SP04'),
                                                                 (50, 27, 'DH8358176', 'SP02'),
                                                                 (100, 5, 'DH8364360', 'SP04'),
                                                                 (30, 3, 'DH8366530', 'SP03');

-- --------------------------------------------------------

--
-- Table structure for table `ct_phieu_nhap`
--

CREATE TABLE `ct_phieu_nhap` (
                                 `gia` float NOT NULL,
                                 `soluong` int(11) NOT NULL,
                                 `mapn` varchar(255) NOT NULL,
                                 `masp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ct_phieu_nhap`
--

INSERT INTO `ct_phieu_nhap` (`gia`, `soluong`, `mapn`, `masp`) VALUES
                                                                   (20, 30, 'PN4412303', 'SP01'),
                                                                   (50, 50, 'PN4440756', 'SP02'),
                                                                   (30, 30, 'PN4465537', 'SP03'),
                                                                   (100, 90, 'PN4577420', 'SP04');

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc`
--

CREATE TABLE `danh_muc` (
                            `madm` varchar(255) NOT NULL,
                            `slug` varchar(255) DEFAULT NULL,
                            `tendm` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `danh_muc`
--

INSERT INTO `danh_muc` (`madm`, `tendm`) VALUES
                                             ('donghorolex', 'đồng hồ Địa Hình'),
                                             ('donghoabc', 'đồng hồ đua'),
                                             ('donghocucre', 'đồng hồ thể thao'),
                                             ('donghoxin', 'đồng hồ trẻ em'),
                                             ('donghosanhdieu', 'đồng hồ sành điệu');

-- --------------------------------------------------------

--
-- Table structure for table `don_dat_hang`
--

CREATE TABLE `don_nhap_hang` (
                                 `madnh` varchar(255) NOT NULL,
                                 `ngaydat` date NOT NULL,
                                 `mancc` varchar(255) NOT NULL,
                                 `manv` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `don_nhap_hang`
--

INSERT INTO `don_nhap_hang` (`madnh`, `ngaydat`, `mancc`, `manv`) VALUES
                                                                      ('DNH01', '2024-07-28', 'NCC01', 'NV01'),
                                                                      ('DNH02', '2024-07-28', 'NCC04', 'NV01'),
                                                                      ('DNH03', '2024-07-28', 'NCC02', 'NV01'),
                                                                      ('DNH04', '2024-07-28', 'NCC03', 'NV01');

-- --------------------------------------------------------

--
-- Table structure for table `don_hang`
--

CREATE TABLE `don_hang` (
                            `madh` varchar(255) NOT NULL,
                            `dia_chi` varchar(255) DEFAULT NULL,
                            `email` varchar(255) DEFAULT NULL,
                            `ghichu` varchar(255) DEFAULT NULL,
                            `hinh_thuc_thanh_toan` int(11) NOT NULL,
                            `ho_ten` varchar(255) DEFAULT NULL,
                            `ngay_dat` date DEFAULT NULL,
                            `sdt` varchar(255) DEFAULT NULL,
                            `tong_tien` float NOT NULL,
                            `trang_thai` int(11) NOT NULL,
                            `manvgh` varchar(255) DEFAULT NULL,
                            `makh` varchar(255) DEFAULT NULL,
                            `manv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `don_hang`
--

INSERT INTO `don_hang` (`madh`, `dia_chi`, `email`, `ghichu`, `hinh_thuc_thanh_toan`, `ho_ten`, `ngay_dat`, `sdt`, `tong_tien`, `trang_thai`, `manvgh`, `makh`, `manv`) VALUES
                                                                                                                                                                            ('DH194688', 'Hoai hai', 'manhbinh55@gmail.com', 'abc', 1, 'Nguyen MAnh Binh', '2024-04-30', '09127312421', 810, 3, 'NV2840023', 'KH7735424', 'NV01'),
                                                                                                                                                                            ('DH4739103', 'Vinhome quận 9', 'manhbinh77@gmail.com', 'abc', 1, 'Mạnh Bình User', '2024-01-29', '098172312421', 350, 3, 'NV2883879', 'KH7014680', 'NV01'),
                                                                                                                                                                            ('DH4916938', 'Vinhome quận 9', 'manhbinh77@gmail.com', 'abc', 1, 'Mạnh Bình User', '2024-06-29', '098172312421', 450, 3, 'NV2840023', 'KH7014680', 'NV01'),
                                                                                                                                                                            ('DH5225622', 'GDSDFS', 'manhbinh66@gmail.com', 'abc', 1, 'Nguyen manh binh', '2024-08-12', '0912832143', 30, 0, NULL, 'KH7599500', NULL),
                                                                                                                                                                            ('DH6725800', 'Hoai hai', 'manhbinh55@gmail.com', 'abc', 1, 'Nguyen MAnh Binh', '2024-08-12', '09127312421', 80, 3, 'NV2840023', 'KH7735424', 'NV01'),
                                                                                                                                                                            ('DH7889284', 'Vinhome quận 9', 'manhbinh77@gmail.com', 'abc', 2, 'Mạnh Bình User', '2024-04-28', '098172312421', 60, 4, NULL, 'KH7014680', NULL),
                                                                                                                                                                            ('DH7894580', 'Vinhome quận 9', 'manhbinh77@gmail.com', 'abc', 1, 'Mạnh Bình User', '2024-05-28', '098172312421', 120, 3, 'NV2840023', 'KH7014680', 'NV01'),
                                                                                                                                                                            ('DH8358176', 'Hoai hai', 'manhbinh55@gmail.com', 'abc', 1, 'Nguyen MAnh Binh', '2024-07-30', '09127312421', 1350, 3, 'NV7968419', 'KH7735424', 'NV01'),
                                                                                                                                                                            ('DH8364360', 'Hoai hai', 'manhbinh55@gmail.com', 'abc', 1, 'Nguyen MAnh Binh', '2024-03-12', '09127312421', 500, 3, 'NV2883879', 'KH7735424', 'NV01'),
                                                                                                                                                                            ('DH8366530', 'Hoai hai', 'manhbinh55@gmail.com', 'abc', 1, 'Nguyen MAnh Binh', '2024-02-15', '09127312421', 90, 3, 'NV2840023', 'KH7735424', 'NV01');

-- --------------------------------------------------------

--
-- Table structure for table `gio_hang`
--

CREATE TABLE `gio_hang` (
                            `soluong` int(11) NOT NULL,
                            `makh` varchar(255) NOT NULL,
                            `masp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gio_hang`
--

INSERT INTO `gio_hang` (`soluong`, `makh`, `masp`) VALUES
    (1, 'KH7735424', 'SP03');

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don`
--

CREATE TABLE `hoa_don` (
                           `mahd` varchar(255) NOT NULL,
                           `ngaylap` date DEFAULT NULL,
                           `thanhtien` float NOT NULL,
                           `madh` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoa_don`
--

INSERT INTO `hoa_don` (`mahd`, `ngaylap`, `thanhtien`, `madh`) VALUES
                                                                   ('HD194753', '2024-07-30', 810, 'DH194688'),
                                                                   ('HD4739112', '2024-07-29', 350, 'DH4739103'),
                                                                   ('HD4916943', '2024-07-29', 450, 'DH4916938'),
                                                                   ('HD5225634', '2024-08-12', 30, 'DH5225622'),
                                                                   ('HD6725816', '2024-08-12', 80, 'DH6725800'),
                                                                   ('HD7889347', '2024-07-28', 60, 'DH7889284'),
                                                                   ('HD7894586', '2024-07-28', 120, 'DH7894580'),
                                                                   ('HD8358204', '2024-07-30', 1350, 'DH8358176'),
                                                                   ('HD8364367', '2024-07-30', 500, 'DH8364360'),
                                                                   ('HD8366537', '2024-07-30', 90, 'DH8366530');

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
                              `makh` varchar(255) NOT NULL,
                              `dia_chi` varchar(255) DEFAULT NULL,
                              `email` varchar(255) DEFAULT NULL,
                              `gioitinh` varchar(255) DEFAULT NULL,
                              `hoten` varchar(255) DEFAULT NULL,
                              `sdt` varchar(255) DEFAULT NULL,
                              `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`makh`, `dia_chi`, `email`, `gioitinh`, `hoten`, `sdt`, `username`) VALUES
                                                                                                  ('KH1493613', 'Manh binh', 'manhbinh3012@gmail.com', 'Nam', 'manhbinh 40231', '123123123', 'manhbinh3012'),
                                                                                                  ('KH7014680', 'Vinhome quận 9', 'manhbinh77@gmail.com', 'Nam', 'Mạnh Bình User', '123456', 'manhbinh77'),
                                                                                                  ('KH7599500', 'GDSDFS', 'manhbinh66@gmail.com', 'Nam', 'Nguyen manh binh', '0912832143', 'manhbinh66'),
                                                                                                  ('KH7735424', 'Hoai hai', 'manhbinh55@gmail.com', 'Nam', 'Nguyen MAnh Binh', '09127312421', 'manhbinh55');

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE `nhan_vien` (
                             `manv` varchar(255) NOT NULL,
                             `diachi` varchar(255) DEFAULT NULL,
                             `email` varchar(255) DEFAULT NULL,
                             `gioitinh` varchar(255) DEFAULT NULL,
                             `hoten` varchar(255) DEFAULT NULL,
                             `luong` float NOT NULL,
                             `sdt` varchar(255) DEFAULT NULL,
                             `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhan_vien`
--

INSERT INTO `nhan_vien` (`manv`, `diachi`, `email`, `gioitinh`, `hoten`, `luong`, `sdt`, `username`) VALUES
                                                                                                         ('NV01', 'Vinhome quận 9', 'manhbinh99@gmail.com', 'Nam', 'Nguyễn Mạnh Bình', 999999, '0981376700', 'manhbinh99'),
                                                                                                         ('NV2840023', 'Vinhome quận 9', 'vandung99@gmail.com', 'Nam', 'Lê Văn Dũng', 20000, '09182421432', 'vandung99'),
                                                                                                         ('NV2883879', 'Vinhome quận 9', 'vantan98@gmail.com', 'Nữ', 'Võ Văn Tân', 30000, '0912382421', 'vantan98'),
                                                                                                         ('NV2966381', 'Quận 9', 'ngochuy199x@gmail.com', 'Nam', 'Lê Ngọc Huy', 300000, '0981376700', 'lenguochuy'),
                                                                                                         ('NV7968419', 'kakak', 'vandung11@gmail.com', 'Nam', 'Van dung', 40000, '09128321421', 'vandung11');

-- --------------------------------------------------------

--
-- Table structure for table `nha_cung_cap`
--

CREATE TABLE `nha_cung_cap` (
                                `mancc` varchar(255) NOT NULL,
                                `diachi` varchar(255) DEFAULT NULL,
                                `email` varchar(255) DEFAULT NULL,
                                `sdt` varchar(255) DEFAULT NULL,
                                `tenncc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nha_cung_cap`
--

INSERT INTO `nha_cung_cap` (`mancc`, `diachi`, `email`, `sdt`, `tenncc`) VALUES
                                                                             ('NCC01', 'Số 10B Tràng Thi, Q. Hoàn Kiếm, TP Hà Nội (TPHN)', 'thongnhat@gmail.com', '09182324242', 'Thống Nhất'),
                                                                             ('NCC02', '263 Trịnh Đình Trọng, P. Hòa Thạnh, Q. Tân Phú, Tp. Hồ Chí Minh (TPHCM)', 'phuhuy@gmail.com', '091232421532', 'Phú Hy'),
                                                                             ('NCC03', 'Số 530 Nguyễn Khoái, Q. Hoàng Mai, TP Hà Nội (TPHN)', 'vietmy@gmail.com', '0912842132', 'Việt Mỹ'),
                                                                             ('NCC04', ' Km 5 Đ. 9D KCN Nam, TP. Đông Hà, Tỉnh Quảng Trị', 'hongchinh@gmail.com', '09128421325', 'Hồng Chinh');

-- --------------------------------------------------------

--
-- Table structure for table `phieu_nhap`
--

CREATE TABLE `phieu_nhap` (
                              `mapn` varchar(255) NOT NULL,
                              `ngaydat` date DEFAULT NULL,
                              `madnh` varchar(255) DEFAULT NULL,
                              `manv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieu_nhap`
--

INSERT INTO `phieu_nhap` (`mapn`, `ngaydat`, `madnh`, `manv`) VALUES
                                                                  ('PN4412303', '2024-07-28', 'DNH01', 'NV01'),
                                                                  ('PN4440756', '2024-07-28', 'DNH02', 'NV01'),
                                                                  ('PN4465537', '2024-07-28', 'DNH03', 'NV01'),
                                                                  ('PN4577420', '2024-07-28', 'DNH04', 'NV01');

-- --------------------------------------------------------

--
-- Table structure for table `quyen`
--

CREATE TABLE `quyen` (
                         `maquyen` int(11) NOT NULL,
                         `tenquyen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quyen`
--

INSERT INTO `quyen` (`maquyen`, `tenquyen`) VALUES
                                                (1, 'Quản lý'),
                                                (2, 'Khách hàng'),
                                                (3, 'Nhân viên');

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE `san_pham` (
                            `masp` varchar(255) NOT NULL,
                            `chitietsp` varchar(255) DEFAULT NULL,
                            `dongia` float NOT NULL,
                            `image` varchar(255) DEFAULT NULL,
                            `image2` varchar(255) DEFAULT NULL,
                            `image3` varchar(255) DEFAULT NULL,
                            `slug` varchar(255) DEFAULT NULL,
                            `soluong` int(11) NOT NULL,
                            `tensp` varchar(255) DEFAULT NULL,
                            `trangthai` int(11) NOT NULL,
                            `madm` varchar(255) DEFAULT NULL,
                            `mancc` varchar(255) DEFAULT NULL,
                            `math` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`masp`, `chitietsp`, `dongia`, `image`, `image2`, `image3`, `slug`, `soluong`, `tensp`, `trangthai`, `madm`, `mancc`, `math`) VALUES
                                                                                                                                                          ('SP01', 'Là chiếc đồng hồ có 1 0 2', 20, 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174084/project/dongho/hv9q9qdq8snbrmlfmfzc.jpg', 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174084/project/dongho/rtf32r9voc6cat7ppa9y.jpg', 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174086/project/dongho/jw0rbdxmc9vip2qzy1kx.jpg', 'dong-ho-sky', 25, 'đồng hồ Sky', 0, 'donghorolex', 'NCC01', 'TH01'),
                                                                                                                                                          ('SP02', 'Là chiếc đồng hồ xịn nhất thế kỷ', 50, 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174178/project/dongho/za8yv7xqyxn5swkep8lx.jpg', 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174181/project/dongho/b32bfpog2wvhhit7tipo.jpg', 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174184/project/dongho/wru46jyxpgbejianwuaz.jpg', 'dong-ho-merida-01', 7, 'đồng hồ Merida 01', 0, 'donghoabc', 'NCC04', 'TH02'),
                                                                                                                                                          ('SP03', 'Là chiếc đồng hồ trẻ em nhỏ gọn', 30, 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174271/project/dongho/bflvpupndrpxmffm5iyo.jpg', 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174271/project/dongho/cihtksncrsankxsjvu1j.jpg', 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174272/project/dongho/idjrnjmcrkclyziwgllx.jpg', 'dong-ho-tre-em-phu-hy', 0, 'đồng hồ trẻ em Phú Hy', 0, 'donghoxin', 'NCC02', 'TH04'),
                                                                                                                                                          ('SP04', 'Là chiếc đồng hồ có thiết kế nhỏ gọn', 100, 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174338/project/dongho/nyvsibhzlqk8o358c6uv.jpg', 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174340/project/dongho/ktgai06tesilwge8wube.jpg', 'http://res.cloudinary.com/dnk2nocdt/image/upload/v1722174342/project/dongho/cbv7yrzxwatnxfsifcwt.jpg', 'dong-ho-vip', 84, 'đồng hồ vip', 0, 'donghocucre', 'NCC03', 'TH03');

-- --------------------------------------------------------

--
-- Table structure for table `tai_khoan`
--

CREATE TABLE `tai_khoan` (
                             `username` varchar(255) NOT NULL,
                             `password` varchar(255) DEFAULT NULL,
                             `maquyen` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tai_khoan`
--

INSERT INTO `tai_khoan` (`username`, `password`, `maquyen`) VALUES
                                                                ('lenguochuy', '123456', 3),
                                                                ('manhbinh3012', '1973122', 2),
                                                                ('manhbinh55', '123456', 2),
                                                                ('manhbinh66', '123456', 2),
                                                                ('manhbinh77', '8439285', 2),
                                                                ('manhbinh99', '123456', 1),
                                                                ('vandung11', '123456', 3),
                                                                ('vandung99', '123456', 3),
                                                                ('vantan98', '123456', 3);

-- --------------------------------------------------------

--
-- Table structure for table `thuong_hieu`
--

CREATE TABLE `thuong_hieu` (
                               `math` varchar(255) NOT NULL,
                               `tenth` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thuong_hieu`
--

INSERT INTO `thuong_hieu` (`math`, `tenth`) VALUES
                                                ('TH01', 'Giant'),
                                                ('TH02', 'Merida'),
                                                ('TH03', 'vip'),
                                                ('TH04', 'Max'),
                                                ('TH05', 'Trinx');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `binh_luan`
--
ALTER TABLE `binh_luan`
    ADD PRIMARY KEY (`mabl`),
    ADD KEY `FKdsatcrgnenmq5hsy8omike8q5` (`makh`),
    ADD KEY `FKi4fuvgjjlcrs8iqh9jiuyb9ej` (`masp`);

--
-- Indexes for table `ct_don_nhap_hang`
--
ALTER TABLE `ct_don_nhap_hang`
    ADD PRIMARY KEY (`madnh`,`masp`),
    ADD KEY `FKs8u9gqe68wt6gmyswqw3mn1l4` (`masp`);

--
-- Indexes for table `ct_don_hang`
--
ALTER TABLE `ct_don_hang`
    ADD PRIMARY KEY (`madh`,`masp`),
    ADD KEY `FKlrdl2i3ncireycln98wfd74cl` (`masp`);

--
-- Indexes for table `ct_phieu_nhap`
--
ALTER TABLE `ct_phieu_nhap`
    ADD PRIMARY KEY (`mapn`,`masp`),
    ADD KEY `FKa4ygch8ys6udl0cq7hq03smto` (`masp`);

--
-- Indexes for table `danh_muc`
--
ALTER TABLE `danh_muc`
    ADD PRIMARY KEY (`madm`);

--
-- Indexes for table `don_dat_hang`
--
ALTER TABLE `don_nhap_hang`
    ADD PRIMARY KEY (`madnh`),
    ADD KEY `FKkclcfa7mtuowxsxtha1pyvjvy` (`mancc`),
    ADD KEY `FK5q5tulnnarplj4ikdthff95gb` (`manv`);

--
-- Indexes for table `don_hang`
--
ALTER TABLE `don_hang`
    ADD PRIMARY KEY (`madh`),
    ADD KEY `FK755pr5o67neot0n78vgulf16` (`manvgh`),
    ADD KEY `FKiy9wbkgc3iv3ome6new025n9o` (`makh`),
    ADD KEY `FK4dynfeotsf46btjbesngp0103` (`manv`);

--
-- Indexes for table `gio_hang`
--
ALTER TABLE `gio_hang`
    ADD PRIMARY KEY (`makh`,`masp`),
    ADD KEY `FKahs2bb598hqvw7ap3d305mjo8` (`masp`);

--
-- Indexes for table `hoa_don`
--
ALTER TABLE `hoa_don`
    ADD PRIMARY KEY (`mahd`),
    ADD UNIQUE KEY `UKi5dsqpkn4sb6xnm62vxche09x` (`madh`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
    ADD PRIMARY KEY (`makh`),
    ADD KEY `FKduy4oo400fp1thgvh0wenyd24` (`username`);

--
-- Indexes for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
    ADD PRIMARY KEY (`manv`),
    ADD KEY `FK59bq68mmagavio0yjq26pmxpt` (`username`);

--
-- Indexes for table `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
    ADD PRIMARY KEY (`mancc`);

--
-- Indexes for table `phieu_nhap`
--
ALTER TABLE `phieu_nhap`
    ADD PRIMARY KEY (`mapn`),
    ADD UNIQUE KEY `UKngyim070i8y9xtwgy9x8vf3cj` (`madnh`),
    ADD KEY `FKlavt7ihi8dug436gh1vq69w1y` (`manv`);

--
-- Indexes for table `quyen`
--
ALTER TABLE `quyen`
    ADD PRIMARY KEY (`maquyen`);

--
-- Indexes for table `san_pham`
--
ALTER TABLE `san_pham`
    ADD PRIMARY KEY (`masp`),
    ADD KEY `FK5wavgec206es4cr9yeibf0jnx` (`madm`),
    ADD KEY `FKhp2k7qqhwp3hb66f900uc5gg1` (`mancc`),
    ADD KEY `FKbq58nfi8aasvcc7ca6mmw2361` (`math`);

--
-- Indexes for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
    ADD PRIMARY KEY (`username`),
    ADD KEY `FKl6mh1f9t1mnx0d8fl4g6rhd0f` (`maquyen`);

--
-- Indexes for table `thuong_hieu`
--
ALTER TABLE `thuong_hieu`
    ADD PRIMARY KEY (`math`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `binh_luan`
--
ALTER TABLE `binh_luan`
    ADD CONSTRAINT `FKdsatcrgnenmq5hsy8omike8q5` FOREIGN KEY (`makh`) REFERENCES `khach_hang` (`makh`),
    ADD CONSTRAINT `FKi4fuvgjjlcrs8iqh9jiuyb9ej` FOREIGN KEY (`masp`) REFERENCES `san_pham` (`masp`);

--
-- Constraints for table `ct_don_nhap_hang`
--
ALTER TABLE `ct_don_nhap_hang`
    ADD CONSTRAINT `FKhtfigy1fyu6c9medqa2cp40uf` FOREIGN KEY (`madnh`) REFERENCES `don_nhap_hang` (`madnh`),
    ADD CONSTRAINT `FKs8u9gqe68wt6gmyswqw3mn1l4` FOREIGN KEY (`masp`) REFERENCES `san_pham` (`masp`);

--
-- Constraints for table `ct_don_hang`
--
ALTER TABLE `ct_don_hang`
    ADD CONSTRAINT `FKlrdl2i3ncireycln98wfd74cl` FOREIGN KEY (`masp`) REFERENCES `san_pham` (`masp`),
    ADD CONSTRAINT `FKndg6v5rgpoe9ktov4f6dlchys` FOREIGN KEY (`madh`) REFERENCES `don_hang` (`madh`);

--
-- Constraints for table `ct_phieu_nhap`
--
ALTER TABLE `ct_phieu_nhap`
    ADD CONSTRAINT `FK9ta23xr1cmlku55hxehp396iy` FOREIGN KEY (`mapn`) REFERENCES `phieu_nhap` (`mapn`),
    ADD CONSTRAINT `FKa4ygch8ys6udl0cq7hq03smto` FOREIGN KEY (`masp`) REFERENCES `san_pham` (`masp`);

--
-- Constraints for table `don_dat_hang`
--
ALTER TABLE `don_nhap_hang`
    ADD CONSTRAINT `FK5q5tulnnarplj4ikdthff95gb` FOREIGN KEY (`manv`) REFERENCES `nhan_vien` (`manv`),
    ADD CONSTRAINT `FKkclcfa7mtuowxsxtha1pyvjvy` FOREIGN KEY (`mancc`) REFERENCES `nha_cung_cap` (`mancc`);

--
-- Constraints for table `don_hang`
--
ALTER TABLE `don_hang`
    ADD CONSTRAINT `FK4dynfeotsf46btjbesngp0103` FOREIGN KEY (`manv`) REFERENCES `nhan_vien` (`manv`),
    ADD CONSTRAINT `FK755pr5o67neot0n78vgulf16` FOREIGN KEY (`manvgh`) REFERENCES `nhan_vien` (`manv`),
    ADD CONSTRAINT `FKiy9wbkgc3iv3ome6new025n9o` FOREIGN KEY (`makh`) REFERENCES `khach_hang` (`makh`);

--
-- Constraints for table `gio_hang`
--
ALTER TABLE `gio_hang`
    ADD CONSTRAINT `FKahs2bb598hqvw7ap3d305mjo8` FOREIGN KEY (`masp`) REFERENCES `san_pham` (`masp`),
    ADD CONSTRAINT `FKr918hcrsa82ly9duc4jsec5n8` FOREIGN KEY (`makh`) REFERENCES `khach_hang` (`makh`);

--
-- Constraints for table `hoa_don`
--
ALTER TABLE `hoa_don`
    ADD CONSTRAINT `FK83d5kek5uoh8e1kralry52seo` FOREIGN KEY (`madh`) REFERENCES `don_hang` (`madh`);

--
-- Constraints for table `khach_hang`
--
ALTER TABLE `khach_hang`
    ADD CONSTRAINT `FKduy4oo400fp1thgvh0wenyd24` FOREIGN KEY (`username`) REFERENCES `tai_khoan` (`username`);

--
-- Constraints for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
    ADD CONSTRAINT `FK59bq68mmagavio0yjq26pmxpt` FOREIGN KEY (`username`) REFERENCES `tai_khoan` (`username`);

--
-- Constraints for table `phieu_nhap`
--
ALTER TABLE `phieu_nhap`
    ADD CONSTRAINT `FKhjk6joitu706cv4b7u1ivdbk4` FOREIGN KEY (`madnh`) REFERENCES `don_nhap_hang` (`madnh`),
    ADD CONSTRAINT `FKlavt7ihi8dug436gh1vq69w1y` FOREIGN KEY (`manv`) REFERENCES `nhan_vien` (`manv`);

--
-- Constraints for table `san_pham`
--
ALTER TABLE `san_pham`
    ADD CONSTRAINT `FK5wavgec206es4cr9yeibf0jnx` FOREIGN KEY (`madm`) REFERENCES `danh_muc` (`madm`),
    ADD CONSTRAINT `FKbq58nfi8aasvcc7ca6mmw2361` FOREIGN KEY (`math`) REFERENCES `thuong_hieu` (`math`),
    ADD CONSTRAINT `FKhp2k7qqhwp3hb66f900uc5gg1` FOREIGN KEY (`mancc`) REFERENCES `nha_cung_cap` (`mancc`);

--
-- Constraints for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
    ADD CONSTRAINT `FKl6mh1f9t1mnx0d8fl4g6rhd0f` FOREIGN KEY (`maquyen`) REFERENCES `quyen` (`maquyen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
