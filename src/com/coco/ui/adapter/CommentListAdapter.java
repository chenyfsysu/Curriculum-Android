package com.coco.ui.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coco.curriculum.R;
import com.coco.datamodel.Comment;
import com.coco.datamodel.Lesson;

public class CommentListAdapter extends BaseAdapter {
	private LayoutInflater mInflater = null;
	private ArrayList<Comment> mCommentList = null;

	public CommentListAdapter(Context context) {
		mInflater = LayoutInflater.from(context);
	}

	public void loadData(ArrayList<Comment> commentList) {
		mCommentList = commentList;
	}

	@Override
	public int getCount() {
		if (mCommentList == null)
			return 0;
		else
			return mCommentList.size();
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
			convertView = mInflater.inflate(R.layout.comment_item, null);
			viewHolder = new ViewHolder();
			viewHolder.mCommentName = (TextView) convertView
					.findViewById(R.id.comment_name);
			viewHolder.mCommentTime = (TextView) convertView
					.findViewById(R.id.comment_time);
			viewHolder.mCommentContent = (TextView) convertView
					.findViewById(R.id.comment_content);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Comment comment = mCommentList.get(position);
		viewHolder.mCommentName.setText(comment.mUserName);
		viewHolder.mCommentTime.setText(comment.mTime);
		viewHolder.mCommentContent.setText(comment.mContent);
		return convertView;
	}

	private class ViewHolder {
		public TextView mCommentName;
		public TextView mCommentTime;
		public TextView mCommentContent;
	}
}
