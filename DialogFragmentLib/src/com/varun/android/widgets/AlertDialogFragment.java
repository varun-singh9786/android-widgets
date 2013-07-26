/**
 * 
 */
package com.varun.android.widgets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import com.varun.android.widgets.dialogfragmentlib.R;

/**
 * @author dev
 *
 */
public class AlertDialogFragment extends DialogFragment {

	private static final String TAG = AlertDialogFragment.class.getSimpleName();
	private String title = null;
	private String message = null;
	private Drawable iconImage = null;
	private OnClickListener positiveOnClickListener = null;
	private OnClickListener negativeOnClickListener = null;
	private String positionButtonText = null;
	private String negativeButtonText = null;
	
	public AlertDialogFragment() {
	}	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		Log.i(TAG, "onCreateDialog, context: " + getActivity());
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		Log.i(TAG, "onCreateDialog: " + this.title + " " + this.message + " pos-listener: " + this.positiveOnClickListener + " neg-listener: " + this.negativeOnClickListener);
		builder.setTitle(this.title);
		builder.setMessage(this.message);
		if (this.positiveOnClickListener != null) {
			Log.i(TAG, "onCreateDialog: inside positiveOnClick");
			if (this.positionButtonText == null) {
				builder.setPositiveButton(getString(R.string.ok), this.positiveOnClickListener);
			} else {
				builder.setPositiveButton(this.positionButtonText, this.positiveOnClickListener);
			}
			
		}
		if (this.negativeOnClickListener != null) {
			if (this.negativeButtonText == null) {
				builder.setNegativeButton(getString(R.string.cancel), this.positiveOnClickListener);
			} else {
				builder.setNegativeButton(this.positionButtonText, this.positiveOnClickListener);
			}
			builder.setNegativeButton(this.negativeButtonText, this.negativeOnClickListener);
		}
		return builder.create();
	}
	
	/**
	 * @return the icon
	 */
	public Drawable getIconImage() {
		return iconImage;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIconImage(Drawable icon) {
		this.iconImage = icon;
	}
	

	/**
	 * @return the positionButtonText
	 */
	public String getPositionButtonText() {
		return positionButtonText;
	}

	/**
	 * @param positionButtonText the positionButtonText to set
	 */
	public void setPositionButtonText(String positionButtonText) {
		this.positionButtonText = positionButtonText;
	}

	/**
	 * @return the negativeButtonText
	 */
	public String getNegativeButtonText() {
		return negativeButtonText;
	}

	/**
	 * @param negativeButtonText the negativeButtonText to set
	 */
	public void setNegativeButtonText(String negativeButtonText) {
		this.negativeButtonText = negativeButtonText;
	}

	/**
	 * @return the positiveOnClickListener
	 */
	public OnClickListener getPositiveOnClickListener() {
		return positiveOnClickListener;
	}

	/**
	 * @param positiveOnClickListener the positiveOnClickListener to set
	 */
	public void setPositiveOnClickListener(String positiveButtonText, OnClickListener positiveOnClickListener) {
		Log.i(TAG, " setting setPositiveOnClickListener");
		this.positiveOnClickListener = positiveOnClickListener;
	}

	/**
	 * @return the negativeOnClickListener
	 */
	public OnClickListener getNegativeOnClickListener() {
		return negativeOnClickListener;
	}

	/**
	 * @param negativeOnClickListener the negativeOnClickListener to set
	 */
	public void setNegativeOnClickListener(String negativeButtonText, OnClickListener negativeOnClickListener) {
		this.negativeOnClickListener = negativeOnClickListener;
		this.negativeButtonText = negativeButtonText;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
		Log.i(TAG, "setMessage: " + this.message);
	}
	
	public void dismiss() {
		getDialog().dismiss();
	}

}
