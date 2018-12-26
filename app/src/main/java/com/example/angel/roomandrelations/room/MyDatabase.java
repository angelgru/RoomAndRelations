package com.example.angel.roomandrelations.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class, Pet.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract UserPetDao userPetDao();

    public abstract UserDao userDao();

    public abstract PetDao petDao();
}
