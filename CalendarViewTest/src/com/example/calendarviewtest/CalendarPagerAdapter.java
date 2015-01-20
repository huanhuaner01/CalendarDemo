package com.example.calendarviewtest;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * ÈÕÀúfragmentÊÊÅäÆ÷
 * @author zhanghuan
 *
 */
public class CalendarPagerAdapter extends FragmentStatePagerAdapter {
    private String TAG = "CalendarPagerAdapter" ;
	public CalendarPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
//		return new CalendarPagerFragment();
		return CalendarPagerFragment.create(position);
	}

	@Override
	public int getCount() {
//		Log.i(TAG, CalendarUtil.getAllMonth()+"") ;
		return CalendarUtil.getAllMonth();
//		return 10;
	}

}
