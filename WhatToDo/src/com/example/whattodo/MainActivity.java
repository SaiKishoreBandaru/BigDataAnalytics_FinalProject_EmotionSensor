package com.example.whattodo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


//import com.example.sample.ConnectionService;


//import android.R;
import android.os.AsyncTask;
import android.app.Activity;
import android.app.Fragment;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	   public String emotion="";
	   String text="";
	   public static TestGesture t=new TestGesture();
	   
	   TextView info,s;
	 public static ConnectionService c=new ConnectionService();
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//super.onCreate();
		
		//s.setText("Initializing......");
	t.train();
	//TextView s;
	s=(TextView)findViewById(R.id.it);
	s.setText("Start");
		Log.i("itc ","itcame here");
		BluetoothManager manager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
       c.mBluetoothAdapter = manager.getAdapter();
        c.mDevices = new SparseArray<BluetoothDevice>();
		if (savedInstanceState == null) {
			//getFragmentManager().beginTransaction()
					//.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		Button b3,b2;
	 //button 3 start
		//button2 detect
		//button1 end
		b2=(Button)findViewById(R.id.button1);
		b2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			c.stopScan();
//				/c.SaveData(c.temp);
				
				
			}
		});

		
		
		 
			b2=(Button)findViewById(R.id.button3);
			b2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//c.startScan();
				
					startService(new Intent(MainActivity.this,ConnectionService.class));
					
				}
			});
		
			

			b2=(Button)findViewById(R.id.button4);
			b2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					Intent intent = new Intent(MainActivity.this, Report.class);
			        startActivity(intent);
					
				}
			});
		
		
		b3 = (Button)findViewById(R.id.button2);
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*WebView webview = new WebView(MainActivity.this);
				 setContentView(webview);
				 webview.loadUrl("http://134.193.136.147:8080/HbaseWS/jaxrs/generic/hbaseRetrieveAll/CRUD");
*/
				
				/*new Thread(new Runnable()
				{

				@Override
				public void run() {
					// TODO Auto-generated method stub
					//String url ="http://134.193.136.127:8983/solr/collection1_shard1_replica1/select?q=state_s%3AAL&rows=100&wt=json&indent=true";
					String url = "http://134.193.136.147:8080/HMMWS/jaxrs/generic/HMMTrainingTest/-home-group8-Stomp.seq:-home-group8-Facepalm.seq/stomp:facepalm/-home-group8-emotion.seq";
					
					BackgroundTask bt=new BackgroundTask();
					bt.doInBackground(url);					
				}
				
				}).start();*/
				
				
				
				
				//TestGesture t=new TestGesture();
				//s=(TextView)findViewById(R.id.it);
				//s.setText("Processing.......");
				/*TextView info1;
				info1=(TextView)findViewById(R.id.info);
				info1.setText("you are happy"+text);
				ImageView i;
				i=(ImageView)findViewById(R.id.imageView1);
				i.setImageResource(R.drawable.ic_launcher);
				Log.i("output", text);*/
				

				Intent intent = new Intent(MainActivity.this, Emotion.class);
		        startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
	
		
		
		
		
		
		
		
		
		
		
		
		}
	}




public class BackgroundTask extends AsyncTask<String, String, String>{

	
	@Override
    protected String doInBackground(String... params) {		   
         String command=params[0]; // URL to call			                 
         String response="";
         
     
         try {   	  
         response = executeCommand(command); 			         
         //JSONObject responeObj = new JSONObject(response);         
         //JSONObject response2 = (JSONObject) responeObj.get("response");         
         //JSONArray docs= (JSONArray) response2.get("docs"); 
         emotion=response;
     //info=(TextView)findViewById(R.id.info);
         /*if(docs.length()>0)
         { */       	 
        	 
        	 MainActivity.this.runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					
					if(emotion.contains("facepalm"))
					{
						info.setText("you are irritated");	
						ImageView i;
						i=(ImageView)findViewById(R.id.imageView1);
						i.setImageResource(R.drawable.ic_launcher1);
					}
					
					else if(emotion.contains("stomp"))
					{
						info.setText("you are angry");	
					}
					
					else
					 info.setText("you are happy");
				//info.setText(emotion);
				}
			});
        	
        	 
         		         
             
         }catch (Exception ex) {
             System.out.println("error!!");
             Log.i("url response", "IN Catch");
             ex.printStackTrace();
         }
        
         return emotion; 
    }
	
	private String executeCommand(String command) {
	   	 
		StringBuffer output = new StringBuffer();
		String output1="";
		String line="";
		try {
			
			 URL url = new URL(command);						
			 HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();         
	         BufferedReader br = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
	         while ((line = br.readLine())!= null) {
					output.append(line + "\n");	
					if(line.contains("gesture is"))
					output1=line;
				}		
			
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return output1+output.toString();
 
	}
	
	
}
	
}