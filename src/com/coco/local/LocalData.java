package com.coco.local;

import java.util.ArrayList;

import com.coco.datamodel.Lesson;
import com.coco.datamodel.User;

public class LocalData {
	private static LocalData mInstance = null;
	private User mUser = new User();
	private ArrayList<Lesson> mMyLessonList = new ArrayList<Lesson>();
	private ArrayList<Lesson> mAllLessonList = new ArrayList<Lesson>();
	
	public static LocalData getInstance() {
		if(mInstance == null)
			mInstance = new LocalData();
		
		return mInstance;
	}
	
	public User getUser() {
		return mUser;
	}

	public ArrayList<Lesson> getMyLessonList() {
		return mMyLessonList;
	}

	public ArrayList<Lesson> getAllLessonList() {
		return mAllLessonList;
	}

}
