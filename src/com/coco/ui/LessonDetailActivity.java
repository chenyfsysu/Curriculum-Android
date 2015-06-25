package com.coco.ui;

import java.util.ArrayList;

import com.coco.curriculum.R;
import com.coco.datamodel.Comment;
import com.coco.datamodel.Lesson;
import com.coco.ui.adapter.CommentListAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LessonDetailActivity extends Activity {
	private Lesson mLesson = null;

	private TextView mLessonName = null;
	private TextView mLessonTeacher = null;
	private TextView mClassHour = null;
	private TextView mLessonType = null;
	private TextView mLessonTeachType = null;
	private TextView mCampus = null;

	private ListViewForScrollView mCommentList = null;
	private CommentListAdapter mCommentAdapter = null;
	private ArrayList<Comment> mCommentDatas = new ArrayList<Comment>();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lesson_detail);

		bindView();
		mLesson = (Lesson) getIntent().getSerializableExtra("lesson");
		constuctView();
	}

	private void bindView() {
		mLessonName = (TextView) findViewById(R.id.lesson_name);
		mLessonTeacher = (TextView) findViewById(R.id.lesson_teacher);
		mClassHour = (TextView) findViewById(R.id.lesson_classhour);
		mLessonType = (TextView) findViewById(R.id.lesson_type);
		mLessonTeachType = (TextView) findViewById(R.id.lesson_teachtype);
		mCampus = (TextView) findViewById(R.id.lesson_campus);

		forshow();
		mCommentList = (ListViewForScrollView) findViewById(R.id.lesson_comment_list);
		mCommentAdapter = new CommentListAdapter(this);
		mCommentAdapter.loadData(mCommentDatas);
		mCommentList.setAdapter(mCommentAdapter);
	}

	private void forshow() {
		for(int i = 0; i < 20; i++) {
			Comment comment = new Comment();
			comment.mUserName = "coco";
			comment.mTime = "¸Õ¸Õ";
			comment.mContent = "²ÒÎÞÈËµÀ°¡£¬ÁùÔÂ·ÉËª°¡£¬ÇçÌìÅùö¨°¡";
			mCommentDatas.add(comment);
		}
	}
	
	private void constuctView() {
		if (mLesson == null)
			return;

		mLessonName.setText(mLesson.mTitle);
		mLessonTeacher.setText(mLesson.mTeacher);
		mClassHour.setText(mLesson.mClassHour);
		mLessonType.setText(mLesson.mType);
		mLessonTeachType.setText(mLesson.mTeachType);
		mCampus.setText(mLesson.mCampus);
		
		/////////////////for show();
	}
}
