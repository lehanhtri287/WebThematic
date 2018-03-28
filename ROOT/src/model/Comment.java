package model;

import java.sql.Timestamp;

public class Comment {
	private int idComment;
	private int idProduct;
	private String nameCustomer;
	private Timestamp timeCmt;
	private String context;
	private String email;

	public Comment() {
	}

	public Comment(int idComment, int idProduct, String nameCustomer, Timestamp timeCmt, String context) {
		this.idComment = idComment;
		this.idProduct = idProduct;
		this.nameCustomer = nameCustomer;
		this.timeCmt = timeCmt;
		this.context = context;
	}

	public Comment(int idProduct, String nameCustomer, String context, String email) {
		this.idProduct = idProduct;
		this.nameCustomer = nameCustomer;
		this.context = context;
		this.email = email;
	}

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public Timestamp getTimeCmt() {
		return timeCmt;
	}

	public void setTimeCmt(Timestamp timeCmt) {
		this.timeCmt = timeCmt;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", idProduct=" + idProduct + ", nameCustomer=" + nameCustomer
				+ ", timeCmt=" + timeCmt + ", context=" + context + "]";
	}

}