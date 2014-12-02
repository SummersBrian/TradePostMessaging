package com.example.terptradingpostmessaging;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;

public class ConversationViewActivity extends ListActivity{
	
	private ArrayAdapter<TradeMessage> mTradeMessagesAdapter;
	private ArrayList<TradeMessage> mTradeMessages;
	private final static String USER = "user";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversation);
		
		final Intent receivedIntent = getIntent();
		
		getActionBar().setTitle("TradePost messages with "+ receivedIntent.getStringExtra("name"));
		
		mTradeMessages = new ArrayList<TradeMessage>();
		
		mTradeMessages = ((InboxItem)receivedIntent.getSerializableExtra("conversation")).getConversation();
		mTradeMessagesAdapter = new ArrayAdapter<TradeMessage>(getApplicationContext(), R.layout.trade_message, R.id.message, mTradeMessages);
		setListAdapter(mTradeMessagesAdapter);
		mTradeMessagesAdapter.notifyDataSetChanged();
		
		Button sendButton = (Button) findViewById(R.id.sendButton);
		sendButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				TradeMessage tradeMessage = new TradeMessage(USER, receivedIntent.getStringExtra("name"), 
						((EditText) findViewById(R.id.enterMessage)).getText().toString(), System.currentTimeMillis());
				sendMessage(tradeMessage);
				
			}
			
		});
		receiveMessage();
	}
	
	@Override
	protected void onListItemClick(ListView list, View view, int position, long id) {
		return;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return true;
	}
	
	public void sendMessage(TradeMessage tradeMessage) {
		//TODO send message to gcm/server
	}
	
	public void receiveMessage() {
		//for testing purposes
		TradeMessage tm = new TradeMessage("Brian", USER, "Hey, what's up?", System.currentTimeMillis());
		mTradeMessages.add(tm);
		mTradeMessagesAdapter.notifyDataSetChanged();
		
		//TODO get message from gcm/server
	}
}
