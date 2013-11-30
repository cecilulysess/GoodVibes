package com.teamgv.goodvibes;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreatePostActivity extends Activity {
	private static final int CAMERA_REQUEST = 1888; 
    private ImageView imageView;
    private EditText title;
    private EditText content;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_post);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		this.title = (EditText) this.findViewById(R.id.editText1);
		this.content = (EditText) this.findViewById(R.id.editText2);
		this.imageView = (ImageView)this.findViewById(R.id.imageView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.create_post, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.action_post:
			if (this.title.length() < 1) { 
				Toast warn = Toast.makeText(this, "Must have a title", Toast.LENGTH_SHORT);
				warn.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 50);
				warn.show();
				return false;
			}
			Toast.makeText(this, "You have created a post\nTitle: " 
								+ this.title.getText() + "\nContent:\n" + this.content.getText(),
								Toast.LENGTH_LONG).show();
			
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
	
    public void takePhotoCamera(View v)
    {
    	Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
        startActivityForResult(cameraIntent, CAMERA_REQUEST); 
    }
    
    public void pickFromGallery(View v) {
		Toast.makeText(this, "That was really awesom, isn't that?", Toast.LENGTH_LONG).show();
	}
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
            imageView.setImageBitmap(photo);
        }  
    } 
    
    public void DebugVar(){
    	Log.d("Post", this.title.getText() + ": " + this.content.getText());
    }
}
