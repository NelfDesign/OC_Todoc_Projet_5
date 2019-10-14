package com.cleanup.todoc.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

import com.cleanup.todoc.R;

/**
 * Created by Nelfdesign at 11/10/2019
 * com.cleanup.todoc.ui
 */
public class AddTaskDialog extends DialogFragment {

    public interface AddTaskDialogListener{
        void onPositiveClick();
        void onNegativeClick();
    }

    private AddTaskDialogListener listener;

    @NonNull
    @Override
    public AlertDialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext(), R.style.Dialog);

        alertBuilder.setTitle(R.string.add_task);
        alertBuilder.setView(R.layout.dialog_add_task);
        alertBuilder.setPositiveButton(getString(R.string.add), (dialog, which) -> {
            this.listener.onPositiveClick();
        });
        alertBuilder.setNegativeButton(getString(R.string.annuler), (dialog, which) -> this.listener.onNegativeClick());

       return alertBuilder.create();
    }
}
