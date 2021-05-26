package com.group5.quizApp.Activities;
import android.view.*;
import com.group5.quizApp.*;
import java.util.*;

abstract public class App2
{
	View view;
	public MainActivity app;
	int id;
	protected static Stack<App2> back_stack = new Stack<App2>();
	private boolean reinitialized = true;
	
	public App2(MainActivity app, int id)
	{
		this.app = app;
		this.id = id;
	}
	
	public void setContentView()
	{
		if(reinitialized){
			view = inflater(id);
			app.setContentView(view);
			OnLoad(view);
			reinitialized = false;
		} else {
			app.setContentView(view);
		}
	}
	
	public void Refresh()
	{
		reinitialized = true;
	}
	
	protected View findView(int id)
	{
		return view.findViewById(id);
	}
	
	public void Navigate(App2 to){
		switchView(this, to);
	}
	
	public static void switchView(App2 from, App2 to)
	{
		back_stack.push(from);
		to.setContentView();
	}
	
	protected abstract void OnLoad(View view);
	
	public View inflater(int id)
	{
		return app.getLayoutInflater().inflate(id, null);
	}
	
	public static void back(MainActivity app)
	{
		if(back_stack.size() == 0){
			app.finish();
		} else {
			back_stack.pop().setContentView();
		}
	}
}
