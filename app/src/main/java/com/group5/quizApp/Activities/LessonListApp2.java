package com.group5.quizApp.Activities;
import android.view.*;
import android.widget.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Models.*;
import java.util.*;
import com.group5.quizApp.Components.*;

public class LessonListApp2 extends App2
{
	Course course;
	
	public LessonListApp2(MainActivity app2, Course course)
	{
		super(app2, R.layout.lessons);
		this.course = course;
	}
	
	@Override
	protected void OnLoad(View view)
	{
		LinearLayout lessons_panel = (LinearLayout) findView(R.id.lessonsLinearLayout1);
		ArrayList<Lesson> lessons = Lesson.getLessons(course);
		for(int i = 0; i < lessons.size(); i++)
		{
			LessonComponent2 component = new LessonComponent2(this, lessons.get(i));
			lessons_panel.addView(component.GetView());
			//lessons_panel.addView(LessonComponent.CreateComponent(this, lessons.get(i)));
		}
	}
	
}
