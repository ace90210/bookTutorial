package com.badlogic.androidgames;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AccelerometerTest extends Activity implements SensorEventListener{
	StringBuilder builder = new StringBuilder();
	TextView textView;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		setContentView(textView);
		
		SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if(manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() == 0)
		{
			textView.setText("No Accelerometre found");
		}
		else
		{
			Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			if(!manager.registerListener(this, accelerometer,SensorManager.SENSOR_DELAY_GAME))
			{
				textView.setText("couldn't register sensor listener");
			}
		}
	}
	
	public void onSensorChanged(SensorEvent event)
	{
		builder.setLength(0);
		builder.append("x: ");
		builder.append(event.values[0]);
		builder.append("\ny: ");
		builder.append(event.values[1]);		
		builder.append("\nz: ");
		builder.append(event.values[2]);
		textView.setText(builder.toString());
	}
	
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		//nothing needed to do
	}
}
