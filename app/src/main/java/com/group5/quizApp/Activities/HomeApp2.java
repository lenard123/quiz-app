package com.group5.quizApp.Activities;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.group5.quizApp.*;

public class HomeApp2 extends App2
{

	Button btnPlay;
	Button btnAbout;
	Button btnExit;
	Button btnVideo;
	Handler handler;
	
	public HomeApp2(MainActivity app)
	{
		super(app, R.layout.home);
	}
	
	@Override
	protected void OnLoad(View view)
	{
		handler = new Handler(this);
		btnPlay = (Button) findView(R.id.homeButton1);
		btnAbout = (Button) findView(R.id.homeButton2);
		btnExit = (Button) findView(R.id.homeButton3);
		btnVideo = (Button) findView(R.id.homeButton4);
		
		btnPlay.setOnClickListener(handler);
		btnAbout.setOnClickListener(handler);
		btnExit.setOnClickListener(handler);
		btnVideo.setOnClickListener(handler);
	}
	
	class Handler implements OnClickListener
	{

		HomeApp2 home_app;
	
		public Handler(HomeApp2 home_app){
			this.home_app = home_app;
		}
		
		@Override
		public void onClick(View p1)
		{
			if(p1 == btnPlay){
				home_app.Navigate(new CourseListApp2(app));
			} else if(p1 == btnAbout){
				home_app.Navigate(new AboutApp2(app));
			} else if(p1 == btnVideo){
				home_app.Navigate(new PlaylistApp2(app));
			} else if(p1 == btnExit){
				app.finish();
			}
		}
		
	}
	
}
