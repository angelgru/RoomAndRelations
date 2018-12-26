package com.example.angel.roomandrelations.room;

import android.arch.persistence.room.Relation;

import java.util.List;

public class UserAndAllPets {

    private Long id;
    private String name;
    @Relation(entity = Pet.class, parentColumn = "id", entityColumn = "user_id")
    private List<Pet> pets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
