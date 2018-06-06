package com.example.demo.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chitietdonhang", catalog = "shophandmade")
public class Chitietdonhang implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private ChitietdonhangId id;
	private Donhang donhang;
	private Sanpham sanpham;

	public Chitietdonhang() {
	}

	public Chitietdonhang(ChitietdonhangId id) {
		this.id = id;
	}

	public Chitietdonhang(ChitietdonhangId id, Donhang donhang, Sanpham sanpham) {
		this.id = id;
		this.donhang = donhang;
		this.sanpham = sanpham;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idDonhang", column = @Column(name = "ID_DONHANG")),
			@AttributeOverride(name = "idSanpham", column = @Column(name = "ID_SANPHAM")),
			@AttributeOverride(name = "soLuong", column = @Column(name = "SO_LUONG")) })
	public ChitietdonhangId getId() {
		return this.id;
	}

	public void setId(ChitietdonhangId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DONHANG", insertable = false, updatable = false)
	public Donhang getDonhang() {
		return this.donhang;
	}

	public void setDonhang(Donhang donhang) {
		this.donhang = donhang;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SANPHAM", insertable = false, updatable = false)
	public Sanpham getSanpham() {
		return this.sanpham;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}

}
