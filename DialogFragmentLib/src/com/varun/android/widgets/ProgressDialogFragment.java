/**
 * 
 */
package com.varun.android.widgets;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.varun.android.widgets.dialogfragmentlib.R;

/**
 * @author dev
 *
 */

public final class ProgressDialogFragment extends DialogFragment {
	
	private boolean mDialogCancelable;
	public ProgressDialogFragment() {
		super();
	}


	/**
	 * @param mIsCancelable marks if the progressDialog can be using through back button
	 */
	public ProgressDialogFragment(boolean cancelable) {
		super();
		this.mDialogCancelable = cancelable;
	}
	


	public boolean isDialogCancelable() {
		return this.mDialogCancelable;
	}


	public void setDialogCancelable(boolean aDialogCancelable) {
		this.mDialogCancelable = aDialogCancelable;
	}


	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		final ProgressDialog progressDialog = new ProgressDialog(getActivity());
		progressDialog.setMessage(getString(R.string.loading));
		progressDialog.setCancelable(isDialogCancelable());
		this.setCancelable(mDialogCancelable);
		
		return progressDialog;
	}
	
	public void dismiss() {
		getDialog().dismiss();
	}

}
