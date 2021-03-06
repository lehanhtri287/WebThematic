package com.example.demo.entities;
// Generated May 2, 2018 12:42:50 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Loaihang generated by hbm2java
 */
@Entity
@Table(name = "loaihang", catalog = "shophandmade")
public class Loaihang implements java.io.Serializable {

	private Integer idLoaihang;
	private String tenLoaihang;
	private Set sanphams = new HashSet(0);

	public Loaihang() {
	}

	public Loaihang(String tenLoaihang) {
		this.tenLoaihang = tenLoaihang;
	}

	public Loaihang(String tenLoaihang, Set sanphams) {
		this.tenLoaihang = tenLoaihang;
		this.sanphams = sanphams;
	}

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaihang")
	public Set getSanphams() {
		return this.sanphams;
	}

	public void setSanphams(Set sanphams) {
		this.sanphams = sanphams;
	}

}
