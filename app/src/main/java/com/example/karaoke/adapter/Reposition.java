package com.example.karaoke.adapter;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.karaoke.model.room;
import com.example.karaoke.utils.dbroom;

import java.util.List;

import dao.daoromm;

public class Reposition {
    private  Reposition rps;
    private daoromm dao;
    private LiveData<List<room>>allRoom;
    public Reposition(Application application) {
        dbroom database = dbroom.getInstance(application);
        dao = (daoromm) database.daoromm();
        allRoom = dao.getAllCourses();
    }

    // creating a method to insert the data to our database.
    public void insert(room model) {
        new InsertCourseAsyncTask(dao).execute( model);
    }

    // creating a method to update data in database.
    public void update(CourseModal model) {
        new UpdateCourseAsyncTask(dao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(CourseModal model) {
        new DeleteCourseAsyncTask(dao).execute(model);
    }

    // below is the method to delete all the courses.
    public void deleteAllCourses() {
        new DeleteAllCoursesAsyncTask(dao).execute();
    }

    // below method is to read all the courses.
    public LiveData<List<CourseModal>> getAllCourses() {
        return allCourses;
    }

    // we are creating a async task method to insert new course.
    private static class InsertCourseAsyncTask extends AsyncTask<CourseModal, Void, Void> {
        private Dao dao;

        private InsertCourseAsyncTask(daoromm dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CourseModal... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }


    }
}
