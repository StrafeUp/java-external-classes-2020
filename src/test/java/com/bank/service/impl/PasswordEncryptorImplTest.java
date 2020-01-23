package com.bank.service.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PasswordEncryptorImplTest {

    PasswordEncryptorImpl passwordEncryptor = new PasswordEncryptorImpl();

    @Test
    public void encryptedPasswordsMustMatch() {
        String pass1 = passwordEncryptor.encrypt("pass1");
        String pass2 = passwordEncryptor.encrypt("pass1");
        assertEquals(pass1, pass2);
    }
    @Test
    public void encryptedDifferentPasswordsMustNotMatch() {
        String pass1 = passwordEncryptor.encrypt("pass1");
        String pass2 = passwordEncryptor.encrypt("pass2");
        assertNotEquals(pass1, pass2);
    }
}