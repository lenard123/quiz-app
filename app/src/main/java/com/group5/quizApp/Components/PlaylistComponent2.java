package com.group5.quizApp.Components;
import com.group5.quizApp.Activities.*;
import com.group5.quizApp.Models.*;
import com.group5.quizApp.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class PlaylistComponent2 extends Component2
{
	Playlist playlist;

	public PlaylistComponent2(App2 app, Playlist playlist)
	{
		super(app, R.layout.playlist_component);
		this.playlist = playlist;
	}
	
	@Override
	public void OnLoad()
	{
		TextView tv1 = (TextView) findView(R.id.playlistcomponentTextView1);
		TextView tv2 = (TextView) findView(R.id.playlistcomponentTextView2);
		Button btn1 = (Button) findView(R.id.playlistcomponentButton1);
		
		tv1.setText(playlist.name);
		tv2.setText(playlist.description);
		btn1.setOnClickListener(new Handler());
	}
	
	class Handler implements OnClickListener
	{
		@Override
		public void onClick(View p1)
		{
			app.Navigate(new VideoListApp2(app.app, playlist));
		}
	}
}
