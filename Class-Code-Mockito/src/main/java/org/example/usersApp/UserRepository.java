package org.example.usersApp;

import java.util.ArrayList;
import java.util.Arrays;

// database layer
// model
// this is the layer that communicates with the "database"
public class UserRepository {

    public static ArrayList<User> users = new ArrayList<>();

    static{
        users.addAll(Arrays.asList(
                new User(1,"Kai"),
                new User(2,"Sumayya"),
                new User(3,"Maryam"),
                new User(4,"Mihai")

        ));
    }

    public ArrayList<User> getAllUsersFromDB(){
        return users;
    }

    public User createNewUser(String name, int id){
        User newUser = new User(id,name);
        users.add(newUser);
        return newUser;
    }

    public User findByIdFromDB(int id){
        for(User user : users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }



}
