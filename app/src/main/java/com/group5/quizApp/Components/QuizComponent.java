package com.group5.quizApp.Components;
import android.view.*;
import com.group5.quizApp.*;
import com.group5.quizApp.Models.*;
import android.view.View.*;
import android.widget.*;
import android.widget.LinearLayout.*;
import com.group5.quizApp.Activities.*;

public class QuizComponent extends Component
{

	View viewComponent;
	MainActivity activity;
	QuizTimeApp2 app;
	
	public static View CreateComponent(QuizTimeApp2 app, Quiz quiz, int i)
	{
		return (new QuizComponent(app, quiz, i)).getView();
	}
	
	public QuizComponent(final QuizTimeApp2 app, Quiz quiz, int i)
	{
		activity = app.app;
		this.app = app;
		String[] choices = quiz.choices.split(",");
		LayoutInflater inflater = activity.getLayoutInflater();
		if(choices.length > 1){
			View multipleChoice = inflater.inflate(R.layout.multiple_choice, null, true);
			LinearLayout buttons = (LinearLayout) multipleChoice.findViewById(R.id.multiplechoiceLinearLayout1);
			TextView questiontv = (TextView) multipleChoice.findViewById(R.id.multiplechoiceTextView1);
			questiontv.setText( (i+1) + ". " + quiz.question);
			
			for(int j =0; j< choices.length; j++)
			{
				buttons.addView(createButton(choices[j]));
			}
			
			viewComponent = multipleChoice;
		}
		else
		{
			View fill = inflater.inflate(R.layout.fill_in_blank, null);
			TextView questionTv = (TextView) fill.findViewById(R.id.fillinblankTextView1);
			final EditText et = (EditText) fill.findViewById(R.id.fillinblankEditText1);
			Button btn = (Button) fill.findViewById(R.id.fillinblankButton1);
			questionTv.setText((i+1)+". "+quiz.question);
			btn.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View p1)
					{
						// TODO: Implement this method
						app.addAnswer(et.getText().toString());
					}
				});
			viewComponent = fill;
		}
	}
	
	public Button createButton(final String text){
		Button nButton = new Button(activity);
		nButton.setText(text);
		
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.bottomMargin = 10;
		nButton.setLayoutParams(params);
		nButton.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					app.addAnswer(text);
				}
			});
		return nButton;
	}
	
	@Override
	public View getView()
	{
		// TODO: Implement this method
		return viewComponent;
	}
	
} 
