package com.cleanup.todoc.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.SortMethod;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by Nelfdesign at 11/10/2019
 * com.cleanup.todoc.ui
 */
public class TaskViewModel extends ViewModel {

    //REPOSITORY
    private final ProjectDataRepository mProjectDataRepository;
    private final TaskDataRepository mTaskDataRepository;
    private final Executor mExecutor;

    //DATA
    @Nullable
    private LiveData<List<Project>> projects;

    public TaskViewModel(ProjectDataRepository projectDataRepository, TaskDataRepository taskDataRepository, Executor executor) {
        this.mProjectDataRepository = projectDataRepository;
        this.mTaskDataRepository = taskDataRepository;
        this.mExecutor = executor;
    }

    public void init() {
        // PROJECTS
        if (this.projects == null) {
            this.projects = this.mProjectDataRepository.getProjects();
        }
    }

    // task
    public LiveData<List<Task>> getTask(long taskId){
        return mTaskDataRepository.getTask(taskId) ;
    }

    public LiveData<List<Task>> getAllTask(){
        return this.mTaskDataRepository.getAllTasks();
    }

    public void createTask(final Task task) {
        this.mExecutor.execute(() -> {
            this.mTaskDataRepository.createTask(task);
        });
    }

    public void deleteTask(long itemId) {
        mExecutor.execute(() -> {
            mTaskDataRepository.deleteTask(itemId);
        });
    }

    public void updateTask(Task task) {
        mExecutor.execute(() -> {
            mTaskDataRepository.updateTask(task);
        });
    }

    public LiveData<List<Project>> getAllProjects(){
        return this.projects;
    }
}
