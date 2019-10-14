package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

/**
 * Created by Nelfdesign at 11/10/2019
 * com.cleanup.todoc.repositories
 */
public class TaskDataRepository {

    private final TaskDao mTaskDao;

    // Constructor
    public TaskDataRepository(TaskDao taskDao){
        this.mTaskDao = taskDao;
    }

    //Getter
    public LiveData<List<Task>> getTask(long taskId){
        return this.mTaskDao.getTask(taskId);
    }

    //Create
    public void createTask(Task task){
        mTaskDao.insertTask(task);
    }
    // Update
    public void updateTask(Task task){
        mTaskDao.updateTask(task);
    }
    //Delete
    public void deleteTask(long taskId){
        mTaskDao.deleteTask(taskId);
    }
}
