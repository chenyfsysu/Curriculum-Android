package com.coco.ui.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coco.curriculum.R;
import com.coco.datamodel.Exchange;
import com.coco.datamodel.Lesson;

public class ExchangeListAdapter extends BaseAdapter {
	private LayoutInflater mInflater = null;
	private ArrayList<Exchange> mExchangeList = null;

	public ExchangeListAdapter(Context context) {
		mInflater = LayoutInflater.from(context);
	}

	public void loadData(ArrayList<Exchange> exchangeList) {
		mExchangeList = exchangeList;
	}

	@Override
	public int getCount() {
		if (mExchangeList == null)
			return 0;
		else
			return mExchangeList.size();
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
			convertView = mInflater.inflate(R.layout.exchange_listitem, null);
			viewHolder = new ViewHolder();
			viewHolder.mUserName = (TextView) convertView
					.findViewById(R.id.exchange_name);
			viewHolder.mTime = (TextView) convertView
					.findViewById(R.id.exchange_time);
			viewHolder.mLessonOut = (TextView) convertView
					.findViewById(R.id.exchange_lessonout);
			viewHolder.mLessonIn = (TextView) convertView
					.findViewById(R.id.exchange_lessonin);
			viewHolder.mPhone = (TextView) convertView
					.findViewById(R.id.exchange_phone);
			viewHolder.mEmail = (TextView) convertView
					.findViewById(R.id.exchange_email);
			viewHolder.mQQ = (TextView) convertView
					.findViewById(R.id.exchange_qq);
			viewHolder.mWeChat = (TextView) convertView
					.findViewById(R.id.exchange_wechat);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		Exchange exchange = mExchangeList.get(position);
		viewHolder.mUserName.setText(exchange.mUserName);
		viewHolder.mTime.setText(exchange.mTime);
		viewHolder.mLessonOut.setText(exchange.mLessonOut);
		viewHolder.mLessonIn.setText(exchange.mLessonIn);
		viewHolder.mPhone.setText(exchange.mPhone);
		viewHolder.mEmail.setText(exchange.mEmail);
		viewHolder.mQQ.setText(exchange.mQQ);
		viewHolder.mWeChat.setText(exchange.mWeChat);
		return convertView;
	}

	private class ViewHolder {
		public TextView mUserName;
		public TextView mTime;
		public TextView mLessonOut;
		public TextView mLessonIn;
		public TextView mPhone;
		public TextView mEmail;
		public TextView mQQ;
		public TextView mWeChat;
	}
}
