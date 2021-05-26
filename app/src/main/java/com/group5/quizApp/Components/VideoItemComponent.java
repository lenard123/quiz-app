package com.group5.quizApp.Components;
import android.content.*;
import android.graphics.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.ImageView.*;
import com.google.android.youtube.player.*;
import com.google.android.youtube.player.YouTubeThumbnailLoader.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Models.*;

import android.view.View.OnClickListener;
import android.view.View.OnScrollChangeListener;
import android.content.res.*;
public class VideoItemComponent
{
	View view;
	YouTubeThumbnailView thumbnail;
	ScrollView scrollview;
	private static final int REQ_START_STANDALONE_PLAYER = 1;
	private static final int REQ_RESOLVE_SERVICE_MISSING = 2;
	MainActivity app;
	boolean has_initialized = false;
	
	public VideoItemComponent(final MainActivity app, final Video data)
	{
		this.app = app;
		view = app.getLayoutInflater().inflate(R.layout.video_item, null);
		TextView tv = (TextView) view.findViewById(R.id.videoitemTextView1);
		scrollview = (ScrollView) app.findViewById(R.id.videolistsScrollView1);
		thumbnail = (YouTubeThumbnailView) view.findViewById(R.id.videoitemYouTubeThumbnailView1);
		thumbnail.setTag(data.key);
		
		thumbnail.setScaleType(ScaleType.FIT_CENTER);
		tv.setText(data.name);
		
		Button btn = (Button) view.findViewById(R.id.videoitemButton1);
		btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					Intent intent = YouTubeStandalonePlayer.createVideoIntent(
						app,
						Config.YOUTUBE_API_KEY,
						data.key,
						0,
						true,
						true);
					if (app.canResolveIntent(intent)) {
						app.startActivityForResult(intent, REQ_START_STANDALONE_PLAYER);
					} else {
						// Could not resolve the intent - must need to install or update the YouTube API service.
						YouTubeInitializationResult.SERVICE_MISSING
							.getErrorDialog(app, REQ_RESOLVE_SERVICE_MISSING).show();
					}
					//app.LoadApp(new VideoPlayer(app, data));
				}
			});
			
		
	}
	
	public void initialize(int i)
	{
		//app.Toaster("You should see me");
		if(has_initialized == false)
		{
			if(isVisible(view, scrollview) || i == 0){
			thumbnail.initialize(Config.YOUTUBE_API_KEY, new ThumbnailListener());
			has_initialized = true;
			}
		}
	}
	
	public static boolean isVisible(final View view, ScrollView sv) {
		if (view == null) {
			return false;
		}
		if (!view.isShown()) {
			return false;
		}
		final Rect svBounds = new Rect();
		//final Rect actualPosition = new Rect();
		//final Rect screen = Util.GetScreenRect();
		//view.getGlobalVisibleRect(actualPosition);
		sv.getHitRect(svBounds);
		return view.getLocalVisibleRect(svBounds);// || actualPosition.intersect(screen);
		//view.getGlobalVisibleRect(actualPosition);
		
		
		
	}
	
	
	public View getView()
	{
		return view;
	}

	private final class ThumbnailListener implements
	YouTubeThumbnailView.OnInitializedListener,
	YouTubeThumbnailLoader.OnThumbnailLoadedListener {

		@Override
		public void onInitializationSuccess(
			YouTubeThumbnailView view, YouTubeThumbnailLoader loader) {
			loader.setOnThumbnailLoadedListener(this);
			//thumbnailViewToLoaderMap.put(view, loader);
			view.setImageResource(R.drawable.loading_thumbnail);
			String videoId = (String) view.getTag();
			loader.setVideo(videoId);
		}

		@Override
		public void onInitializationFailure(
			YouTubeThumbnailView view, YouTubeInitializationResult loader) {
			view.setImageResource(R.drawable.no_thumbnail);
		}

		@Override
		public void onThumbnailLoaded(YouTubeThumbnailView view, String videoId) {
		}

		@Override
		public void onThumbnailError(YouTubeThumbnailView view, ErrorReason errorReason) {
			view.setImageResource(R.drawable.no_thumbnail);
		}
    }
	
	public static View CreateComponent(MainActivity app, Video data)
	{
		return(new VideoItemComponent(app, data)).getView();
	}
}
