package com.bank.service.impl.validator;


import com.bank.domain.User;
import com.bank.service.Validator;
import com.bank.service.exception.ValidationException;

import java.util.function.Function;
import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("[^@]+@[^.]+\\..+");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^([a-zA-Z0-9]){8,20}$");
    private static final Pattern NEW_PASSWORD_PATTERN = Pattern.compile("\\[(.?)+]");
    private static final Pattern TELEPHONE_PATTERN = Pattern.compile("^\\+?(38)?(\\d{10,11})$");

    @Override
    public void validate(User user) {
        if (user == null) {
            throw new ValidationException("");
        }
        validateEmail(user);
        validatePassword(user);
        //validateTelephoneNumber(user);
    }

    private void validateEmail(User user) {
        validateString(EMAIL_PATTERN, user, User::getEmail, "Email doesn't match the pattern");
    }
    private void validatePassword(User user) {
        validateString(PASSWORD_PATTERN, user, User::getPassword, "Password doesn't match the pattern");
    }
    private void validateTelephoneNumber(User user) {
        validateString(TELEPHONE_PATTERN, user, User::getTelephoneNumber, "Telephone doesn't match the pattern");
    }


    private void validateString(Pattern pattern, User user, Function<User, String> function, String exceptionMessage) {
        if (!pattern.matcher(function.apply(user)).matches()) {
            throw new ValidationException(exceptionMessage);
        }
    }
}
