package com.badlogic.androidgames;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;

public class AndroidBasicStarter extends ListActivity {
	
	String tests[] = { "LifeCycleTest", "SingleTouchTest", "MultiTouchTest", "KeyTest", "AccelerometerTest",
								"AssetsTest", "ExternalStorageTest", "SoundPoolTest", "MediaPlayerTest", "FullScreenTest",
								"RenderViewTest", "ShapeTest", "BitmapTest", "FontTest", "SurfaceViewTest"
					 };

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
		
	}

	 
	@Override
	public void onListItemClick(ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);
		String testName = tests[position];
		try
		{
			
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName("com.badlogic.androidgames." + testName);
			Intent intent = new Intent(this, clazz);
			startActivity(intent);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
