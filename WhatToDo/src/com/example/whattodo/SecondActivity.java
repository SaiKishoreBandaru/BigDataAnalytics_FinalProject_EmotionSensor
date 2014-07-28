 package com.example.whattodo; 


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends Activity implements OnClickListener{
	Button kidsButton , studentButton , proffButton;
	String emotion="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);	

		setContentView(R.layout.genre);

		kidsButton = (Button)findViewById(R.id.kids_lay);
		studentButton =(Button)findViewById(R.id.students_lay);
		proffButton = (Button)findViewById(R.id.profe_lay);

		kidsButton.setOnClickListener(this);
		studentButton.setOnClickListener(this);
		proffButton.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//SecondActivity m=new SecondActivity();
		String emotion = Emotion.op;
		if (emotion.equalsIgnoreCase("Happy"))
		{
		switch (v.getId()) {
		case R.id.kids_lay:

			Intent intent =new Intent(SecondActivity.this, MapNewActivity.class);
			intent.putExtra("PLACE_POSIT", 3);
			startActivity(intent);
			break;
		case R.id.students_lay:

			Intent intent1 =new Intent(SecondActivity.this, MapNewActivity.class);
			intent1.putExtra("PLACE_POSIT", 0);

			startActivity(intent1);
			break;
		case R.id.profe_lay:

			Intent intent2 =new Intent(SecondActivity.this, MapNewActivity.class);
			intent2.putExtra("PLACE_POSIT", 1);

			startActivity(intent2);
			break;

		default:
			break;
		}
	}

	
	else if (emotion.equalsIgnoreCase("Sad"))
	{
	switch (v.getId()) {
	case R.id.kids_lay:

		Intent intent =new Intent(SecondActivity.this, MapNewActivity.class);
		intent.putExtra("PLACE_POSIT", 2);
		startActivity(intent);
		break;
	case R.id.students_lay:

		Intent intent1 =new Intent(SecondActivity.this, MapNewActivity.class);
		intent1.putExtra("PLACE_POSIT", 4);

		startActivity(intent1);
		break;
	case R.id.profe_lay:

		Intent intent2 =new Intent(SecondActivity.this, MapNewActivity.class);
		intent2.putExtra("PLACE_POSIT", 3);

		startActivity(intent2);
		break;

	default:
		break;
	}
}
	else if (emotion.equalsIgnoreCase("Worried"))
	{
	switch (v.getId()) {
	case R.id.kids_lay:

		Intent intent =new Intent(SecondActivity.this, MapNewActivity.class);
		intent.putExtra("PLACE_POSIT", 3);
		startActivity(intent);
		break;
	case R.id.students_lay:

		Intent intent1 =new Intent(SecondActivity.this, MapNewActivity.class);
		intent1.putExtra("PLACE_POSIT", 4);

		startActivity(intent1);
		break;
	case R.id.profe_lay:

		Intent intent2 =new Intent(SecondActivity.this, MapNewActivity.class);
		intent2.putExtra("PLACE_POSIT", 4);

		startActivity(intent2);
		break;

	default:
		break;
	}
}
	else if (emotion.equalsIgnoreCase("Irritated"))
	{
	switch (v.getId()) {
	case R.id.kids_lay:

		Intent intent =new Intent(SecondActivity.this, MapNewActivity.class);
		intent.putExtra("PLACE_POSIT", 3);
		startActivity(intent);
		break;
	case R.id.students_lay:

		Intent intent1 =new Intent(SecondActivity.this, MapNewActivity.class);
		intent1.putExtra("PLACE_POSIT", 2);

		startActivity(intent1);
		break;
	case R.id.profe_lay:

		Intent intent2 =new Intent(SecondActivity.this, MapNewActivity.class);
		intent2.putExtra("PLACE_POSIT", 1);

		startActivity(intent2);
		break;

	default:
		break;
	}
}
	else if (emotion.equalsIgnoreCase("Angry"))
	{
	switch (v.getId()) {
	case R.id.kids_lay:

		Intent intent =new Intent(SecondActivity.this, MapNewActivity.class);
		intent.putExtra("PLACE_POSIT", 2);
		startActivity(intent);
		break;
	case R.id.students_lay:

		Intent intent1 =new Intent(SecondActivity.this, MapNewActivity.class);
		intent1.putExtra("PLACE_POSIT", 3);

		startActivity(intent1);
		break;
	case R.id.profe_lay:

		Intent intent2 =new Intent(SecondActivity.this, MapNewActivity.class);
		intent2.putExtra("PLACE_POSIT", 0);

		startActivity(intent2);
		break;

	default:
		break;
	}
}

	}
}
