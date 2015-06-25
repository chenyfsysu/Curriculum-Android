package com.coco.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.coco.curriculum.R;
import com.coco.datamodel.Lesson;
import com.coco.local.LocalData;
import com.coco.ui.LessonDetailActivity;
import com.coco.ui.adapter.LessonListAdapter;

public class LessonFragment extends Fragment {
	private ListView mLessonList = null;
	private LessonListAdapter mLessonAdapter = null;

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// //////////////for show
		forshow();
		mLessonList = (ListView) getView().findViewById(R.id.my_lesson_list);
		mLessonAdapter = new LessonListAdapter(getActivity());
		mLessonAdapter.loadData(LocalData.getInstance().getMyLessonList());
		mLessonList.setAdapter(mLessonAdapter);
		mLessonList.setOnItemClickListener(new OnLessonClick());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.lesson_fragment, container, false);
	}

	private void forshow() {
		for (int i = 0; i < 20; i++) {
			Lesson lesson = new Lesson();
			lesson.mTitle = "ϵͳ���������";
			lesson.mTeacher = "��ï��";
			lesson.mClassHour = "������ 9-11��";
			lesson.mType = "ר��";

			lesson.mCampus = "��У��";
			lesson.mTeachType = "����";
			LocalData.getInstance().getMyLessonList().add(lesson);
		}
	}

	private class OnLessonClick implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Lesson lesson = LocalData.getInstance().getMyLessonList().get(arg2);
			Intent intent = new Intent(getActivity(),
					LessonDetailActivity.class);
			intent.putExtra("lesson", lesson);
			startActivity(intent);
		}
	}
}
