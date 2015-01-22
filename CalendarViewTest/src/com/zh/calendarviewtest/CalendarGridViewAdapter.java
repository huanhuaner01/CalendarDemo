package com.zh.calendarviewtest;

import java.util.List;
import java.util.Map;

import com.zh.calendarviewtest.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class CalendarGridViewAdapter extends SimpleAdapter {
    private List<? extends Map<String,Object>> data ;
    private int currentChecked = -1 ; //��¼Ŀǰѡ�е�item���±� ��-1Ϊû��ѡ��
    private int currentpreStatus = 0 ; //��¼Ŀǰѡ�е�item֮ǰ��״̬
    private Context context ;
    public CalendarGridViewAdapter(Context context,
			List<? extends Map<String, Object>> data, int resource, String[] from,
			int[] to ) {
		super(context, data, resource, from, to);
		this.data = data ;
		this.context = context ;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view =  super.getView(position, convertView, parent);
		TextView tv = (TextView)view.findViewById(R.id.day) ;
		setTvStatus(tv ,Integer.parseInt(this.data.get(position).get("status").toString()),position );
		view.setTag(this.data.get(position));
		return view ;
	}
	
	/**
	 * ѡ������ĸ���
	 * @param position ѡ�е��±�
	 * 
	 */
	public void selectOption(int position){
		this.data.get(currentChecked).put("status",this.currentpreStatus) ;
		this.data.get(position).put("status", 1);
		this.notifyDataSetChanged() ;
		
	}
	private void setTvStatus(TextView tv , int status ,int position){
		
		switch(status){
		case 0:  //��ѡ
			tv.setEnabled(true)  ;
			tv.setSelected(false);
			break ;
		case 1:  //ѡ��
			tv.setEnabled(true)  ;
			tv.setSelected(true);
			this.currentChecked = position ;
			break ;
			
		case 2:  //����
			tv.setEnabled(true)  ;
			tv.setBackgroundResource(R.drawable.today_bg) ;
			
			if(this.currentChecked == -1){
				tv.setSelected(true);
				this.currentChecked = position ;
			}else{
				tv.setSelected(false);
			}
			break ;
		case -1: //����ѡ
			tv.setEnabled(false) ;
			tv.setSelected(false);
			tv.setBackground(null);
			tv.setTextColor(this.context.getResources().getColor(R.color.Grey_line)) ;
			break ;
		case -2: //���첻��ѡ
			tv.setEnabled(true)  ;
			tv.setSelected(false);
			tv.setTextColor(this.context.getResources().getColor(R.color.Grey_line)) ;
			tv.setBackgroundResource(R.drawable.cricle_todat_notoption) ;
			break ;
			
		}
	}
    
}
