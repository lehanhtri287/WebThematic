package com.example.demo.entities;
// Generated May 23, 2018 1:38:46 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ChitietdonhangId generated by hbm2java
 */
@Embeddable
public class ChitietdonhangId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idDonhang;
	private Integer idSanpham;
	private Integer soLuong;

	public ChitietdonhangId() {
	}

	public ChitietdonhangId(Integer idDonhang, Integer idSanpham, Integer soLuong) {
		this.idDonhang = idDonhang;
		this.idSanpham = idSanpham;
		this.soLuong = soLuong;
	}

	@Column(name = "ID_DONHANG")
	public Integer getIdDonhang() {
		return this.idDonhang;
	}

	public void setIdDonhang(Integer idDonhang) {
		this.idDonhang = idDonhang;
	}

	@Column(name = "ID_SANPHAM")
	public Integer getIdSanpham() {
		return this.idSanpham;
	}

	public void setIdSanpham(Integer idSanpham) {
		this.idSanpham = idSanpham;
	}

	@Column(name = "SO_LUONG")
	public Integer getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ChitietdonhangId))
			return false;
		ChitietdonhangId castOther = (ChitietdonhangId) other;

		return ((this.getIdDonhang() == castOther.getIdDonhang()) || (this.getIdDonhang() != null
				&& castOther.getIdDonhang() != null && this.getIdDonhang().equals(castOther.getIdDonhang())))
				&& ((this.getIdSanpham() == castOther.getIdSanpham()) || (this.getIdSanpham() != null
						&& castOther.getIdSanpham() != null && this.getIdSanpham().equals(castOther.getIdSanpham())))
				&& ((this.getSoLuong() == castOther.getSoLuong()) || (this.getSoLuong() != null
						&& castOther.getSoLuong() != null && this.getSoLuong().equals(castOther.getSoLuong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdDonhang() == null ? 0 : this.getIdDonhang().hashCode());
		result = 37 * result + (getIdSanpham() == null ? 0 : this.getIdSanpham().hashCode());
		result = 37 * result + (getSoLuong() == null ? 0 : this.getSoLuong().hashCode());
		return result;
	}

}
