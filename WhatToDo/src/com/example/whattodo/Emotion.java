package com.example.whattodo;


//import android.R;
import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Emotion extends Activity {
	
	public static String op="";
	public static TestGesture t=new TestGesture();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		setContentView(R.layout.emotion);
		//super.onCreate();
		Log.i("itc ","itcame here");
	
		 String root = Environment.getExternalStorageDirectory().toString();
		 File myDir = new File(root + "/Data");
		File seqfilename=new File(myDir,"emotion.seq");
	
		
		
		try {
			op="";
			//t.train();
			
			//MainActivity.t.train();
			//op=MainActivity.TELEPHONY_SERVICE.
			op=MainActivity.t.test(seqfilename);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		//MainActivity m=new MainActivity();
		//String text=m.text;
		TextView info1;
		if(op.equalsIgnoreCase("Happy"))
		{
		info1=(TextView)findViewById(R.id.info1);
		info1.setText("You are Happy");
		ImageView i;
		i=(ImageView)findViewById(R.id.imageView2);
		i.setImageResource(R.drawable.happy);
		//m.text="Happy";
		Log.i("output", op);
		}
		
		else if(op.equalsIgnoreCase("Irritated"))
		{
		info1=(TextView)findViewById(R.id.info1);
		info1.setText("You are Irritated");
		ImageView i;
		i=(ImageView)findViewById(R.id.imageView2);
		i.setImageResource(R.drawable.irritated);
		//m.text="Happy";
		Log.i("output", op);
		}
		
		else if(op.equalsIgnoreCase("Sad"))
		{
		info1=(TextView)findViewById(R.id.info1);
		info1.setText("You are Sad");
		ImageView i;
		i=(ImageView)findViewById(R.id.imageView2);
		i.setImageResource(R.drawable.sad);
		//m.text="Happy";
		Log.i("output", op);
		}
		
		else if(op.equalsIgnoreCase("Worried"))
		{
		info1=(TextView)findViewById(R.id.info1);
		info1.setText("You are Worried");
		ImageView i;
		i=(ImageView)findViewById(R.id.imageView2);
		i.setImageResource(R.drawable.worried);
		//m.text="Happy";
		Log.i("output", op);
		}
		

		
		else if(op.equalsIgnoreCase("Angry"))
		{
		info1=(TextView)findViewById(R.id.info1);
		info1.setText("You are Angry");
		ImageView i;
		i=(ImageView)findViewById(R.id.imageView2);
		i.setImageResource(R.drawable.angry);
		//m.text="Happy";
		Log.i("output", op);
		}
		
		else
		{
		info1=(TextView)findViewById(R.id.info1);
		info1.setText("You are Sad0");
		ImageView i;
		i=(ImageView)findViewById(R.id.imageView2);
		i.setImageResource(R.drawable.sad);
		op="Sad";
		Log.i("output", op);
		}
		
		
		Button b2;

		b2=(Button)findViewById(R.id.button5);
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Emotion.this,SecondActivity.class);
				
				startActivity(intent);
				
			}
		});
		
		
		}
		

}
