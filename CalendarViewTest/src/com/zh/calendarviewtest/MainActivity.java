package com.zh.calendarviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn1 = (Button)this.findViewById(R.id.button1) ;
		Button btn2 = (Button)this.findViewById(R.id.button2) ;
		btn1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(MainActivity.this,CalendarActivity.class);
				Bundle bundle = new Bundle();
				bundle.putBoolean("isSection", false) ;
				i.putExtras(bundle) ;
				MainActivity.this.startActivityForResult(i, 0) ;
			}
			
		}) ;
		btn2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(MainActivity.this,CalendarActivity.class);
				Bundle bundle = new Bundle();
				bundle.putBoolean("isSection", true) ;
				bundle.putString(CalendarActivity.BEGIN_DATE, "2015-01-23");
				bundle.putString(CalendarActivity.END_DATE, "2015-01-30");
				i.putExtras(bundle) ;
				MainActivity.this.startActivityForResult(i, 0) ;
			}
			
		});
	}
	// 回调方法，从第二个页面回来的时候会执行这个方法
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			 if(requestCode == 0){
				 if(resultCode == RESULT_OK){
			 String selectDate = data.getStringExtra(CalendarActivity.RESULT_DATA);
			 Log.i("MainActivity", selectDate+" requestCode is "+requestCode +" resultCode is "+resultCode) ;
			 }
			 }
			 super.onActivityResult(requestCode, resultCode, data) ;
		}
	
}
