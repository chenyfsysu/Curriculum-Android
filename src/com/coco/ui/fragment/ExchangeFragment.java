package com.coco.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import com.coco.curriculum.R;
import com.coco.datamodel.Exchange;
import com.coco.ui.AddExchangeActivity;
import com.coco.ui.adapter.ExchangeListAdapter;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

public class ExchangeFragment extends Fragment {
	private ListView mExchangeList = null;
	private ImageView mAdd = null;
	private ExchangeListAdapter mExchangeAdapter = null;
	private ArrayList<Exchange> mChangeDatas = new ArrayList<Exchange>();

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mAdd = (ImageView) getView().findViewById(R.id.exchange_add);
		mAdd.setOnTouchListener(new FloatViewListener());
		// ////////////////forshow
		forshow();
		mExchangeList = (ListView) getView().findViewById(R.id.exchange_list);
		mExchangeAdapter = new ExchangeListAdapter(getActivity());
		mExchangeAdapter.loadData(mChangeDatas);
		mExchangeList.setAdapter(mExchangeAdapter);
	}

	private void forshow() {
		for (int i = 0; i < 15; i++) {
			Exchange exchange = new Exchange();
			exchange.mUserName = "coco";
			exchange.mTime = "刚刚";
			exchange.mLessonOut = "系统分析与设计";
			exchange.mLessonIn = "小学数学";
			exchange.mPhone = "12345678910";
			exchange.mEmail = "chenyfsysu@gmail.com";
			exchange.mQQ = "382466970";
			exchange.mWeChat = "chenyfsysu";
			mChangeDatas.add(exchange);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.exchange_fragment, container, false);
	}

	private class FloatViewListener implements OnTouchListener {
		private int initX;
		private int initY;
		private final static int ThresholdValue = 5;
		
		private int lastX;
		private int lastY;

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			int action = event.getAction();
			switch (action) {
			case MotionEvent.ACTION_DOWN:
				lastX = (int) event.getRawX();
				lastY = (int) event.getRawY();
				initX = lastX;
				initY = lastY;
				break;

			case MotionEvent.ACTION_MOVE:
				int dx = (int) event.getRawX() - lastX;
				int dy = (int) event.getRawY() - lastY;
				int left = v.getLeft() + dx;
				int bottom = v.getBottom() + dy;
				int right = v.getRight() + dx;
				int top = v.getTop() + dy;
				v.layout(left, top, right, bottom);
				lastX = (int) event.getRawX();
				lastY = (int) event.getRawY();
				v.postInvalidate();
				break;

			case MotionEvent.ACTION_UP:
				int finalX = (int)event.getRawX();
				int finalY = (int)event.getRawY();
				if(Math.abs(finalX - initX) + Math.abs(finalY - initY) < ThresholdValue)
					onClick();
				break;
			}
			return true;
		}

		private void onClick() {
			Intent intent = new Intent(getActivity(), AddExchangeActivity.class);
			startActivity(intent);
		}
	}
}