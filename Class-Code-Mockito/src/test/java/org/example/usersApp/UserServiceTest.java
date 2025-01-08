package org.example.usersApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito.*;

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

        User user = new User(1,"John");
        when(userRepository.findByIdFromDB(1)).thenReturn(user);


        String foundUsername = userService.getUserNameById(1);

        assertEquals("John",foundUsername);
    }
}