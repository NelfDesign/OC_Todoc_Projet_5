package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

/**
 * Created by Nelfdesign at 11/10/2019
 * com.cleanup.todoc.repositories
 */
public class ProjectDataRepository {

    //Field
    private final ProjectDao mProjectDao;

    //constructor
    public ProjectDataRepository(ProjectDao projectDao){
        this.mProjectDao = projectDao;
    }

    // --- GET ---

    public LiveData<Project> getProject(long projectId){
        return this.mProjectDao.getProject(projectId);
    }


    public LiveData<List<Project>> getProjects() {
        return this.mProjectDao.getProjects();
    }

}
