package com.example.lab7;

import android.icu.text.Replaceable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {
    //Get all data query
    @Query("SELECT * FROM table_name ")
    List<MainData> getAll();

    //insert query
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    //Delete query
    @Delete
    void delete(MainData mainData);

    //Delete all query
    @Delete
    void reset(List<MainData> mainData);

    //Update query
    @Query("UPDATE table_name SET subject = :subject, teacher = :teacher, cabinet = :cabinet WHERE ID = :sID")
    void update (int sID,String subject, String teacher, String cabinet);

    @Query("SELECT * FROM table_name WHERE subject LIKE :search OR teacher LIKE :search")
    public List<MainData> getAllWithNameLike(String search);
}
