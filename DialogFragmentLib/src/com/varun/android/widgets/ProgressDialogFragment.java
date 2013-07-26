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
	
	
	public ProgressDialogFragment() {
		super();
	}


	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		final ProgressDialog progressDialog = new ProgressDialog(getActivity());
		progressDialog.setMessage(getString(R.string.loading));
		
		return progressDialog;
	}
	
	public void dismiss() {
		getDialog().dismiss();
	}

}
