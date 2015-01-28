package com.ixy.progressdrawable;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//
		ProgressBar pb1 = (ProgressBar) findViewById(R.id.pb1);
		ProgressBar pb2 = (ProgressBar) findViewById(R.id.pb2);
		ProgressBar pb3 = (ProgressBar) findViewById(R.id.pb3);
		SpinKitDrawable1 spinKitDrawable1 = new SpinKitDrawable1(this);
		SpinKitDrawable2 spinKitDrawable2=new SpinKitDrawable2(this);
		SpinKitDrawable3 spinKitDrawable3=new SpinKitDrawable3(this);
		pb1.setIndeterminateDrawable(spinKitDrawable1);
		pb2.setIndeterminateDrawable(spinKitDrawable2);
		pb3.setIndeterminateDrawable(spinKitDrawable3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}
