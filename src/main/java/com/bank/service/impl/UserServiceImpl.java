package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.repository.Page;
import com.bank.repository.UserRepository;
import com.bank.service.PasswordEncryptor;
import com.bank.service.UserService;
import com.bank.service.Validator;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final int USER_PER_PAGE = 5;

    private final UserRepository userRepository;
    private final PasswordEncryptor passwordEncryptor;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserRepository userRepository, PasswordEncryptor passwordEncryptor, Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncryptor = passwordEncryptor;
        this.userValidator = userValidator;
    }

    public boolean login(String email, String password) {
        String encryptedPassword = passwordEncryptor.encrypt(password);
        return userRepository.findByEmail(email)
                .map(User::getPassword)
                .filter(pass -> pass.equals(encryptedPassword))
                .isPresent();
    }

    public User register(User user) {
        userValidator.validate(user);
        userRepository.save(user);
        return userRepository.findById(user.getId()).get();
    }

    @Override
    public List<User> findAll(int page) {
        long maxPage = ((userRepository.count() % USER_PER_PAGE) != 0)
                ? userRepository.count() / USER_PER_PAGE + 1
                : userRepository.count() / USER_PER_PAGE;

        if (page <= 0) {
            page = 1;
        } else if (page > maxPage) {
            page = (int) maxPage;
        }

        return userRepository.findAll(new Page(page, USER_PER_PAGE)).getItems();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }


}