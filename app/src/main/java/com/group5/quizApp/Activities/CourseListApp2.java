package com.group5.quizApp.Activities;
import android.view.*;
import android.widget.*;
import com.group5.quizApp.*;
import java.util.*;
import com.group5.quizApp.Models.*;
import com.group5.quizApp.Components.*;

public class CourseListApp2 extends App2
{
	public CourseListApp2(MainActivity app)
	{
		super(app, R.layout.main);
	}

	@Override
	protected void OnLoad(View view)
	{
		LinearLayout course_panel = (LinearLayout) findView(R.id.mainLinearLayout1);
		ArrayList<Course> courses = Course.GetAll();
		for(int i = 0; i < courses.size(); i++){
			View component = (new CourseComponent2(this, courses.get(i))).GetView();
			course_panel.addView(component);
			//course_panel.addView(CourseComponent.CreateCourseComponent(this, courses.get(i)));
		}
	}
	
}
