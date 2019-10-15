package com.cleanup.todoc.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.cleanup.todoc.R;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.SortMethod;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.ui.MainActivity;
import com.cleanup.todoc.ui.TasksAdapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nelfdesign at 11/10/2019
 * com.cleanup.todoc.utils
 */
public class Utils {
    /**
     * Sets the data of the Spinner with projects to associate to a new task
     */
    public static void populateDialogSpinner(Spinner spinner, Context context, TasksAdapter adapter) {
        final List<Project> p = adapter.getCurrentProjects();

        final ArrayAdapter<Project> adapterSpinner = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, p);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapterSpinner);
        }
    }

    /**
     * Sorts the {@link List< Task >} in argument and returns it
     * @param tasks a {@link List<Task>}
     * @return the {@link List<Task>} but sorted
     */
    @NonNull
    public static List<Task> sortTasks(@NonNull final List<Task> tasks, SortMethod sortMethod) {
        if (tasks.size()!= 0) {
            switch (sortMethod) {
                case ALPHABETICAL:
                    Collections.sort(tasks, new Task.TaskAZComparator());
                    break;
                case ALPHABETICAL_INVERTED:
                    Collections.sort(tasks, new Task.TaskZAComparator());
                    break;
                case RECENT_FIRST:
                    Collections.sort(tasks, new Task.TaskRecentComparator());
                    break;
                case OLD_FIRST:
                    Collections.sort(tasks, new Task.TaskOldComparator());
                    break;
            }
        }
        return tasks;
    }


}
