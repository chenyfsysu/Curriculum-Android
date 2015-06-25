package com.coco.ui;

import com.coco.curriculum.R;
import com.coco.ui.fragment.ExchangeFragment;
import com.coco.ui.fragment.LessonFragment;
import com.coco.ui.fragment.MyFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	private Fragment mLessonFragment = null;
	private Fragment mExchangeFragment = null;
	private Fragment mMyFragment = null;

	private ImageButton mLessonButton;
	private ImageButton mExchangeButton = null;
	private ImageButton mMyButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		initFragment();
		initView();
		replaceFragment(mLessonFragment);
	}

	private void initFragment() {
		mLessonFragment = new LessonFragment();
		mExchangeFragment = new ExchangeFragment();
		mMyFragment = new MyFragment();
		
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.add(R.id.fragment_container, mLessonFragment);
		transaction.add(R.id.fragment_container, mExchangeFragment);
		transaction.add(R.id.fragment_container, mMyFragment);
		transaction.commit();
	}

	private void initView() {
		mLessonButton = (ImageButton) findViewById(R.id.main_lesson);
		mLessonButton.setOnClickListener(mSelectPageListener);

		mExchangeButton = (ImageButton) findViewById(R.id.main_exchange);
		mExchangeButton.setOnClickListener(mSelectPageListener);

		mMyButton = (ImageButton) findViewById(R.id.main_user);
		mMyButton.setOnClickListener(mSelectPageListener);
	}
	
	private void replaceFragment(Fragment fragment) {
		if(fragment == null) return;
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.hide(mLessonFragment);
		transaction.hide(mExchangeFragment);
		transaction.hide(mMyFragment);
		transaction.show(fragment);
		transaction.commit();
	}

	private OnClickListener mSelectPageListener = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			mLessonButton.setImageResource(R.drawable.lesson_normal);
			mExchangeButton.setImageResource(R.drawable.exchange_normal);
			mMyButton.setImageResource(R.drawable.user_normal);

			Fragment nextFragment = null;
			switch (arg0.getId()) {
			case R.id.main_lesson :
				mLessonButton.setImageResource(R.drawable.lesson_highlight);
				nextFragment = mLessonFragment;
				break;
			case R.id.main_exchange :
				mExchangeButton.setImageResource(R.drawable.exchange_hightlight);
				nextFragment = mExchangeFragment;
				break;
			case R.id.main_user :
				mMyButton.setImageResource(R.drawable.user_highlight);
				nextFragment = mMyFragment;
				break;
			}
			
			replaceFragment(nextFragment);
		}
	};
}
