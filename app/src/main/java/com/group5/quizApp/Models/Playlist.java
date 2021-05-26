package com.group5.quizApp.Models;
import android.database.*;
import java.util.*;

public class Playlist extends Model
{
	public int id;
	public String name;
	public String description;
	
	public Playlist(int id, String name, String description)
	{
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public ArrayList<Video> getVideos()
	{
		ArrayList<Video> videos = new ArrayList<Video>();
		Cursor rs = GetDatabase().rawQuery("SELECT * FROM videos WHERE playlist_id="+id, null);
		rs.moveToFirst();
		while(rs.isAfterLast() == false){
			videos.add(new Video(
				this, 
				rs.getInt(0),
				rs.getString(2),
				rs.getString(3)
			));
			rs.moveToNext();
		}
		return videos;
	}
	
	public static ArrayList<Playlist> getAll()
	{
		ArrayList<Playlist> result = new ArrayList<Playlist>();
		Cursor rs = GetDatabase().rawQuery("SELECT * FROM playlists", null);
		rs.moveToFirst();
		while(rs.isAfterLast() == false)
		{
			result.add(new Playlist(
				rs.getInt(0),
				rs.getString(1), 
				rs.getString(2)
			));
			rs.moveToNext();
		}
		return result;
	}
	
}
