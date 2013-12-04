package com.teamgv.goodvibes;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import android.widget.TextView;
import android.widget.Toast;

public class CreatePostActivity extends Activity implements LocationListener{
	private static final int CAMERA_REQUEST = 1888; 
    private ImageView imageView;
    private EditText title;
    private EditText content;
    private TextView location;
    private LocationManager mLocationManager;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_post);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		this.title = (EditText) this.findViewById(R.id.editText1);
		this.content = (EditText) this.findViewById(R.id.editText2);
		this.imageView = (ImageView)this.findViewById(R.id.imageView1);
		mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

	    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000,
	            0, this);
	    location = (TextView) this.findViewById(R.id.textView2);
	    Location loc = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	    String city = "";
	    
	    Geocoder gcd = new Geocoder(this, Locale.getDefault());
	    List<Address> addresses;
		try {
			addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
		    if (addresses.size() > 0) 
		    	city = addresses.get(0).getLocality() + "@";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception err) {
			city = "Location Services Not Available";
		}
		
		location.setText(city); // + loc.getLatitude() + ", " + loc.getLongitude());
	    	
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
								+ this.title.getText() + "\nContent:\n" + this.content.getText()
								+ "\nAt location: " + this.location.getText(),
								Toast.LENGTH_LONG).show();
			
		default:
			return super.onOptionsItemSelected(item);
		}
		
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
    
    @Override
    public void onLocationChanged(final Location location) {
    	String city = "";
	    
	    Geocoder gcd = new Geocoder(this, Locale.getDefault());
	    List<Address> addresses;
		try {
			addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
		    if (addresses.size() > 0) 
		    	city = addresses.get(0).getLocality() + " @ ";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.location.setText(city); // + location.getLatitude() + ", " + location.getLongitude());
    }

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
	}
}
