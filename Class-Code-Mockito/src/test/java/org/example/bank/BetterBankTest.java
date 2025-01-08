package org.example.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BetterBankTest {


    @BeforeEach
    void setUp() {
    }

    @Test
    void signUp() {

        String simulatedInputs = "\n" + "omar123\n" +
                                "password123\n" + "omar\n" +
                                "500\n";

        Scanner scanner = new Scanner(simulatedInputs);
        ArrayList<User> users = new ArrayList<>();

        BetterBank.signUp(scanner, users);

        assertEquals(1,users.size(),"User ArrayList should contain 1 user");

        User signedUpUser = users.get(0);

        assertEquals("omar123",signedUpUser.getUserName());
        assertEquals("password123",signedUpUser.getPassword());
        assertEquals("omar",signedUpUser.getFirstName());
        assertEquals(500,signedUpUser.getAccount().getBalance());





    }

    @Test
    void login() {
    }
}