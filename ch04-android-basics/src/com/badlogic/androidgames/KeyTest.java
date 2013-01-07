package com.badlogic.androidgames;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;

public class KeyTest extends Activity implements OnKeyListener {
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText("Press keys now...");
		textView.setOnKeyListener(this);
		textView.setFocusable(true);
		textView.requestFocus();
		setContentView(textView);
	}

	public boolean onKey(View v, int keyCode, KeyEvent event) {
		boolean validKey = true;
		builder.setLength(0);
		switch(event.getAction())
		{
			case KeyEvent.ACTION_DOWN: builder.append("Down, "); break;
			case KeyEvent.ACTION_UP: builder.append("up, "); break;
		}
		switch(event.getKeyCode())
		{
			case KeyEvent.KEYCODE_DPAD_CENTER: 
											builder.append("\"X\" key was pressed");
											break;
			case KeyEvent.KEYCODE_BACK: 
											if(event.isAltPressed())
											{
												builder.append("\"O\" key was pressed");
											}
											else
											{
												validKey = false;
											}
											break;
			case KeyEvent.KEYCODE_BUTTON_X:
											builder.append("\"Square\" key was pressed");
											break;
			case KeyEvent.KEYCODE_BUTTON_Y: 
											builder.append("\"Triangle\" key was pressed");
											break;
			case KeyEvent.KEYCODE_DPAD_UP: 
											builder.append("\"D-Pad up\" key was pressed");
											break;
			case KeyEvent.KEYCODE_DPAD_DOWN: 
											builder.append("\"D-Pad Down\" key was pressed");
											break;
			case KeyEvent.KEYCODE_DPAD_RIGHT: 
											builder.append("\"D-Pad Right\" key was pressed");
											break;
			case KeyEvent.KEYCODE_DPAD_LEFT: 
											builder.append("\"D-Pad Left\" key was pressed");
											break;
			case KeyEvent.KEYCODE_BUTTON_SELECT: 
											builder.append("\"Select\" key was pressed");
											break;
			case KeyEvent.KEYCODE_BUTTON_START: 
											builder.append("\"Start\" key was pressed");
											break;
			case KeyEvent.KEYCODE_BUTTON_L1: 
											builder.append("\"L1\" key was pressed");
											break;
			case KeyEvent.KEYCODE_BUTTON_R1: 
											builder.append("\"R1\" key was pressed");
											break;
			default: builder.append(event.getKeyCode());
		}
		
		builder.append(", ");
		builder.append((char)event.getUnicodeChar());
		String text = builder.toString();
		Log.d("KeyTest", text);
		textView.setText(text);
		
		return validKey;
	}

}
