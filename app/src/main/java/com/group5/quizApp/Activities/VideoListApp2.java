package com.group5.quizApp.Activities;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Components.*;
import com.group5.quizApp.Models.*;
import java.util.*;

public class VideoListApp2 extends App2
{
	
	Playlist playlist;
	ArrayList<VideoItemComponent> initializedMap = new ArrayList<VideoItemComponent>();
	
	public VideoListApp2(MainActivity app, Playlist playlist)
	{
		super(app, R.layout.video_lists);
		this.playlist = playlist;
	}

	@Override
	protected void OnLoad(View view)
	{
		ArrayList<Video> videolists = playlist.getVideos();
		LinearLayout videos_panel = (LinearLayout) findView(R.id.videolistsLinearLayout1);
		ScrollView sv = (ScrollView) findView(R.id.videolistsScrollView1);
		sv.setOnScrollChangeListener(new OnScrollChangeListener(){

				@Override
				public void onScrollChange(View p1, int p2, int p3, int p4, int p5)
				{
					// TODO: Implement this method
					initialize();
				}
			});
			
		for(int i = 0; i < videolists.size(); i++)
		{
			VideoItemComponent component = new VideoItemComponent(app, videolists.get(i));
			videos_panel.addView(component.getView());
			//component.initialize();
			initializedMap.add(component);
		}
		initialize();
	}
	
	private void initialize()
	{
		for(int i = 0; i < initializedMap.size(); i++)
		{
			initializedMap.get(i).initialize(i);
		}
	}
	
	
}
