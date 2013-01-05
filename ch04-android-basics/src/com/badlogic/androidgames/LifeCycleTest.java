package com.badlogic.androidgames;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

public class LifeCycleTest extends Activity {
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	private void log(String text)
	{
		Log.d("LifeCycleText", text);
		builder.append(text);
		builder.append('\n');
		textView.setText(builder.toString());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText(builder.toString());
		setContentView(textView);
		log("created");
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		log("resumed");
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		log("Paused");
		
		if(isFinishing())
		{
			log("finishing");
		}
	}

}
