package com.badlogic.androidgames;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class SoundPoolTest extends Activity implements OnTouchListener{
	SoundPool soundPool;
	int soundId = -1;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setOnTouchListener(this);
		setContentView(textView);
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		soundPool = new SoundPool(20,AudioManager.STREAM_MUSIC, 1);
		
		try
		{
			AssetManager assetManager = getAssets();
			AssetFileDescriptor descriptor = assetManager.openFd("boom_x.wav");
			soundId = soundPool.load(descriptor, 1);
		}
		catch(IOException e)
		{
			textView.setText("coundnt load sound effect because " + e.getMessage());
		}
	}
	
	public boolean onTouch(View view, MotionEvent event)
	{
		if(event.getAction() == MotionEvent.ACTION_UP)
		{
			if(soundId != -1)
			{
				soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f);
			}
		}
		return true;
	}

}
