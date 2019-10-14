package com.cleanup.todoc.database.dao.classeDatabase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.concurrent.Executors;

/**
 * Created by Nelfdesign at 11/10/2019
 * com.cleanup.todoc.database.dao.classeDatabase
 */
@Database(entities = {Project.class, Task.class}, version = 1, exportSchema = false)
public abstract class TodocDatabase extends RoomDatabase {

    //Singleton
    private static volatile TodocDatabase INSTANCE;

    //DAO
    public abstract ProjectDao mProjectDao();
    public abstract TaskDao mTaskDao();

    //Instance
    public static TodocDatabase getInstance(Context context){
        if (INSTANCE == null) {
            synchronized (TodocDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    /*private static Callback prepopulateDatabase(final Context context){
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        getInstance(context).mProjectDao().insertAll(Project.getAllProjects());
                    }
                });
            }
        };
    }*/
    private static TodocDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                TodocDatabase.class, "my-database")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                for (Project p : Project.getAllProjects()){
                                    getInstance(context).mProjectDao().insertProject(p);
                                }
                            }
                        });
                    }
                })
                .build();
    }
}
