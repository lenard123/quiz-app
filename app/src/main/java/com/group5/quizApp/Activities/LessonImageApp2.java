package com.group5.quizApp.Activities;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.support.v4.view.*;
import android.view.*;
import android.widget.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Components.*;
import com.group5.quizApp.Models.*;
import java.io.*;
import java.util.*;

public class LessonImageApp2 extends App2
{
	Lesson lesson;
	
	public LessonImageApp2(MainActivity app, Lesson lesson)
	{
		super(app,R.layout.lesson_image);
		this.lesson = lesson;
	}
	
	@Override
	protected void OnLoad(View view)
	{
		ArrayList<String> images = lesson.GetLessonImages();
		ViewPager pager = (ViewPager) findView(R.id.lessonimageViewPager1);
		PagerAdapter adapter = new CustomPagerAdapter(app, images);
		pager.setAdapter(adapter);
	}
	
	class CustomPagerAdapter extends PagerAdapter
	{

		Context mcontext;
		LayoutInflater layoutinflater;
		ArrayList<String> resources;
		AssetManager asset;

		public CustomPagerAdapter(Context mcontext, ArrayList<String> resources)
		{
			this.mcontext = mcontext;
			this.resources = resources;
			this.asset = mcontext.getAssets();
			layoutinflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount()
		{
			// TODO: Implement this method
			return resources.size();
		}

		@Override
		public boolean isViewFromObject(View p1, Object p2)
		{
			// TODO: Implement this method
			return p1 == ((LinearLayout) p2);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{
			// TODO: Implement this method
			View itemView = layoutinflater.inflate(R.layout.image,container,false);
			try{
				ZoomableImageView iv = (ZoomableImageView) itemView.findViewById(R.id.imageView1);
				InputStream is = asset.open("images/"+resources.get(position));
				Drawable d = Drawable.createFromStream(is, null);
				Bitmap bmp = ((BitmapDrawable) d).getBitmap();
				iv.setImageBitmap(bmp);
				//iv.setImageDrawable(BitmapDrawable.createFromStream(is, "name").get);
				//iv.setImageBitmap(d.);
				//Picasso.with(mcontext);//load(asset.open("images"+resources.get(position))).into(iv);


			}catch(Exception e){
				Toast.makeText(app,e.getMessage(),Toast.LENGTH_SHORT).show();
			}
			container.addView(itemView);
			return itemView;
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			// TODO: Implement this method
			container.removeView((LinearLayout) object);
		}
	}
}
