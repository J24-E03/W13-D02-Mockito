package org.example.usersApp;

import java.util.ArrayList;

public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserNameById(int id){
        User foundUser = userRepository.findByIdFromDB2(id);
        return foundUser == null ? "User Not Found" : foundUser.getName();
    }

    public ArrayList<User> getAllUsers() {
        return userRepository.getAllUsersFromDB();
    }


    public User createNewUser(String name, int id) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        return userRepository.createNewUserInDB(name, id);
    }






}
