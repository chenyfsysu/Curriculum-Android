package com.coco.ui.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coco.curriculum.R;
import com.coco.datamodel.Lesson;

public class LessonListAdapter extends BaseAdapter {
	private LayoutInflater mInflater = null;
	private ArrayList<Lesson> mLessonList = null;
	
	public LessonListAdapter(Context context) {
		mInflater = LayoutInflater.from(context);
	}
	
	public void loadData(ArrayList<Lesson> lessonList) {
		mLessonList = lessonList;
	}
	
	@Override
	public int getCount() {
		if(mLessonList == null)
			return 0;
		else
			return mLessonList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.lesson_listitem, null);
			viewHolder = new ViewHolder();
			viewHolder.mLessonName = (TextView) convertView
					.findViewById(R.id.my_lesson_name);
			viewHolder.mLessonTeacher = (TextView) convertView
					.findViewById(R.id.my_lesson_teacher);
			viewHolder.mLessonAddr = (TextView) convertView
					.findViewById(R.id.my_lesson_addr);
			viewHolder.mLessonType = (TextView) convertView
					.findViewById(R.id.my_lesson_type);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder)convertView.getTag();
		}
		
		Lesson curLesson = mLessonList.get(position);
		viewHolder.mLessonName.setText(curLesson.mTitle);
		viewHolder.mLessonTeacher.setText(curLesson.mTeacher);
		viewHolder.mLessonAddr.setText(curLesson.mClassHour);
		viewHolder.mLessonType.setText(curLesson.mType);
		return convertView;
	}
	
	private class ViewHolder {
		public TextView mLessonName;
		public TextView mLessonTeacher;
		public TextView mLessonAddr;
		public TextView mLessonType;
	}
}
