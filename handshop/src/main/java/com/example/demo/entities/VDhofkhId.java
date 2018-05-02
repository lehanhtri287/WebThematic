package com.example.demo.entities;
// Generated May 2, 2018 12:43:54 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDhofkhId generated by hbm2java
 */
@Embeddable
public class VDhofkhId implements java.io.Serializable {

	private int idDonhang;
	private Date ngayDh;
	private Integer tongTien;
	private Integer status;
	private int idTk;

	public VDhofkhId() {
	}

	public VDhofkhId(int idDonhang, int idTk) {
		this.idDonhang = idDonhang;
		this.idTk = idTk;
	}

	public VDhofkhId(int idDonhang, Date ngayDh, Integer tongTien, Integer status, int idTk) {
		this.idDonhang = idDonhang;
		this.ngayDh = ngayDh;
		this.tongTien = tongTien;
		this.status = status;
		this.idTk = idTk;
	}

	@Column(name = "ID_DONHANG", nullable = false)
	public int getIdDonhang() {
		return this.idDonhang;
	}

	public void setIdDonhang(int idDonhang) {
		this.idDonhang = idDonhang;
	}

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

	@Column(name = "STATUS")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "ID_TK", nullable = false)
	public int getIdTk() {
		return this.idTk;
	}

	public void setIdTk(int idTk) {
		this.idTk = idTk;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDhofkhId))
			return false;
		VDhofkhId castOther = (VDhofkhId) other;

		return (this.getIdDonhang() == castOther.getIdDonhang())
				&& ((this.getNgayDh() == castOther.getNgayDh()) || (this.getNgayDh() != null
						&& castOther.getNgayDh() != null && this.getNgayDh().equals(castOther.getNgayDh())))
				&& ((this.getTongTien() == castOther.getTongTien()) || (this.getTongTien() != null
						&& castOther.getTongTien() != null && this.getTongTien().equals(castOther.getTongTien())))
				&& ((this.getStatus() == castOther.getStatus()) || (this.getStatus() != null
						&& castOther.getStatus() != null && this.getStatus().equals(castOther.getStatus())))
				&& (this.getIdTk() == castOther.getIdTk());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdDonhang();
		result = 37 * result + (getNgayDh() == null ? 0 : this.getNgayDh().hashCode());
		result = 37 * result + (getTongTien() == null ? 0 : this.getTongTien().hashCode());
		result = 37 * result + (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37 * result + this.getIdTk();
		return result;
	}

}
