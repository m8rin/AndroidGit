package com.example.lab7;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import static org.xmlpull.v1.XmlPullParser.TEXT;

//define table name
@Entity(tableName = "table_name")
public class MainData {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "teacher")
    private String teacher;

    @ColumnInfo(name = "subject")
    private String subject;

    @ColumnInfo(name = "cabinet")
    private String cabinet;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String name) {
        this.teacher = name;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getCabinet() {
        return cabinet;
    }
}

