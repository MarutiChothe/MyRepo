package com.mock.test.b;

public class BReq {
	

	private String CardName;
	private long CardNumber;
	public String getCardName() {
		return CardName;
	}
	public void setCardName(String cardName) {
		CardName = cardName;
	}
	public long getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(long cardNumber) {
		CardNumber = cardNumber;
	}
	@Override
	public String toString() {
		return "AReq [CardName=" + CardName + ", CardNumber=" + CardNumber
				+ "]";
	}
	

}
