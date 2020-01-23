package com.bank;


import com.bank.controller.MenuController;
import com.bank.domain.User;
import com.bank.injector.ApplicationInjector;
import com.bank.service.UserService;

public class ConsoleApplication {

    public static void main(String[] args) {
        ApplicationInjector injector = ApplicationInjector.getInstance();
        UserService userService = injector.getUserService();
        MenuController menuController = injector.getMenuController();
        menuController.loginMenu();

        User user = User.builder()
                .withId(1)
                .withEmail("email@email.com")
                .withPassword("password")
                .withAccounts(null)
                .build();
    }

}
