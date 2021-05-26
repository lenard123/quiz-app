package com.group5.quizApp.Activities;
import android.view.*;
import android.widget.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Components.*;
import com.group5.quizApp.Models.*;
import java.util.*;

public class ResultListApp2 extends App2
{
	Lesson lesson;
	ArrayList<String> answers;
	ArrayList<Quiz> questions;
	
	public ResultListApp2(MainActivity app, Lesson lesson, ArrayList<String> answers)
	{
		super(app, R.layout.result);
		this.lesson = lesson;
		this.answers = answers;
		this.questions = Quiz.getQuizzes(lesson);
	}

	@Override
	protected void OnLoad(View view)
	{
		LinearLayout result_panel = (LinearLayout) findView(R.id.resultLinearLayout1);
		TextView score = (TextView) findView(R.id.resultTextView1);
		score.setText("You scored "+correctAnswer()+" out of "+ questions.size());
		for(int i = 0; i < answers.size(); i++)
		{
			result_panel.addView(ResultComponent.CreateComponent(app, questions.get(i), answers.get(i), i));
		}
		UpdateScore();
	}
	
	private void UpdateScore()
	{
		int hscore = lesson.score;

		if(correctAnswer() > hscore) {
			lesson.UpdateScore(correctAnswer());
			hscore = correctAnswer();
		}

		if(hscore*100/lesson.QuizCount() >= 50){
			Lesson next = Lesson.GetNextLesson(lesson);
			if(next != null){
				next.UnLocked();
			}
		}
		this.back_stack.peek().Refresh();
	}
	
	public int correctAnswer()
	{
		int j = 0;
		for(int i = 0; i < answers.size(); i++)
		{
			if(questions.get(i).check(answers.get(i))){
				j++;
			}
		}
		return j;
	}
}
