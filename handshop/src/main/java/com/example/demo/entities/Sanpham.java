package com.example.demo.entities;
// Generated May 2, 2018 12:43:54 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Sanpham generated by hbm2java
 */
@Entity
@Table(name = "sanpham", catalog = "shophandmade")
public class Sanpham implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idSanpham;
	private Loaihang loaihang;
	private String tenSanpham;
	private int gia;
	private String moTa;
	private int tinhTrang;
	private Integer giamGia;
	private String images;
	private Integer soLuong;

	public Sanpham() {
	}

	public Sanpham(String tenSanpham, int gia, int tinhTrang) {
		this.tenSanpham = tenSanpham;
		this.gia = gia;
		this.tinhTrang = tinhTrang;
	}

	public Sanpham(Loaihang loaihang, String tenSanpham, int gia, String moTa, int tinhTrang, Integer giamGia,
			String images, Integer soLuong) {
		this.loaihang = loaihang;
		this.tenSanpham = tenSanpham;
		this.gia = gia;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.giamGia = giamGia;
		this.images = images;
		this.soLuong = soLuong;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_SANPHAM", unique = true, nullable = false)
	public Integer getIdSanpham() {
		return this.idSanpham;
	}

	public void setIdSanpham(Integer idSanpham) {
		this.idSanpham = idSanpham;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LOAIHANG")
	public Loaihang getLoaihang() {
		return this.loaihang;
	}

	public void setLoaihang(Loaihang loaihang) {
		this.loaihang = loaihang;
	}

	@Column(name = "TEN_SANPHAM", nullable = false, length = 200)
	public String getTenSanpham() {
		return this.tenSanpham;
	}

	public void setTenSanpham(String tenSanpham) {
		this.tenSanpham = tenSanpham;
	}

	@Column(name = "GIA", nullable = false)
	public int getGia() {
		return this.gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	@Column(name = "MO_TA", length = 500)
	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Column(name = "TINH_TRANG", nullable = false)
	public int getTinhTrang() {
		return this.tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Column(name = "GIAM_GIA")
	public Integer getGiamGia() {
		return this.giamGia;
	}

	public void setGiamGia(Integer giamGia) {
		this.giamGia = giamGia;
	}

	@Column(name = "IMAGES", length = 500)
	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Column(name = "SO_LUONG")
	public Integer getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "Sanpham [idSanpham=" + idSanpham + ", loaihang=" + loaihang + ", tenSanpham=" + tenSanpham + ", gia="
				+ gia + ", moTa=" + moTa + ", tinhTrang=" + tinhTrang + ", giamGia=" + giamGia + ", images=" + images
				+ ", soLuong=" + soLuong + "]";
	}

}
