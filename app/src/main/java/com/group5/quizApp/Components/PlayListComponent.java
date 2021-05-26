package com.group5.quizApp.Components;
import android.view.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Models.*;
import android.widget.*;
import android.view.View.*;
import com.group5.quizApp.Activities.*;

public class PlayListComponent
{
	View view;
	public PlayListComponent(final App2 app, final Playlist data)
	{
		view = app.inflater(R.layout.playlist_component);
		TextView tv1 = (TextView) view.findViewById(R.id.playlistcomponentTextView1);
		TextView tv2 = (TextView) view.findViewById(R.id.playlistcomponentTextView2);
		Button btn1 = (Button) view.findViewById(R.id.playlistcomponentButton1);
		
		tv1.setText(data.name);
		tv2.setText(data.description);
		btn1.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					//app.LoadApp(new VideoListApp(app, data));
					app.Navigate(new VideoListApp2(app.app, data));
				}
			});
	}
	
	public View getView()
	{
		return view;
	}
	
	public static View CreateComponent(App2 app, Playlist data)
	{
		return (new PlayListComponent(app, data)).getView();
	}
}
