package com.teamgv.goodvibes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LocalNewsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local_news);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.local_news, menu);
		return true;
	}

}
