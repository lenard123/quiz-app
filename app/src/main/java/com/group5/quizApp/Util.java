package com.group5.quizApp;

import android.content.res.*;
import android.graphics.*;

public class Util
{
	private static Rect screenRect = null;
	public static Rect GetScreenRect()
	{
		if(screenRect == null){
			screenRect = new Rect(0, 0, Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().widthPixels);
		}
		return screenRect;
	}
}
