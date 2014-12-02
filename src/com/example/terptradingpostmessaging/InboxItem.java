package com.example.terptradingpostmessaging;

import java.io.Serializable;
import java.util.ArrayList;

import android.graphics.Bitmap;

public class InboxItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7371748652508195312L;
	private String mName;
	private Bitmap mProfileImage;
	//TODO Conversation Item, which is a list of messages - Or some information of where to
	//grab the conversation from the server
	//private Conversation conversation;
	private ArrayList<TradeMessage> mConversation;

	public InboxItem(String name, Bitmap profileImage) {
		mName = name;
		mProfileImage = profileImage;
		mConversation = new ArrayList<TradeMessage>();
	}
	
	public String getName() {
		return mName;
	}
	
	public Bitmap getProfileImage() {
		return mProfileImage;
	}
	
	public ArrayList<TradeMessage> getConversation() {
		return mConversation;
	}

	public boolean equals(Object o) {
		if (o != null) {
			InboxItem other = (InboxItem) o;
			if (other.getName().equals(this.mName))
				return true;
			else
				return false;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return mName;
	}

}
