package com.group5.quizApp.Activities;
import android.view.*;
import android.widget.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Components.*;
import com.group5.quizApp.Models.*;
import java.util.*;

public class QuizTimeApp2 extends App2
{
	Lesson lesson;
	ArrayList<Quiz> quiz;
	ArrayList<String> answer = new ArrayList<String>();
	LinearLayout quiz_panel;
	ProgressBar progress;
	
	public QuizTimeApp2(MainActivity app, Lesson lesson){
		super(app, R.layout.quiz);
		this.lesson = lesson;
	}
	
	@Override
	protected void OnLoad(View view)
	{
		quiz = Quiz.getQuizzes(lesson);
		quiz_panel = (LinearLayout) findView(R.id.quizLinearLayout1);
		progress = (ProgressBar) findView(R.id.quizProgressBar1);
		nextQuestion();
	}
	
	private void nextQuestion()
	{
		if(answer.size() == quiz.size())
		{
			(new ResultListApp2(app, lesson, answer)).setContentView();
			//app.Result(quiz, answer);
			//app.LoadApp(new ResultList(app, lesson, answer));
		}
		else
		{
			progress.setProgress(answer.size()*100/quiz.size());
			quiz_panel.removeAllViews();
			quiz_panel.addView(QuizComponent.CreateComponent(this, quiz.get(answer.size()), answer.size()));
		}
	}
	public void addAnswer(String answer)
	{
		this.answer.add(answer);
		nextQuestion();
	}
}
