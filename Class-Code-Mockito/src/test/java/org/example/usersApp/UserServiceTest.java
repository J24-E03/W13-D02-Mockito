package org.example.usersApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    void getUserNameById() {

//        arrange
        User user = new User(1,"John");
        when(userRepository.findByIdFromDB(1)).thenReturn(user); // stubbing

//        Act
        String foundUsername = userService.getUserNameById(1);

//        Verify
        assertEquals("John",foundUsername);
        verify(userRepository,times(1)).findByIdFromDB(1);
    }


//    EXERCISE 1: Write a test to check if there is no user associated with the id
//                Stub the method for findByIdFromDB(99) to make sure this returns a null value
//                Check if "User Not Found" is returned by our method in the Service layer

    @Test
    void userNotFound() {
        when(userRepository.findByIdFromDB(99)).thenReturn(null);

        String foundUser = userService.getUserNameById(99);
        assertEquals("User Not Found", foundUser);
    }

    @Test
    void getAllUsers(){

//        Arrange

        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User(1, "Kai"),
                new User(2, "Sumayya"),
                new User(3, "Maryam"),
                new User(4, "Mihai")));

        when(userRepository.getAllUsersFromDB()).thenReturn(users); //stubbed method

//        act

        ArrayList<User> returnedUsers = userService.getAllUsers();

        assertEquals(4,returnedUsers.size());
        assertEquals("Sumayya",returnedUsers.get(1).getName());


    }


    @Test
    void createUserInDB(){

        User user = new User(1,"Kai");
        when(userRepository.createNewUserInDB("Kai",1)).thenReturn(user);


        User result = userService.createNewUser("Kai",1);

        assertNotNull(result);
        assertEquals(1,result.getId());
        assertEquals("Kai",result.getName());
    }


    @Test
    void createUserInDBInvalidInputs(){
        String name = null;
        int id = 1;

        assertThrows(IllegalArgumentException.class, ()->{
            userService.createNewUser(name,id);
        });
    }

    @Test
    void getUserFromDB2(){

        doThrow(new RuntimeException("User Not Found")).when(userRepository).findByIdFromDB2(99);

        RuntimeException runtimeException =  assertThrows(RuntimeException.class,()->{
            userService.getUserNameById(99);
        });

        assertEquals("User Not Found", runtimeException.getMessage());



    }


    /*
        Mockito cannot mock:
            1. Static methods
            2. final classes
            3. final methods
            4. private methods
    */

}