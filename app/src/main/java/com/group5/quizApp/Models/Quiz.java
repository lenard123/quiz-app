package com.group5.quizApp.Models;
import java.util.*;
import android.database.*;

public class Quiz extends Model
{
	public int id;
	public int lesson_id;
	public String question;
	public String choices;
	public String answer;
	public Lesson parent;
	
	public Quiz(Lesson parent, int id, String question,String answer, String choices )
	{
		this.id = id;
		this.lesson_id = parent.id;
		this.question = question;
		this.answer = answer;
		this.choices = choices;
		this.parent = parent;
	}
	
	public boolean check(String answer)
	{
		answer = answer.trim().toUpperCase();
		String correct = this.answer.trim().toUpperCase();
		return correct.equals(answer);
	}
	
	public static ArrayList<Quiz> getQuizzes(Lesson lesson)
	{
		ArrayList<Quiz> result = new ArrayList<Quiz>();
		Cursor rs = GetDatabase().rawQuery("SELECT * FROM quizzes WHERE lesson_id="+lesson.id, null);
		rs.moveToFirst();
		while(rs.isAfterLast() == false)
		{
			result.add(new Quiz(
				lesson,
				rs.getInt(0),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4)
			));
			rs.moveToNext();
		}
		return result;
	}
}
