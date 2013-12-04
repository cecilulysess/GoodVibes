package com.teamgv.goodvibes;

import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.View;
import android.view.Gravity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;

public class FullPost extends Activity {
	public static final String PREFS_NAME = "share";
	Button goBack;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.full_post);
		//Julian: Navigator back button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//--------------------------
		SharedPreferences transfer = getSharedPreferences(PREFS_NAME, 0);
		String headline = transfer.getString("Title", "error");
		String post = transfer.getString("Full Post", "error");
		
		LinearLayout lay = (LinearLayout) findViewById(R.id.full_post);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		
		LinearLayout fullPost = new LinearLayout(this);
		fullPost.setLayoutParams(lp);
		fullPost.setBackgroundResource(R.drawable.customborder);
		fullPost.setOrientation(LinearLayout.VERTICAL);
		
		LayoutParams dimensions = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		
		LayoutParams image = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT,
				200);
		
		TextView head = new TextView(this);
		head.setText(headline);
		head.setGravity(Gravity.CENTER);
		head.setLayoutParams(dimensions);
		fullPost.addView(head);
		
		RelativeLayout pic = new RelativeLayout(this);
		pic.setLayoutParams(image);
		pic.setBackgroundResource(R.drawable.cake);
		fullPost.addView(pic);
		
		TextView fullStory = new TextView(this);
		fullStory.setText(post);
		fullStory.setLayoutParams(dimensions);
		fullPost.addView(fullStory);
		
		lay.addView(fullPost);
		
		goBack = new Button(this);
		goBack.setText(getString(R.string.Return));
		goBack.setLayoutParams(dimensions);
		lay.addView(goBack);
		
		goBack.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View view)
			{
				Intent i = new Intent(getApplicationContext(), HomeActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}