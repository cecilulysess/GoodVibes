package com.teamgv.goodvibes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class HomeActivity extends Activity {
	
	public static final String PREFS_NAME = "share";
	private int whichOne;
	private ArrayList<String> headlines;
	private ArrayList<String> fullPosts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		SharedPreferences transfer = getSharedPreferences(PREFS_NAME, 0);
		final SharedPreferences.Editor edit = transfer.edit();
		
		headlines = new ArrayList<String>();
		headlines.add(getString(R.string.GoodVibeTitle1));
		headlines.add(getString(R.string.GoodVibeTitle1));
		headlines.add(getString(R.string.GoodVibeTitle2));
		
		fullPosts = new ArrayList<String>();
		fullPosts.add(getString(R.string.GoodVibeFull));
		fullPosts.add(getString(R.string.GoodVibeFull));
		fullPosts.add(getString(R.string.GoodVibeFull2));
		
		LinearLayout lay = (LinearLayout) findViewById(R.id.main_screen);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		
		LinearLayout newPost = new LinearLayout(this);
		newPost.setLayoutParams(lp);
		newPost.setBackgroundResource(R.drawable.customborder);
		newPost.setOrientation(LinearLayout.VERTICAL);
		
		LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		
		LayoutParams picture = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT,
				200);
		
		TextView headline = new TextView(this);
		headline.setText(R.string.GoodVibeTitle2);
		headline.setGravity(Gravity.CENTER);
		headline.setLayoutParams(params);
		newPost.addView(headline);
		
		RelativeLayout pic = new RelativeLayout(this);
		pic.setLayoutParams(picture);
		pic.setBackgroundResource(R.drawable.cake);
		newPost.addView(pic);
		
		TextView partStory = new TextView(this);
		partStory.setText(R.string.GoodVibe2);
		partStory.setLayoutParams(params);
		newPost.addView(partStory);
		
		lay.addView(newPost);
		
		ArrayList<LinearLayout> posts = new ArrayList<LinearLayout>();
		LinearLayout aPost = (LinearLayout) findViewById(R.id.linearLayout1);
		posts.add(aPost);
		aPost = (LinearLayout) findViewById(R.id.linearLayout2);
		posts.add(aPost);
		posts.add(newPost);
		posts.get(0).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				whichOne = 0;
				
				edit.putString("Title", headlines.get(whichOne));
				edit.putString("Full Post", fullPosts.get(whichOne));
				edit.commit();
				
				Intent i = new Intent(getApplicationContext(), FullPost.class);
				startActivity(i);
			}
		});
		posts.get(1).setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View arg0)
			{
				whichOne = 1;
				
				edit.putString("Title", headlines.get(whichOne));
				edit.putString("Full Post", fullPosts.get(whichOne));
				edit.commit();
				
				Intent i = new Intent(getApplicationContext(), FullPost.class);
				startActivity(i);
			}
		});
		posts.get(2).setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View arg0)
			{
				whichOne = 2;
				
				edit.putString("Title", headlines.get(whichOne));
				edit.putString("Full Post", fullPosts.get(whichOne));
				edit.commit();
				
				Intent i = new Intent(getApplicationContext(), FullPost.class);
				startActivity(i);
			}
		});
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
