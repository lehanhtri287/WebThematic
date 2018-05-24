-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shophandmade
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietdonhang` (
  `ID_DONHANG` int(11) DEFAULT NULL,
  `ID_SANPHAM` int(11) DEFAULT NULL,
  `SO_LUONG` int(11) DEFAULT NULL,
  KEY `FK_CTDH` (`ID_DONHANG`),
  KEY `FK_CTDH1` (`ID_SANPHAM`),
  CONSTRAINT `FK_CTDH` FOREIGN KEY (`ID_DONHANG`) REFERENCES `donhang` (`ID_DONHANG`),
  CONSTRAINT `FK_CTDH1` FOREIGN KEY (`ID_SANPHAM`) REFERENCES `sanpham` (`ID_SANPHAM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdonhang`
--

LOCK TABLES `chitietdonhang` WRITE;
/*!40000 ALTER TABLE `chitietdonhang` DISABLE KEYS */;
INSERT INTO `chitietdonhang` VALUES (13,5,1),(18,13,1),(18,12,1),(19,14,1),(19,12,1),(20,1000,1),(20,13,1);
/*!40000 ALTER TABLE `chitietdonhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmt`
--

DROP TABLE IF EXISTS `cmt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmt` (
  `ID_CMT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SANPHAM` int(11) NOT NULL,
  `ID_TK` int(11) NOT NULL,
  `THOI_GIAN` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NOI_DUNG` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_CMT`),
  KEY `FK_CMT` (`ID_SANPHAM`),
  KEY `FK_TKCM` (`ID_TK`),
  CONSTRAINT `FK_CMT` FOREIGN KEY (`ID_SANPHAM`) REFERENCES `sanpham` (`ID_SANPHAM`),
  CONSTRAINT `FK_TKCM` FOREIGN KEY (`ID_TK`) REFERENCES `taikhoan` (`ID_TK`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmt`
--

