package com.varun.android.widget.dialogfragmentsample;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.varun.android.widgets.AlertDialogFragment;
import com.varun.android.widgets.ProgressDialogFragment;

public class MainActivity extends FragmentActivity {

	private static final String ALERT_DIALOG_FRAGMENT_TAG = "ALERT_DIALOG_FRAGMENT_TAG";
	private static final String PROGRESS_DIALOG_FRAGMENT_TAG = "PROGRESS_DIALOG_FRAGMENT_TAG";
	private static final int SUCCESS = 0;
	protected static final String TAG = MainActivity.class.getSimpleName();
	private ProgressDialogFragment mProgressDialogFragment = null;
	public ProgressDialogFragment getProgressDialogFragment() {
		return mProgressDialogFragment;
	}

	public void setProgressDialogFragment(
			ProgressDialogFragment mProgressDialogFragment) {
		this.mProgressDialogFragment = mProgressDialogFragment;
	}

	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == SUCCESS) {
				try {
					mProgressDialogFragment.dismiss();
				} catch (NullPointerException e) {
					Log.i(TAG, "handleMessage: exception: " + e.toString());
				}
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
		alertDialogFragment.setTitle(getString(R.string.app_name)).setMessage(getString(R.string.hello_world)).setPositiveOnClickListener(getString(R.string.ok), new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), getString(R.string.ok_clicked), Toast.LENGTH_LONG).show();
			}
		}).setNegativeOnClickListener(getString(R.string.cancel), new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), getString(R.string.cancel_clicked), Toast.LENGTH_LONG).show();
			}
		}).show(getSupportFragmentManager(), ALERT_DIALOG_FRAGMENT_TAG);
		
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						ProgressDialogFragment progressDialogFragment = MainActivity.this.getProgressDialogFragment();
						if (progressDialogFragment == null) {
							progressDialogFragment = new ProgressDialogFragment(false);
							MainActivity.this.setProgressDialogFragment(progressDialogFragment);
						}
						progressDialogFragment.show(MainActivity.this.getSupportFragmentManager(), PROGRESS_DIALOG_FRAGMENT_TAG);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							Log.i(TAG, "run: Exception: " + e.toString());
						}
						mHandler.sendEmptyMessage(SUCCESS);
					}
				}).start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
