package com.bank.service.impl;


import com.bank.service.PasswordEncryptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class PasswordEncryptorImpl implements PasswordEncryptor {
    private static final Logger logger = LogManager.getLogger(PasswordEncryptorImpl.class);
    private static final SecureRandom random = new SecureRandom();

    private static final int HASH_SIZE_BYTES = 16;
    public static final int ITERATION_COUNT = 65536;
    public static final int KEY_LENGTH = 128;

    private byte[] salt = new byte[HASH_SIZE_BYTES];

    {
        random.nextBytes(salt);
    }

    @Override
    public String encrypt(String inputString) {


        KeySpec spec = new PBEKeySpec(inputString.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
        SecretKeyFactory factory;

        byte[] hash = new byte[0];

        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = factory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            logger.error(e);
        }
        return Arrays.toString(hash);
    }
}

