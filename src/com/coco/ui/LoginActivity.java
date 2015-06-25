package com.coco.ui;



import com.coco.curriculum.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	private EditText mUserName = null;
	private EditText mPassword = null;
	private Button mLogin = null;
	SharedPreferences mUserSharedPreferences = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		bindView();
		readPastData();
	}

	private void bindView() {
		mUserName = (EditText) findViewById(R.id.login_username);
		mPassword = (EditText) findViewById(R.id.login_password);
		mLogin = (Button) findViewById(R.id.login_login);
		mLogin.setOnClickListener(new LoginClick());
	}
	
	private void readPastData(){
		mUserSharedPreferences = getSharedPreferences("user", Activity.MODE_PRIVATE);
		String userName  = mUserSharedPreferences.getString("username", "");
		String password = mUserSharedPreferences.getString("password", "");
		mUserName.setText(userName);
		mPassword.setText(password);
	}
	
	private class LoginClick implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			String userName = mUserName.getText().toString();
			String password = mPassword.getText().toString();
			login(userName, password);
		}
	}

	private void login(String userName, String password) {
		SharedPreferences.Editor editor = mUserSharedPreferences.edit();
		editor.putString("username", userName);
		editor.putString("password", password);
		editor.commit();
		
		Intent intent = new Intent(LoginActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
