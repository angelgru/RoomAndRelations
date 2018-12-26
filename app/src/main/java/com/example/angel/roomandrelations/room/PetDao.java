package com.example.angel.roomandrelations.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface PetDao {

    @Insert
    void insertSinglePet(Pet pet);

}
