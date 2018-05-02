package com.example.demo.entities;
// Generated May 2, 2018 12:43:54 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VComment generated by hbm2java
 */
@Entity
@Table(name = "v_comment", catalog = "shophandmade")
public class VComment implements java.io.Serializable {

	private VCommentId id;

	public VComment() {
	}

	public VComment(VCommentId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idCmt", column = @Column(name = "ID_CMT", nullable = false)),
			@AttributeOverride(name = "idSanpham", column = @Column(name = "ID_SANPHAM", nullable = false)),
			@AttributeOverride(name = "tenKh", column = @Column(name = "TEN_KH", length = 200)),
			@AttributeOverride(name = "thoiGian", column = @Column(name = "THOI_GIAN", nullable = false, length = 19)),
			@AttributeOverride(name = "noiDung", column = @Column(name = "NOI_DUNG", length = 500)),
			@AttributeOverride(name = "tenDangnhap", column = @Column(name = "TEN_DANGNHAP", length = 200)) })
	public VCommentId getId() {
		return this.id;
	}

	public void setId(VCommentId id) {
		this.id = id;
	}

}
