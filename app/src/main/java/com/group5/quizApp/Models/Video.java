package com.group5.quizApp.Models;

public class Video extends Model
{
	public int id;
	public int playlist_id;
	public String name;
	public String key;
	public Playlist parent;
	
	public Video(Playlist parent, int id, String name, String key)
	{
		this.parent = parent;
		this.id = id;
		this.playlist_id = parent.id;
		this.name = name;
		this.key = key;
	}
	
}
