package com.group5.quizApp.Components;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Models.*;

public class ResultComponent
{
	MainActivity app;
	Quiz quiz;
	String answer;
	View view;
	TextView tv1;
	TextView tv2;
	TextView tv3;

	public ResultComponent(MainActivity app, Quiz quiz, String answer, int i)
	{
		this.app = app;
		this.quiz = quiz;
		this.answer = answer;
		view = app.getLayoutInflater().inflate(R.layout.result_item, null);
		tv1 = (TextView) view.findViewById(R.id.resultitemTextView1);
		tv2 = (TextView) view.findViewById(R.id.resultitemTextView2);
		tv3 = (TextView) view.findViewById(R.id.resultitemTextView3);
		
		tv1.setText((i+1)+". " + quiz.question);
		tv2.setText(answer);
		tv3.setText(quiz.answer);

		if(answer.length()==0){
			tv2.setText("(No answer)");
		}
		
		if(quiz.check(answer)){
			tv2.setTextColor(Color.GREEN);
		}
		else{
			tv2.setTextColor(Color.RED);
		}
	}
	
	public View getView()
	{
		return view;
	}
	
	public static View CreateComponent(MainActivity app, Quiz quiz, String answer, int i)
	{
		return (new ResultComponent(app, quiz, answer, i)).getView();
	}
}
