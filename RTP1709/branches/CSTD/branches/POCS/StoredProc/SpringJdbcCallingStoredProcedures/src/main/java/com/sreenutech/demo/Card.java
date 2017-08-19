package com.sreenutech.demo;

public class Card {

	private int id;
	private long crdno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCrdno() {
		return crdno;
	}

	public void setCrdno(long crdno) {
		this.crdno = crdno;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [id=");
		builder.append(id);
		builder.append(", crdno=");
		builder.append(crdno);
		builder.append("]");
		return builder.toString();
	}

}