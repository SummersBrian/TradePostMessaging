package com.example.terptradingpostmessaging;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class InboxViewActivity extends ListActivity {
	
	private ArrayAdapter<InboxItem> mInboxAdapter;
	private ArrayList<InboxItem> mInboxList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inbox);
		
		//change the text of the actionbar
		getActionBar().setTitle("TradePostMessages");
		
		//instantiate the inbox list
		mInboxList = new ArrayList<InboxItem>();
		
		//instantiate and assign the list adapter
		mInboxAdapter = new ArrayAdapter<InboxItem>(getApplicationContext(), R.layout.inbox_item,
				R.id.textName, mInboxList);
		setListAdapter(mInboxAdapter);
		populateInbox();
	}
	
	//item in the inbox has been clicked
	@Override
	protected void onListItemClick(ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);
		
		InboxItem selectedItem = mInboxList.get(position);
		
		//TODO send intent to a conversation activity
		Intent toConvo = new Intent(InboxViewActivity.this, ConversationViewActivity.class);
		toConvo.putExtra("name", mInboxAdapter.getItem(position).getName());
		toConvo.putExtra("conversation", selectedItem);
		startActivity(toConvo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inbox, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void addNewInboxItem(String name, Bitmap profileImage) {
		
		InboxItem newInboxItem = new InboxItem(name, profileImage);
		mInboxList.add(newInboxItem);
		mInboxAdapter.notifyDataSetChanged();
		
	}
	
	private void populateInbox() {
		addNewInboxItem("Brian", null);
		addNewInboxItem("James", null);
		addNewInboxItem("Will", null);
	}
}
