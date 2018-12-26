package com.example.angel.roomandrelations.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import java.util.List;

@Dao
public interface UserPetDao {

    @Transaction
    @Query("SELECT * FROM users")
    List<UserAndAllPets> loadUserAndPets();
}
