package com.cleanup.todoc.utils;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import com.cleanup.todoc.R;

import org.hamcrest.Matcher;

/**
 * Created by Nelfdesign at 21/10/2019
 * com.cleanup.todoc.utils
 */
public class DeleteViewAction implements ViewAction {
    @Override
    public Matcher<View> getConstraints() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Click on specific button";
    }

    @Override
    public void perform(UiController uiController, View view) {
        View button = view.findViewById(R.id.img_delete);
        // Maybe check for null
        button.performClick();
    }
}
