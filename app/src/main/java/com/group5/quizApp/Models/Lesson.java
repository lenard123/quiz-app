package com.group5.quizApp.Models;

import android.database.*;
import java.util.*;

public class Lesson extends Model
{
	public int id;
	public int course_id;
	public int islocked;
	public int score;
	public String name;
	public Course parent;
	
	public Lesson(Course parent, int id, String name, int islocked, int score)
	{
		this.id = id;
		this.course_id = parent.Id;
		this.name = name;
		this.parent = parent;
		this.islocked = islocked;
		this.score = score;
	}
	
	public int QuizCount(){
		Cursor rs = GetDatabase().rawQuery("SELECT COUNT(*) FROM quizzes WHERE lesson_id="+id, null);
		rs.moveToFirst();
		return rs.getInt(0);
	}
	
	public ArrayList<String> GetLessonImages()
	{
		ArrayList<String> result = new ArrayList<String>();
		Cursor rs = GetDatabase().rawQuery("SELECT * FROM lesson_images WHERE lesson_id="+id, null);
		rs.moveToFirst();
		while(rs.isAfterLast() == false)
		{
			result.add(rs.getString(2));
			rs.moveToNext();
		}
		return result;
	}
	
	public void UnLocked()
	{
		GetDatabase().execSQL("UPDATE `lessons` SET `islocked`=0 WHERE `id`="+id);
	}
	
	public void UpdateScore(int score)
	{
		GetDatabase().execSQL("UPDATE `lessons` SET `score`="+score+" WHERE `id`="+id);
	}
	
	
	public static Lesson GetNextLesson(Lesson current)
	{
		Lesson result = null;
		ArrayList<Lesson> lessons = getLessons(current.parent);
		for(int i = 0;i < lessons.size(); i++)
		{
			if(lessons.get(i).id == current.id){
				if(i != lessons.size()-1){
					result = lessons.get(i+1);
				}
			}
		}
		return result;
	}
	
	
	public static ArrayList<Lesson> getLessons(Course course)
	{
		ArrayList<Lesson> result = new ArrayList<Lesson>();
		Cursor rs = GetDatabase().rawQuery("SELECT * FROM lessons WHERE course_id = "+ course.Id,null);
		rs.moveToFirst();
		while(rs.isAfterLast() == false)
		{
			result.add(new Lesson(
				course,
				rs.getInt(0),
				rs.getString(2),
				rs.getInt(3),
				rs.getInt(4)
			));
			rs.moveToNext();
		}
		return result;
	}
	
}
