package org.example.bank;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BetterBank {

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static User loggedInUser;
    public static int staticIds = 1;

    public static void main(String[] args) {
        loadAllData();
        displayCredentialsOptions();
        writeToFileOnceDone(users);
    }

    public static void displayCredentialsOptions() {
        while (true) {
            printCredentialsMenu();
            int choice = getUserInputInt();

            switch (choice) {
                case 1:
                    signUp(scanner, users);
                    break;
                case 2:
                    loggedInUser = login(scanner,users);
                    showOptionsForLoggedInUser();
                    break;
                case 3:
                    System.out.println("Thank you for coming, come again!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void printCredentialsMenu() {
        System.out.println("Hello, welcome to our bank");
        System.out.println("Pick one of the following options by inputting a number:");
        System.out.println("1. Signup");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }

    public static int getUserInputInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    public static void signUp(Scanner scanner, ArrayList<User> users) {
        System.out.println("Please input your username:");
        scanner.nextLine(); // Consume leftover newline
        String inputtedUsername = scanner.nextLine().toLowerCase().trim();

        System.out.println("Please input your password:");
        String inputtedPassword = scanner.nextLine().trim();

        System.out.println("Please input your first name:");
        String inputtedFirstName = scanner.nextLine().trim();

        System.out.println("How much money are you inputting today?");
        int inputtedMoney = scanner.nextInt();



        Account newAccount = new CheckingAccount(staticIds, inputtedMoney);
        staticIds += 1;

        users.add(new User(inputtedUsername, inputtedFirstName, inputtedPassword, newAccount));

        System.out.println("Congrats! Your user has been created. Now, please log in.");
    }

    public static void createUser(String username, String password, String firstName, int money) {
    }


    public static User login(Scanner scanner, ArrayList<User> users) {
        System.out.println("Please input your username:");
        scanner.nextLine(); // Consume leftover newline
        String inputtedUsername = scanner.nextLine();

        System.out.println("Please input your password:");
        String inputtedPassword = scanner.nextLine();

        boolean isMatched = false;
        User foundUser = null;

        for (User user : users) {
            if (user.getUserName().equals(inputtedUsername) && user.getPassword().equals(inputtedPassword)) {
                isMatched = true;
                foundUser = user;
                break;
            }
        }

        if (isMatched) {

            System.out.println("You are logged in.");
            return foundUser;
        } else {
            System.out.println("Wrong username or password.");
            return null;
        }
    }

    public static void showOptionsForLoggedInUser() {
        while (true) {
            printUserOptions();
            int chosenOption = getUserInputInt();

            switch (chosenOption) {
                case 1:
                    System.out.println("Here is your current balance: " + loggedInUser.getAccount().getBalance());
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you, come back again!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void printUserOptions() {
        System.out.println("What do you want to do now?");
        System.out.println("1. Show Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Logout");
    }

    public static void deposit() {
        System.out.println("How much would you like to deposit?");
        int amount = scanner.nextInt();
        loggedInUser.getAccount().deposit(amount);
        System.out.println("Deposited " + amount + ". Your new balance is: " + loggedInUser.getAccount().getBalance());
    }

    public static void withdraw() {
        System.out.println("How much would you like to withdraw?");
        int amount = scanner.nextInt();

        if (loggedInUser.getAccount().getBalance() - amount < 0) {
            System.out.println("You cannot withdraw more than your balance.");
        } else if (amount > 5000) {
            System.out.println("Your account has a limit of $5000.");
        } else {
            System.out.println("SUCCESS!");
            System.out.println("Your old balance is " + loggedInUser.getAccount().getBalance());
            System.out.println("Your new balance is " + loggedInUser.getAccount().withdraw(amount));
        }
    }

    public static void loadAllData() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    Account account = new CheckingAccount(Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                    User user = new User(data[0], data[1], data[2], account);
                    users.add(user);
                    accounts.add(account);
                }
            }
            staticIds = !accounts.isEmpty() ?  accounts.get(accounts.size()-1).getAccountNumber() + 1: 1;
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }

    public static void writeToFileOnceDone(ArrayList<User> users) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt"))) {
            for (User user : users) {
                bufferedWriter.write(user.parseToCSV());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

}
