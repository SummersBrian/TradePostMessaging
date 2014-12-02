package com.example.terptradingpostmessaging;

public class TradeMessage {
	private String mSenderName;
	private String mRecipientName;
	private String mMessage;
	private long mTime;
	
	public TradeMessage(String sender, String recipient, String message, long time) {
		mSenderName = sender;
		mRecipientName = recipient;
		mMessage = message;
		mTime = time;
	}
	
	public String getSender() {
		return mSenderName;
	}
	
	public String getRecipient() {
		return mRecipientName;
	}
	
	public String getMessage() {
		return mMessage;
	}
	
	public String timeToString() {
		return ((Long) mTime).toString();
	}
	
	public String toString() {
		return mMessage;
	}
}
