package com.example.demo.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Donhang generated by hbm2java
 */
@Entity
@Table(name = "donhang", catalog = "shophandmade")
public class Donhang implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idDonhang;
	private Date ngayDh;
	private Integer tongTien;
	private String tenKhachhang;
	private String sdt;
	private String diachi;
	private String email;
	private Integer status;

	public Donhang() {
	}

	public Donhang(String tenKhachhang) {
		this.tenKhachhang = tenKhachhang;
	}

	public Donhang(Date ngayDh, Integer tongTien, String tenKhachhang, String sdt, String diachi, String email,
			Integer status) {
		this.ngayDh = ngayDh;
		this.tongTien = tongTien;
		this.tenKhachhang = tenKhachhang;
		this.sdt = sdt;
		this.diachi = diachi;
		this.email = email;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_DONHANG", unique = true, nullable = false)
	public Integer getIdDonhang() {
		return this.idDonhang;
	}

	public void setIdDonhang(Integer idDonhang) {
		this.idDonhang = idDonhang;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NGAY_DH", length = 19)
	public Date getNgayDh() {
		return this.ngayDh;
	}

	public void setNgayDh(Date ngayDh) {
		this.ngayDh = ngayDh;
	}

	@Column(name = "TONG_TIEN")
	public Integer getTongTien() {
		return this.tongTien;
	}

	public void setTongTien(Integer tongTien) {
		this.tongTien = tongTien;
	}

	@Column(name = "TEN_KHACHHANG", nullable = false, length = 200)
	public String getTenKhachhang() {
		return this.tenKhachhang;
	}

	public void setTenKhachhang(String tenKhachhang) {
		this.tenKhachhang = tenKhachhang;
	}

	@Column(name = "SDT", length = 20)
	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@Column(name = "DIACHI", length = 500)
	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "STATUS")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Donhang [idDonhang=" + idDonhang + ", ngayDh=" + ngayDh + ", tongTien=" + tongTien + ", tenKhachhang="
				+ tenKhachhang + ", sdt=" + sdt + ", diachi=" + diachi + ", email=" + email + ", status=" + status
				+ "]";
	}

}
