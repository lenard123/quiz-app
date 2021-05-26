package com.group5.quizApp;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.widget.*;
import com.group5.quizApp.Activities.*;
import com.group5.quizApp.Models.*;
import java.io.*;
import java.util.*;

public class MainActivity extends Activity 
{
	
	//public boolean at_home = false;
	//protected App active;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        createDatabase();
		App2 app = new HomeApp2(this);
		app.setContentView();
		//LoadApp(new Home(this));
    }

	/*public void LoadApp(App app)
	{
		//active = app;
		app.load();
	}*/

	public void Toaster(Object text)
	{
		Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show();
	}
	
	private void createDatabase()
	{
		// TODO: Implement this method
		try
		{
			Model._copydatabase(this);
		}
		catch (IOException e)
		{
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}
	
	
	public boolean canResolveIntent(Intent intent) {
		List<ResolveInfo> resolveInfo = getPackageManager().queryIntentActivities(intent, 0);
		return resolveInfo != null && !resolveInfo.isEmpty();
	}
	
	
	@Override
	public void onBackPressed()
	{
		//active.back();
		App2.back(this);
	}

	
}
