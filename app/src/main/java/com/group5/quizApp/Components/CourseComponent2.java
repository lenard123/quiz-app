package com.group5.quizApp.Components;

import com.group5.quizApp.Models.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Activities.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class CourseComponent2 extends Component2
{
	
	Course course;
	
	public CourseComponent2(App2 app, Course course){
		super(app, R.layout.course_component);
		this.course = course;
	}

	@Override
	public void OnLoad()
	{
		TextView name = (TextView) findView(R.id.coursecomponentTextViewName);
		TextView desc = (TextView) findView(R.id.coursecomponentTextViewDescription);
		TextView prog = (TextView) findView(R.id.coursecomponentTextViewProgress);
		Button button = (Button) findView(R.id.coursecomponentButton1);
		
		name.setText(course.Name);
		prog.setText(course.LessonCount() + " Lessons");
		desc.setText(course.Description);
		button.setOnClickListener(new Handler());
	}
	
	public class Handler implements OnClickListener
	{
		@Override
		public void onClick(View p1)
		{
			// TODO: Implement this method
			app.Navigate(new LessonListApp2(activity, course));
		}
	}
	
}
