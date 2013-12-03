package com.teamgv.goodvibes;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		Button newPicButton = (Button)findViewById(R.id.button1);
        newPicButton.setOnClickListener(btnListener);
        
	}

	private OnClickListener btnListener = new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Uri uriUrl = Uri.parse("http://hccdesigngoodvibes.wordpress.com");
	        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
	        startActivity(launchBrowser);
		} 

    };  
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

}
