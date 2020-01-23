package com.bank.controller;

import com.bank.UserInput;
import com.bank.domain.User;
import com.bank.service.UserService;
import com.bank.view.View;

import java.util.Arrays;

public class MenuController {
    private final UserService userService;
    private final View view;

    public MenuController(UserService userService, View view) {
        this.userService = userService;
        this.view = view;
    }

    public void loginMenu() {
        while (true) {
            view.print("Welcome, choose an option:\n 1 - register\n 2 - login\n 3 - exit");
            String email;
            String password;
            switch (UserInput.getInputAsInt()) {
                case 1:
                    view.print("Enter email");
                    email = UserInput.getInputAsString();
                    view.print("Enter password");
                    password = UserInput.getInputAsString();
                    userService.register(User.builder().withEmail(email).withPassword(password).build());
                    view.print("You have successfully registered");
                    break;
                case 2:
                    view.print("Enter email");
                    email = UserInput.getInputAsString();
                    view.print("Enter password");
                    password = UserInput.getInputAsString();
                    userService.login(email, password);
                    view.print("You have successfully logged in");
                    findMenu();
                    break;
                case 3:
                    return;

            }
        }
    }

    private void findMenu() {
        while (true) {
            view.print("1 - find all users\n 2 - find user by id\n 3 - find user by email\n 4 - return to login page");

            switch (UserInput.getInputAsInt()) {
                case 1:
                    view.print("Enter page number to look in");
                    view.print(Arrays.deepToString(userService.findAll(UserInput.getInputAsInt()).toArray()));
                    break;
                case 2:
                    view.print("Enter user id");
                    view.print(userService.findById(UserInput.getInputAsInt()).toString());
                    break;
                case 3:
                    view.print("Enter user email");
                    view.print(userService.findByEmail(UserInput.getInputAsString()).toString());
                    break;
                case 4:
                    return;

            }
        }
    }

}
