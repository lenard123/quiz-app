package com.group5.quizApp.Models;
import java.util.*;
import android.database.*;

public class Course extends Model
{
	public int Id;
	public String Name;
	public String Description;
	
	public Course(int Id, String Name, String Description)
	{
		this.Id = Id;
		this.Name = Name;
		this.Description = Description;
	}
	
	public int LessonCount()
	{
		Cursor rs = GetDatabase().rawQuery("SELECT COUNT(*) FROM lessons WHERE course_id="+Id, null);
		rs.moveToFirst();
		return rs.getInt(0);
	}
	
	public static ArrayList<Course> GetAll()
	{
		ArrayList<Course> result = new ArrayList<Course>();
		Cursor rs = GetDatabase().rawQuery("SELECT * FROM courses", null);
		rs.moveToFirst();
		while(rs.isAfterLast() == false)
		{
			result.add(new Course(
				rs.getInt(0),
				rs.getString(1),
				rs.getString(2)
			));
			rs.moveToNext();
		}
		return result;
	}
	
}
