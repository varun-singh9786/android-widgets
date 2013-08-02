/**
 * 
 */
package com.varun.android.widgets;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.varun.android.widgets.dialogfragmentlib.R;

/**
 * @author dev
 *
 */

public final class ProgressDialogFragment extends DialogFragment {
	
	private boolean mIsCancelable;
	public ProgressDialogFragment() {
		super();
	}


	/**
	 * @param mIsCancelable
	 */
	public ProgressDialogFragment(boolean mIsCancelable) {
		super();
		this.mIsCancelable = mIsCancelable;
	}


	/**
	 * @return the mIsCancelable
	 */
	public boolean isCancelable() {
		return mIsCancelable;
	}


	/**
	 * @param mIsCancelable the mIsCancelable to set
	 */
	public void setIsCancelable(boolean mIsCancelable) {
		this.mIsCancelable = mIsCancelable;
	}


	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		final ProgressDialog progressDialog = new ProgressDialog(getActivity());
		progressDialog.setMessage(getString(R.string.loading));
		progressDialog.setCancelable(isCancelable());
		return progressDialog;
	}
	
	public void dismiss() {
		getDialog().dismiss();
	}

}
