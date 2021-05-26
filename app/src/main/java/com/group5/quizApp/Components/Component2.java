package com.group5.quizApp.Components;
import android.view.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Activities.*;

abstract public class Component2
{
	protected MainActivity activity;
	protected App2 app;
	View view;
	
	public Component2(App2 app, int id)
	{
		this.app = app;
		this.activity = app.app;
		view = app.inflater(id);
	}
	
	protected View findView(int id)
	{
		return view.findViewById(id);
	}
	
	public View GetView()
	{
		OnLoad();
		return view;
	}
	
	public abstract void OnLoad();
}
