package com.michelbchopra.karpagaaa;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mycontacts")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    int id;

    public Contact(String conatact_Name, String contact_Number) {
        Conatact_Name = conatact_Name;
        Contact_Number = contact_Number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConatact_Name() {
        return Conatact_Name;
    }

    public void setConatact_Name(String conatact_Name) {
        Conatact_Name = conatact_Name;
    }

    public String getContact_Number() {
        return Contact_Number;
    }

    public void setContact_Number(String contact_Number) {
        Contact_Number = contact_Number;
    }

    @ColumnInfo(name = "c_name")
    String Conatact_Name;
    @ColumnInfo(name = "c_number")
    String Contact_Number;




}
