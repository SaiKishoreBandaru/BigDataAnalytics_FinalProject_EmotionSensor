package com.example.whattodo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

//import com.umkc.googleChart.R;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//import com.umkc.googleChart.R;

public class Report extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
	WebView webview = (WebView) findViewById(R.id.webView1);
    String path = "raw/Data.txt";
    File text = new File(path);
    Scanner scan;
    
    String data = "";
    
    InputStream is = getResources().openRawResource(R.raw.data);
    
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    

	String line;
	try {
		while ((line = br.readLine()) != null) {
			String[] vals = line.split("\t");
			
			data = data + "['"+vals[0]+"',"+vals[1]+","+vals[2]+","+vals[3]+"], ";
			System.out.println("data " + data);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
/*
	try {
		scan = new Scanner(text);
		 while (scan.hasNext()) {
				
				
				String happy = "0",sad ="0",irri = "0";
				if(vals[2].equals("Happy")){
					happy = vals[1]; 
				}else if (vals[2].equals("Sad")){
					sad = vals[1]; 
				}else if (vals[2].equals("Irritated")){
					irri = vals[1]; 
				}else{
					continue;
				}
				data = data + "['"+vals[0]+"',"+happy  +","+      sad+","+	irri+"],";
				
			}
		*/ 
	/*} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    */
   
    String content = "<html>"
            + "  <head>"
            + "    <script type=\"text/javascript\" src=\"jsapi.js\"></script>"
            + "    <script type=\"text/javascript\">"
            + "      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
            + "      google.setOnLoadCallback(drawChart);"
            + "      function drawChart() {"
            + "        var data = google.visualization.arrayToDataTable(["
            
            +"          ['Time', 'Happy', 'Sad', 'Irritated'],"
            + data
            /*+ "          ['06AM',  5,      2,	0],"
            + "          ['09AM',  4,	5,	10],"
            + "          ['12PM',  6,	7,	5],"
            + "          ['03PM',  3,	10,	5],"
            + "          ['06PM',  10,	8,	4],"
            + "          ['09PM',  5,	8,	10]"
            */+ "        ]);"
            + "        var options = {"
            
			+ "        annotations: {"
			+ "            textStyle: {"
			+ "        fontName: 'Times-Roman',"
			+ "        fontSize: 30,"
			+ "        bold: true,"
			+ "        italic: true,"
			+ "        color: '#871b47',     "// The color of the text.
			+ "        auraColor: '#d799ae', "// The color of the text outline.
			+ "        opacity: 2.0"          // The transparency of the text.
			+ "        }"
			+ "        },"
            + "          title: 'Daily Acitivty Report',"
            + "          hAxis: {title: 'Time', titleTextStyle: {color: 'red'}},"
            + "          boxStyle: {"
            + "		stroke: '#888',     "      
            + "		strokeWidth: 5,    "
            + "			} "
            + "        };"
            + "        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));"
            + "        chart.draw(data, options);"
            + "      }"
            + "    </script>"
            + "  </head>"
            + "  <body>"
            + "    <div id=\"chart_div\" style=\"width: 1500px; height: 1200px;\"></div>"
            + "       <img style=\"padding: 0; margin: 0 0 0 330px; display: block;\" src=\"truiton.png\"/>"
            + "  </body>" + "</html>";

    WebSettings webSettings = webview.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webview.getSettings().setLoadWithOverviewMode(true);
    webview.getSettings().setUseWideViewPort(true);
    webview.getSettings().setBuiltInZoomControls(true);
    webview.requestFocusFromTouch();
    
    webview.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    
    webview.loadDataWithBaseURL( "file:///android_asset/", content, "text/html", "utf-8", null );
    //webview.loadUrl("file:///android_asset/Code.html"); // Can be used in this way too.
    
    WebView web2 = (WebView)findViewById(R.id.webView2);
    web2.getSettings().setJavaScriptEnabled(true);
    web2.loadUrl("https://www.google.com/maps/dir/Kansas+City,+MO/Buffalo+Wild+Wings,+7030+W+105th+St,+Overland+Park,+KS+66212/@39.015294,-94.6946661,12z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x87c0f75eafe99997:0x558525e66aaa51a2!2m2!1d-94.5785667!2d39.0997265!1m5!1m1!1s0x87c0ebb571bcab2f:0xb2e375a00b7766fa!2m2!1d-94.665881!2d38.939284");
    web2.setWebViewClient(new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }
    });
	
    }	

}
