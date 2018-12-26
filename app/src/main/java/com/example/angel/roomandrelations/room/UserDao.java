package com.example.angel.roomandrelations.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public abstract class UserDao {

    @Insert
    public abstract void insertSingleUser(User user);

    @Insert
    public abstract void insertUsers(User ... users);

    @Query("SELECT * FROM users WHERE id =:id")
    public abstract User retrieveSingleUser(Long id);

    @Query("SELECT * FROM users WHERE name =:name")
    public abstract User retrieveUserByName(String name);

}
