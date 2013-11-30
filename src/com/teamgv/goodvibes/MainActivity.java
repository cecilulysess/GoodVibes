package com.teamgv.goodvibes;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tabHost = getTabHost();
		setTabs();
		
		
	}

	private void setTabs()
	{
		addTab("Home", R.drawable.tab_home, HomeActivity.class);
		addTab("Local", R.drawable.tab_local_news, LocalNewsActivity.class);
		addTab("Fake", R.drawable.tab_local_news, LocalNewsActivity.class);
		addTab("Profile", R.drawable.tab_profile, ProfileActivity.class);
		addTab("About", R.drawable.tab_about, AboutActivity.class);
		tabHost.getTabWidget().getChildAt(2).setFocusable(false);
		tabHost.getTabWidget().getChildAt(2).setActivated(false);
	}
	private void addTab(String labelId, int drawableId, Class<?> c)
	{
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);	
		
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);		
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}
	
	public void openCreatePostActivity(View b)
	{
		Intent intent = new Intent(this, CreatePostActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}

}
