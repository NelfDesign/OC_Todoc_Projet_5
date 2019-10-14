package com.cleanup.todoc.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cleanup.todoc.model.Project;
import java.util.List;

/**
 * Created by Nelfdesign at 11/10/2019
 * com.cleanup.todoc.utils
 */
public class Utils {
    /**
     * Sets the data of the Spinner with projects to associate to a new task
     */
    public static void populateDialogSpinner(Spinner spinner, List<Project> list, Context context) {
        Project[] p = Project.getAllProjects();
        for (Project projet : p){
            list.add(projet);
        }
        final ArrayAdapter<Project> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }
}
