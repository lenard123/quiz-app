package com.group5.quizApp.Activities;
import android.view.*;
import com.group5.quizApp.*;
import java.util.*;
import com.group5.quizApp.Models.*;
import android.widget.*;
import com.group5.quizApp.Components.*;

public class PlaylistApp2 extends App2
{
	
	public PlaylistApp2(MainActivity app)
	{
		super(app, R.layout.video_playlist);
	}

	@Override
	protected void OnLoad(View view)
	{
		ArrayList<Playlist> playlists = Playlist.getAll();
		LinearLayout playlist_panel = (LinearLayout) findView(R.id.videoplaylistLinearLayout1);
		for(int i = 0; i < playlists.size();i++){
			playlist_panel.addView(PlayListComponent.CreateComponent(this, playlists.get(i)));
		}
	}
	
}
