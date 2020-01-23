package com.bank.injector;


import com.bank.controller.MenuController;
import com.bank.domain.User;
import com.bank.repository.UserRepository;
import com.bank.repository.impl.UserRepositoryImpl;
import com.bank.service.PasswordEncryptor;
import com.bank.service.UserService;
import com.bank.service.Validator;
import com.bank.service.impl.PasswordEncryptorImpl;
import com.bank.service.impl.UserServiceImpl;
import com.bank.service.impl.validator.UserValidator;
import com.bank.view.View;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();
    private static final Validator<User> USER_VALIDATOR = new UserValidator();
    private static final PasswordEncryptor PASSWORD_ENCRYPTOR = new PasswordEncryptorImpl();
    private static final UserRepository USER_REPOSITORY = new UserRepositoryImpl();
    private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRYPTOR, USER_VALIDATOR);
    private static final View VIEW = new View();
    private static final MenuController MENU_CONTROLLER = new MenuController(USER_SERVICE, VIEW);

    private ApplicationInjector() {
    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return USER_SERVICE;
    }

    public static MenuController getMenuController() {
        return MENU_CONTROLLER;
    }
}
