package com.coco.datamodel;

import java.io.Serializable;

public class Lesson implements Serializable{
	public int mSchool;
	public String mLessonId;
	public String mTitle;
	public String mDescrption;
	public String mClassHour;
	public String mCredit;
	public String mCampus;
	public String mTeacher;
	public String mTeachType; //主-辅修
	public String mType; //公必-专必...
	public String mEvaluationValue;
	public String mEvaluationCount;
}
