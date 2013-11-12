package com.teamgv.goodvibes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class CreatePostActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_post);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_post, menu);
		return true;
	}
	
    public void takePhotoCamera(View v)
    {
    	Toast.makeText(this, "ohhhhh, That is swearly cooool..\nHow did you do that?? O_o ", Toast.LENGTH_LONG).show();
    }
    public void pickFromGallery(View v) {
		Toast.makeText(this, "That was really awesom, isn't that?", Toast.LENGTH_LONG).show();
	}

}
