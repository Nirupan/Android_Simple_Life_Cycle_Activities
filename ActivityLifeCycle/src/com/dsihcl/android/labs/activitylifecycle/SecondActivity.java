/*****************************************************************************
 *
 * SecondActivity.java: Activity Life Cycle and Explicit Intents Lab
 *
 * Observe the usage of an Explicit Intent to launch the Third Activity.
 *
 *****************************************************************************
 */


// The package name that will uniquely identify your application
package com.dsihcl.android.labs.activitylifecycle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;


/**
 * The Class secondActivity.
 * @author shrey patel
 * @version 1.0
 */
public class SecondActivity extends Activity {
	
	TextView tv;
	boolean toastCreated = false;
	Toast myToast = null;
	private Button newActivityButton;

	/**
	* @param savedInstanceState Bundle Object to restore the previous variable 
	*			state
	* @see android.app.Activity#onCreate(android.os.Bundle)
	
      This method is called when the activity is first created. This is where
	you should do all of your normal static set up — create views, bind data 
	to lists, and so on. This method is passed a Bundle object containing the 
	activity's previous state, if that state was captured */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondmain);

		showToast("onCreate()");

		tv = (TextView)findViewById(R.id.SecondActivitytextView);
		newActivityButton = (Button) findViewById(R.id.SecondActivitybutton);
		newActivityButton.setText("Start Third Activity");

		newActivityButton.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
				// Creating Explicit Intent to launch the the ThirdActivity class
				Intent activityIntent = new Intent(getBaseContext(),
					FourthActivity.class);
			
				// startActivity: Launching Activity with Explicit Intent
				startActivity(activityIntent);
			}
		});


	}


	/* This method will be called just before the activity becomes visible 
	to the user.Followed by onResume() if the activity comes to the foreground
	or onStop() if it becomes hidden.
      */
	@Override
	protected void onStart() {
		super.onStart();
		showToast("onStart()");
	}

	/* This method will be Called just before the activity starts interacting 
	with the user. At this point the activity is at the top of the activity 
	stack, with user input going to it.Always followed by onPause() 
	*/
	@Override
	protected void onResume() {
		super.onResume();
		showToast("onResume()");
	}


	/* This method is called after the activity has been stopped, just prior 
	to it being started again.Always followed by onStart()
      */
	@Override
	protected void onRestart() {
		super.onRestart();
		showToast("onRestart()");
	}

	/* This method will be called when the system is about to start resuming 
	another activity. This method is typically used to commit unsaved changes
	to persistent data, stop animations and other things that may be consuming
	CPU and so on. It should do whatever it does very quickly, because the 
	next activity will not be resumed until it returns. */
	@Override
	protected void onPause() {
		super.onPause();
		showToast("onPause()");
	}

	/* This method is called when the activity is no longer visible to the 
	user.This may happen because it is being destroyed, or because another 
	activity, either an existing one or a new one, has been resumed and is 
	covering it.
	*/
	@Override
	protected void onStop() {
		super.onStop();
		showToast("onStop()");
	}

	/* This method is called before the activity is destroyed. This is the 
	final call that the activity will receive. It could be called either 
	because the activity is finishing, someone called finish() on it, or 
	because the system is temporarily destroying this instance of the activity
	to save space.
	*/
	@Override
	protected void onDestroy() {
		super.onDestroy();
		showToast("onDestroy()");
	}

	/* This user defined method is used to set the Text to be displayed on 
	the screen.Here in this program it is called by the each activity state 
	callback method to display the status message on the screen according to
	the activity state
	*/
	private void showToast (CharSequence text) {
		text = "Second Activity: "+text;
		if (this.toastCreated == false) {
			Context context = getApplicationContext();
			int duration = Toast.LENGTH_SHORT;
			myToast = Toast.makeText(context, text, duration);
			myToast.setGravity(Gravity.TOP, 20, 250);
			myToast.show();
		} else {
			myToast.setText(text);
			myToast.show();
		}
	}

}
