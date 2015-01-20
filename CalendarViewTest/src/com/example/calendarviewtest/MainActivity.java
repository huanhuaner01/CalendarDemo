package com.example.calendarviewtest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.widget.TextView;
import android.os.Bundle;


public class MainActivity extends FragmentActivity {
	private String TAG = "MainActivity" ;
    private TextView title ;
    private ViewPager mPager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = (ViewPager)this.findViewById(R.id.pager) ;
        title = (TextView)this.findViewById(R.id.header_title) ;
        CalendarPagerAdapter mPagerAdapter = new CalendarPagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);
		mPager.setOnPageChangeListener(new OnPageChangeListener(){

			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}

			@Override
			public void onPageSelected(int index) {
				Date date = CalendarUtil.getData(index) ;
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM");
				String d = df.format(date) ;
				title.setText(d) ;
			}
			
		});
		setToDay();
    }
    
    private void setToDay(){
    	Calendar cal=Calendar.getInstance();
    	int year = cal.get(Calendar.YEAR) ;
    	int mouth = cal.get(Calendar.MONTH) ;
    	int day = cal.get(Calendar.DATE) ;
    	int index = (year - 1970)*12+mouth;
    	Log.i(TAG, "index :"+index+" 现在时刻是"+year+"年"+mouth+"月"+day+"日"+" cal.getttime():"+cal.getTime().toString()) ;
    	this.mPager.setCurrentItem(index) ;
    }
}
