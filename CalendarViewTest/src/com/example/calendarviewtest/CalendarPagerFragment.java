package com.example.calendarviewtest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class CalendarPagerFragment extends Fragment {
	
	public static final String INDEX = "index";
    private String TAG = "CalendarPagerFragment" ;
	private int mMonthIndex;
	private CalendarGridViewAdapter adapter ;
	
	public static CalendarPagerFragment create(int monthIndex ){
		CalendarPagerFragment fragment = new CalendarPagerFragment();
		Bundle args = new Bundle();
		args.putInt(INDEX, monthIndex);
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mMonthIndex = getArguments().getInt(INDEX);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = null;
		view= inflater.inflate(R.layout.fragment_calendar,container,false);
		GridView grid = (GridView)view.findViewById(R.id.gridview);
		int daynum = CalendarUtil.getDayNum(mMonthIndex);
		int dayweek = CalendarUtil.getDayWeek(mMonthIndex) ;
		List<HashMap<String , Object>> days =new ArrayList<HashMap<String ,Object>>();
		for(int i = 1 ; i<dayweek ; i++){
			HashMap<String , Object> map = new HashMap<String , Object>();
			map.put("day", "");
			map.put("status", -1);
			days.add(map) ;
		}
		for(int i = 1 ;i<=daynum ; i++){
			HashMap<String , Object> map = new HashMap<String , Object>();
			map.put("day", i);
			map.put("status", 0);
			if (CalendarUtil.getCurentDay() > daynum) { //今天日期大于目前月份的天数
				 //如果是第一天，设置为选中状态
				if (i == 1)
					map.put("status", 1);
				
			} else {  //今天的日期天不大于本月的天数
				
				if (this.mMonthIndex == CalendarUtil.getCurrentMouth() 
						&& i == CalendarUtil.getCurentDay()) { //如果年月日都和今天日期相同，设置为今天状态
					map.put("status", 2);
				} else if (i == CalendarUtil.getCurentDay()) { //只有日期和今天日期相同，设置为选中状态
					map.put("status", 1);
				}
			}
			Log.i(TAG, map.toString()) ;
			days.add(map) ;
		}
		Log.i(TAG, days.toString()) ;
		adapter = new CalendarGridViewAdapter(container.getContext(),days ,R.layout.calendar_day , new String[]{"day"} , new int[]{R.id.day});
		grid.setAdapter(adapter) ;
		grid.setOnItemClickListener(new OnItemClickListener(){
    
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				adapter.selectOption(position) ;
				Date date = CalendarUtil.getData(mMonthIndex) ;
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/");
				String d = df.format(date) ;
				HashMap<String ,Object> map = (HashMap<String ,Object>)view.getTag() ;
				Toast.makeText(getActivity(), d+map.get("day"), Toast.LENGTH_SHORT).show() ;
			}
			
		});
		return view ;
		
	}

}

