package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class TaikhoanSignup {
	
	@Email(message = "{accSignup.email.invalid}")
	@NotEmpty(message = "{accSignup.empty}")
	private String tenDangnhap;
	@NotEmpty(message = "{accSignup.empty}")
	private String matKhau;
	@NotEmpty(message = "{accSignup.empty}")
	private String xacNhanMatKhau;
	private String tenKh;
	private String diachi;
	private String sdt;

	public TaikhoanSignup() {
	};

	public TaikhoanSignup(String tenDangnhap, String matKhau, String xacNhanMatKhau, String tenKh, String diachi,
			String sdt) {
		super();
		this.tenDangnhap = tenDangnhap;
		this.matKhau = matKhau;
		this.xacNhanMatKhau = xacNhanMatKhau;
		this.tenKh = tenKh;
		this.diachi = diachi;
		this.sdt = sdt;
	}

	public String getTenDangnhap() {
		return tenDangnhap;
	}

	public void setTenDangnhap(String tenDangnhap) {
		this.tenDangnhap = tenDangnhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getXacNhanMatKhau() {
		return xacNhanMatKhau;
	}

	public void setXacNhanMatKhau(String xacNhanMatKhau) {
		this.xacNhanMatKhau = xacNhanMatKhau;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

}
