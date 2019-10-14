package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

/**
 * Created by Nelfdesign at 11/10/2019
 * com.cleanup.todoc.database.dao
 */
@Dao
public interface TaskDao {

    @Query("SELECT * FROM task WHERE id = :taskId")
    LiveData<List<Task>> getTask(long taskId);

    @Query("SELECT * FROM task")
    LiveData<List<Task>> getAllTasks();

    @Insert
    long insertTask(Task task);

    @Update
    int updateTask(Task task);

    @Query("DELETE FROM task WHERE id = :taskId")
    int deleteTask(long taskId);

}
