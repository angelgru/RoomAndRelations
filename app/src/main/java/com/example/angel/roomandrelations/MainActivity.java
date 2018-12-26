package com.example.angel.roomandrelations;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.angel.roomandrelations.room.MyDatabase;
import com.example.angel.roomandrelations.room.Pet;
import com.example.angel.roomandrelations.room.User;
import com.example.angel.roomandrelations.room.UserAndAllPets;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = Room.inMemoryDatabaseBuilder(
                getApplicationContext(),
                MyDatabase.class)
                .build();

        new InsertUserAsyncTask().execute();
    }

    private class InsertUserAsyncTask extends AsyncTask<Void, Void, List<UserAndAllPets>> {

        @Override
        protected List<UserAndAllPets> doInBackground(Void... voids) {
//            Insert Users
            User user = new User("Angel");
            User user1 = new User("Mara");
            myDatabase.userDao().insertUsers(user, user1);

//            Insert Pets
            User returnedUser = myDatabase.userDao().retrieveUserByName("Angel");
            Pet pet = new Pet("Dancho", returnedUser.getId());
            myDatabase.petDao().insertSinglePet(pet);

            return myDatabase.userPetDao().loadUserAndPets();
        }

        @Override
        protected void onPostExecute(List<UserAndAllPets> userAndAllPets) {
            super.onPostExecute(userAndAllPets);

            Log.e("UserAndAllPetsList",
                    "The user " + userAndAllPets.get(0).getName() + " is the owner of " +
            userAndAllPets.get(0).getPets().get(0).getName());
        }
    }
}
