package com.example.demo.entities;
// Generated May 2, 2018 12:43:54 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Loaihang generated by hbm2java
 */
@Entity
@Table(name = "loaihang", catalog = "shophandmade")
public class Loaihang implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idLoaihang;
	private String tenLoaihang;
	private Integer isDelete;

	public Loaihang() {
	}

	public Loaihang(String tenLoaihang) {
		this.tenLoaihang = tenLoaihang;
	}
	// public Loaihang(Integer idLoaihang, String tenLoaihang) {
	// this.idLoaihang = idLoaihang;
	// this.tenLoaihang = tenLoaihang;
	// }

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_LOAIHANG", unique = true, nullable = false)
	public Integer getIdLoaihang() {
		return this.idLoaihang;
	}

	public void setIdLoaihang(Integer idLoaihang) {
		this.idLoaihang = idLoaihang;
	}

	@Column(name = "TEN_LOAIHANG", nullable = false, length = 100)
	public String getTenLoaihang() {
		return this.tenLoaihang;
	}

	public void setTenLoaihang(String tenLoaihang) {
		this.tenLoaihang = tenLoaihang;
	}

	@Column(name = "IS_DELETE", nullable = true, length = 1)
	public Integer getIsdelete() {
		return this.isDelete;
	}

	public void setIsdelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Loaihang [idLoaihang=" + idLoaihang + ", tenLoaihang=" + tenLoaihang + ", isDelete=" + isDelete + "]";
	}

}