LOCK TABLES `cmt` WRITE;
/*!40000 ALTER TABLE `cmt` DISABLE KEYS */;
INSERT INTO `cmt` VALUES (2,2,12,'2017-10-30 12:46:13','Sản phẩm chất liệu rất tốt'),(3,2,12,'2017-10-30 13:07:08','hahahaha'),(4,1000,16,'2018-01-18 09:52:47','');
/*!40000 ALTER TABLE `cmt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmation`
--

DROP TABLE IF EXISTS `confirmation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `confirmation` (
  `ID_TK` int(11) NOT NULL,
  `ID_CONFIRM` varchar(100) NOT NULL,
  `STATUS` int(11) NOT NULL,
  `DATE_CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `TYPE_CONFIRMED` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CONFIRM`),
  KEY `FK_TKCF` (`ID_TK`),
  CONSTRAINT `FK_TKCF` FOREIGN KEY (`ID_TK`) REFERENCES `taikhoan` (`ID_TK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmation`
--

LOCK TABLES `confirmation` WRITE;
/*!40000 ALTER TABLE `confirmation` DISABLE KEYS */;
INSERT INTO `confirmation` VALUES (19,'-998797888',1,'2018-01-19 04:04:59',2);
/*!40000 ALTER TABLE `confirmation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donhang` (
  `ID_DONHANG` int(11) NOT NULL AUTO_INCREMENT,
  `NGAY_DH` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `TONG_TIEN` int(11) DEFAULT NULL,
  `TEN_KHACHHANG` varchar(200) CHARACTER SET utf8 NOT NULL,
  `SDT` varchar(20) DEFAULT NULL,
  `DIACHI` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `STATUS` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID_DONHANG`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
INSERT INTO `donhang` VALUES (1,'2017-12-06 06:12:57',200000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',3),(2,'2017-12-13 06:48:53',50000,'Le tri','0163875778','ĐH Nong Lam','asdasd@fdas.com',3),(3,'2017-12-13 06:56:08',130000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',3),(4,'2017-12-13 06:58:27',160000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',3),(5,'2017-12-20 05:50:58',200000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',3),(6,'2017-12-20 06:01:55',230000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',3),(7,'2017-12-20 06:19:25',300000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',3),(8,'2017-12-20 06:21:17',600000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',3),(9,'2017-12-28 14:58:58',190000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',1),(10,'2017-12-28 15:21:40',200000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',1),(11,'2017-12-28 15:24:48',150000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',1),(12,'2017-12-28 16:12:39',200000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',2),(13,'2017-12-28 16:55:36',120000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',2),(14,'2018-01-15 08:10:16',50000,'Tri','0123123123','ĐH Nong Lam','trile1234@gmail.com',0),(15,'2018-01-15 08:16:38',250000,'Trí Lê','01222977046','Linh Trung, Thủ Đức, TP HCM','14130355@st.hcmuaf.edu.vn',2),(16,'2018-01-15 08:18:46',150000,'Trí Lê','01222977046','Linh Trung, Thủ Đức, TP HCM','14130355@st.hcmuaf.edu.vn',0),(17,'2018-01-15 08:37:14',260000,'Trí Lê','01222977046','Linh Trung, Thủ Đức, TP HCM','14130355@st.hcmuaf.edu.vn',0),(18,'2018-01-15 09:54:19',130000,'Trí Lê','01222977046','Linh Trung, Thủ Đức, TP HCM','14130355@st.hcmuaf.edu.vn',0),(19,'2018-01-18 14:54:59',230000,'Trí Lê','01222977046','Linh Trung, Thủ Đức, TP HCM','14130355@st.hcmuaf.edu.vn',0),(20,'2018-01-19 04:07:16',200000,'Trí Lê','01222977046','Thủ Đức, TP HCM, Việt Nam','lehanhtri287@gmail.com',0);
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaihang`
--

DROP TABLE IF EXISTS `loaihang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loaihang` (
  `ID_LOAIHANG` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_LOAIHANG` varchar(100) CHARACTER SET utf8 NOT NULL,
  `IS_DELETE` int(1) DEFAULT NULL COMMENT '0 is not deleted yet, 1 is deleted',
  PRIMARY KEY (`ID_LOAIHANG`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaihang`
--

LOCK TABLES `loaihang` WRITE;
/*!40000 ALTER TABLE `loaihang` DISABLE KEYS */;
INSERT INTO `loaihang` VALUES (1,'Đồ Handmade',0),(2,'Thời trang',0),(3,'Phụ kiện',0),(11,'Sách vải',0),(12,'Mặt hàng khác',0),(14,'Áo thun trẻ em',0);
/*!40000 ALTER TABLE `loaihang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sanpham` (
  `ID_SANPHAM` int(15) NOT NULL AUTO_INCREMENT,
  `TEN_SANPHAM` varchar(200) CHARACTER SET utf8 NOT NULL,
  `GIA` int(11) NOT NULL,
  `MO_TA` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `TINH_TRANG` int(11) NOT NULL COMMENT '0: not deleted yet, 1: deleted',
  `ID_LOAIHANG` int(11) DEFAULT NULL,
  `GIAM_GIA` int(11) DEFAULT NULL,
  `IMAGES` varchar(500) DEFAULT NULL,
  `SO_LUONG` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_SANPHAM`),
  KEY `FK_SP` (`ID_LOAIHANG`),
  CONSTRAINT `FK_SP` FOREIGN KEY (`ID_LOAIHANG`) REFERENCES `loaihang` (`ID_LOAIHANG`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (2,'Gối nhỏ có hình',150000,'Hàng mới',0,1,0,'/images/pic_1.jpg',1),(3,'Gối lớn hình cá heo',250000,'Hàng mới',0,1,0,'/images/pic_2.jpg',1),(4,'Thú bông vịt con',200000,'Hàng mới',0,1,0,'/images/pic_3.jpg',1),(5,'Gối hình cá heo',100000,'Hàng mới',0,1,0,'/images/pic_5.jpg',1),(6,'Túi dây rút hình cà rốt',40000,'Hàng mới',0,2,0,'/images/pic_6.jpg',1),(7,'Gối hình trái tim',80000,'Áo gối',0,3,0,'/images/pic_7.jpg',1),(12,'Gối kê cổ',80000,'Đồ handmade',0,2,0,'/images/pic_8.jpg',1),(13,'Gối kê cổ angry bird',50000,'Hàng xách tay từ Mỹ',0,1,0,'/images/pic_8.jpg',1),(14,'Áo sơ mi trắng',150000,'Áo sơ mi trắng size S, M, L, XL ',0,2,10,'/images/pr2.jpg',1),(1000,'Áo sơ mi xanh',150000,'THÔNG TIN SẢN PHẨM\r\nÁo sơ mi nam – Chất liệu poplin, bề mặt vải ít nhăn, kết cấu chặt chẽ, xang bông mềm mại, tạo cảm giác mịn màng, thấm mồ hôi, thoáng mát.\r\n- Sản phẩm có màu sắc đen, trắng tao nhã kết hợp với hình rồng thêu màu xanh cá tính, tạo nên vẻ đẹp thanh lịch và sang trọng cho người mặc.\r\n- Kiểu dáng Slimfit – form ôm.\r\n- Cổ áo kiểu cổ bẻ Đức khỏe khoắn.\r\n- Chỉ thêu sản xuất tại Việt Nam, bền màu không độc hại.\r\n- Thông số mẫu: Cao 1.72m - Nặng 73kg - Size áo L',0,12,NULL,'/images/pi3.png',10),(1002,'Voi con',99000,'Voi bông màu xanh \r\nĐồ chơi cho trẻ em trên 3 tuổi',0,1,NULL,'/images/pic_4.jpg',10),(1003,'Lục lạc',230000,'Lục lạc vàng đáng yêu quá đi',0,12,0,'/images/1.jpg',5);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taikhoan` (
  `ID_TK` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_DANGNHAP` varchar(200) CHARACTER SET utf8 NOT NULL,
  `MAT_KHAU` varchar(200) NOT NULL,
  `CHUCVU` varchar(50) DEFAULT 'KH',
  `TEN_KH` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `DIACHI` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `SDT` varchar(15) DEFAULT NULL,
  `IS_CONFIRM` int(1) DEFAULT '0',
  PRIMARY KEY (`ID_TK`),
  UNIQUE KEY `TEN_DANGNHAP_UNIQUE` (`TEN_DANGNHAP`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (2,'trile@gmail.com','jgXSEb8rRL9MfZ62Do2StA==','ADM','Trí Lê','Quảng Ngãi','0123456789',1),(3,'kaitoukid287@gmail.com','Mkq9I7T+bvAkZLbAskE+5g==','KH','Lê Huỳnh Anh Trí','Mộ Đức, Quảng Ngãi','0123456789',1),(11,'tranlevihandshop@gmail.com','5aOX+VJPKGuPh8haPkIxUUH7ZB7U2MyLheBHdsK7bBo=','KH','Tran Le Vi','Quảng Ngãi','01231231312',1),(12,'trile287@gmail.com','q/BzX55ILGJ1KbVzCzVR2PRRYGjkU77b/7tz3twFxRc=','KH','Lê Trí','KTX Khu B DDHQG, TPHCM','0123456789',1),(14,'abcde@gmail.com','w3yVQyUYr1eLxfSexYK7kg==','KH','Trí Lê','TPHCM','01231313123',1),(15,'trile111@gmail.com','m4ogkrvo5P4ES9wB3YgB1g==','KH','Tri','TPHCM','01234213123',1),(16,'trile1234@gmail.com','tXFqyKae5bg6DwE0k1nDTA==','KH','Tri','ĐH Nong Lam','0123123123',1),(19,'lehanhtri287@gmail.com','4rETeruPmfPLHDMGWM7U/A==','KH','Trí Lê','Thủ Đức, TP HCM, Việt Nam','01222977046',1);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tintuc`
--

DROP TABLE IF EXISTS `tintuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tintuc` (
  `ID_TT` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `CONTEXT` text CHARACTER SET utf8,
  `ID_TK` int(11) NOT NULL,
  `NGUOI_DANG` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `NGAY_DANG` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_TT`),
  KEY `FK_TT` (`ID_TK`),
  CONSTRAINT `FK_TT` FOREIGN KEY (`ID_TK`) REFERENCES `taikhoan` (`ID_TK`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tintuc`
--

LOCK TABLES `tintuc` WRITE;
/*!40000 ALTER TABLE `tintuc` DISABLE KEYS */;
INSERT INTO `tintuc` VALUES (1,'TEST','TESTING MOTHERFUCKER',3,'TRÍ LÊ','2017-08-14 03:01:37');
/*!40000 ALTER TABLE `tintuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_comment`
--

DROP TABLE IF EXISTS `v_comment`;
/*!50001 DROP VIEW IF EXISTS `v_comment`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_comment` AS SELECT 
 1 AS `ID_CMT`,
 1 AS `ID_SANPHAM`,
 1 AS `TEN_KH`,
 1 AS `THOI_GIAN`,
 1 AS `NOI_DUNG`,
 1 AS `TEN_DANGNHAP`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_dhofkh`
--

DROP TABLE IF EXISTS `v_dhofkh`;
/*!50001 DROP VIEW IF EXISTS `v_dhofkh`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_dhofkh` AS SELECT 
 1 AS `ID_DONHANG`,
 1 AS `NGAY_DH`,
 1 AS `TONG_TIEN`,
 1 AS `STATUS`,
 1 AS `ID_TK`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_donhang`
--

DROP TABLE IF EXISTS `v_donhang`;
/*!50001 DROP VIEW IF EXISTS `v_donhang`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_donhang` AS SELECT 
 1 AS `ID_DONHANG`,
 1 AS `ID_SANPHAM`,
 1 AS `SO_LUONG`,
 1 AS `TEN_SANPHAM`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_likemost`
--

DROP TABLE IF EXISTS `v_likemost`;
/*!50001 DROP VIEW IF EXISTS `v_likemost`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_likemost` AS SELECT 
 1 AS `ID_SANPHAM`,
 1 AS `TEN_SANPHAM`,
 1 AS `GIA`,
 1 AS `MO_TA`,
 1 AS `TINH_TRANG`,
 1 AS `ID_LOAIHANG`,
 1 AS `GIAM_GIA`,
 1 AS `IMAGES`,
 1 AS `SO_LUONG`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_sanpham`
--

DROP TABLE IF EXISTS `v_sanpham`;
/*!50001 DROP VIEW IF EXISTS `v_sanpham`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_sanpham` AS SELECT 
 1 AS `ID_SANPHAM`,
 1 AS `TEN_SANPHAM`,
 1 AS `GIA`,
 1 AS `MO_TA`,
 1 AS `TINH_TRANG`,
 1 AS `ID_LOAIHANG`,
 1 AS `GIAM_GIA`,
 1 AS `IMAGES`,
 1 AS `TEN_LOAIHANG`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_comment`
--

/*!50001 DROP VIEW IF EXISTS `v_comment`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_comment` AS select `cmt`.`ID_CMT` AS `ID_CMT`,`cmt`.`ID_SANPHAM` AS `ID_SANPHAM`,`tk`.`TEN_KH` AS `TEN_KH`,`cmt`.`THOI_GIAN` AS `THOI_GIAN`,`cmt`.`NOI_DUNG` AS `NOI_DUNG`,`tk`.`TEN_DANGNHAP` AS `TEN_DANGNHAP` from (`cmt` join `taikhoan` `tk` on((`cmt`.`ID_TK` = `tk`.`ID_TK`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_dhofkh`
--

/*!50001 DROP VIEW IF EXISTS `v_dhofkh`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_dhofkh` AS select `dh`.`ID_DONHANG` AS `ID_DONHANG`,`dh`.`NGAY_DH` AS `NGAY_DH`,`dh`.`TONG_TIEN` AS `TONG_TIEN`,`dh`.`STATUS` AS `STATUS`,`tk`.`ID_TK` AS `ID_TK` from (`donhang` `dh` join `taikhoan` `tk` on((convert(`dh`.`EMAIL` using utf8) = `tk`.`TEN_DANGNHAP`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_donhang`
--

/*!50001 DROP VIEW IF EXISTS `v_donhang`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_donhang` AS select `ct`.`ID_DONHANG` AS `ID_DONHANG`,`ct`.`ID_SANPHAM` AS `ID_SANPHAM`,`ct`.`SO_LUONG` AS `SO_LUONG`,`sp`.`TEN_SANPHAM` AS `TEN_SANPHAM` from (`chitietdonhang` `ct` join `sanpham` `sp` on((`ct`.`ID_SANPHAM` = `sp`.`ID_SANPHAM`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_likemost`
--

/*!50001 DROP VIEW IF EXISTS `v_likemost`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_likemost` AS select `sp`.`ID_SANPHAM` AS `ID_SANPHAM`,`sp`.`TEN_SANPHAM` AS `TEN_SANPHAM`,`sp`.`GIA` AS `GIA`,`sp`.`MO_TA` AS `MO_TA`,`sp`.`TINH_TRANG` AS `TINH_TRANG`,`sp`.`ID_LOAIHANG` AS `ID_LOAIHANG`,`sp`.`GIAM_GIA` AS `GIAM_GIA`,`sp`.`IMAGES` AS `IMAGES`,`sp`.`SO_LUONG` AS `SO_LUONG` from (`sanpham` `sp` join `chitietdonhang` `ctdh` on((`sp`.`ID_SANPHAM` = `ctdh`.`ID_SANPHAM`))) where (`sp`.`TINH_TRANG` = 1) group by `sp`.`ID_SANPHAM` limit 5 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_sanpham`
--

/*!50001 DROP VIEW IF EXISTS `v_sanpham`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_sanpham` AS select `sp`.`ID_SANPHAM` AS `ID_SANPHAM`,`sp`.`TEN_SANPHAM` AS `TEN_SANPHAM`,`sp`.`GIA` AS `GIA`,`sp`.`MO_TA` AS `MO_TA`,`sp`.`TINH_TRANG` AS `TINH_TRANG`,`sp`.`ID_LOAIHANG` AS `ID_LOAIHANG`,`sp`.`GIAM_GIA` AS `GIAM_GIA`,`sp`.`IMAGES` AS `IMAGES`,`lh`.`TEN_LOAIHANG` AS `TEN_LOAIHANG` from (`sanpham` `sp` join `loaihang` `lh` on((`sp`.`ID_LOAIHANG` = `lh`.`ID_LOAIHANG`))) where (`sp`.`TINH_TRANG` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-24 22:57:22
