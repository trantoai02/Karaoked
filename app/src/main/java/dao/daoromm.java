package dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import androidx.lifecycle.LiveData;

import com.example.karaoke.model.room;

import java.util.List;

public interface daoromm {
    @Insert
    void insert(room model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(room model);

    // below line is use to delete a
    // specific course in our database.
    @Delete
    void delete(room model);

    // on below line we are making query to
    // delete all courses from our database.
    @Query("DELETE FROM BaiHat_TBL")
    void deleteAllCourses();

    // below line is to read all the courses from our database.
    // in this we are ordering our courses in ascending order
    // with our course name.
    @Query("SELECT * FROM BaiHat_TBL ORDER BY TENBH ASC")
    LiveData<List<room>> getAllCourses();
}
