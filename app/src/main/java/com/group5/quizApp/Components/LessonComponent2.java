package com.group5.quizApp.Components;

import android.view.*;
import android.widget.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Activities.*;
import com.group5.quizApp.Models.*;
import android.view.View.*;

public class LessonComponent2 extends Component2
{

	Lesson lesson;
	TextView name, score;
	Button btn1, btn2;
	LinearLayout ll1, ll2;
	Handler handler;
	
	public LessonComponent2(App2 app, Lesson lesson)
	{
		super(app, R.layout.lesson_component);
		this.lesson = lesson;
	}
	
	@Override
	public void OnLoad()
	{
		name = (TextView) findView(R.id.lessoncomponentTextView1);
		score = (TextView) findView(R.id.lessoncomponentTextView2);
		ll1 = (LinearLayout) findView(R.id.lessoncomponentLinearLayout1);
		ll2 = (LinearLayout) findView(R.id.lessoncomponentLinearLayout2);
		btn1 = (Button) findView(R.id.lessoncomponentButton1);
		btn2 = (Button) findView(R.id.lessoncomponentButton2);
		handler = new Handler();
		
		if(lesson.islocked == 1){
			ll1.setVisibility(View.GONE);
			ll2.setVisibility(View.VISIBLE);
		} else {
			ll2.setVisibility(View.GONE);
			ll1.setVisibility(View.VISIBLE);
		}
		
		score.setText(lesson.score +"/"+lesson.QuizCount());
		name.setText(lesson.name);
		btn1.setOnClickListener(handler);
		btn2.setOnClickListener(handler);
	}
	
	class Handler implements OnClickListener
	{

		@Override
		public void onClick(View p1)
		{
			if(p1 == btn1){
				app.Navigate(new QuizTimeApp2(app.app, lesson));
			} else if(p1 == btn2){
				app.Navigate(new LessonImageApp2(app.app, lesson));
			}
		}
		
		
	}
	
}
