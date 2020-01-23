package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.injector.ApplicationInjector;
import com.bank.service.PasswordEncryptor;
import com.bank.service.UserService;
import com.bank.service.exception.ValidationException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserServiceImplTest {

    private static final ApplicationInjector APPLICATION_INJECTOR = ApplicationInjector.getInstance();
    private static final UserService USER_SERVICE = APPLICATION_INJECTOR.getUserService();
    private static final List<User> users = new ArrayList<>();

/*    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();*/

    @BeforeClass
    public static void init() {
        User user0 = User.builder().withId(0).withEmail("aazsbv@asnd.com").withPassword("dasjkdls1q").build();
        User user1 = User.builder().withId(1).withEmail("abvfsa@asnd.com").withPassword("fgsahjk2sa").build();
        User user2 = User.builder().withId(2).withEmail("absadv@asnd.com").withPassword("daghksjlasd").build();
        User user3 = User.builder().withId(3).withEmail("abxcv@asnd.com").withPassword("tyuiascxa").build();
        User user4 = User.builder().withId(4).withEmail("abwqv@asnd.com").withPassword("poiuyfgcvbnm").build();
        User user5 = User.builder().withId(5).withEmail("abxcqv@asnd.com").withPassword("savhjdgks").build();

        USER_SERVICE.register(user0);
        USER_SERVICE.register(user1);
        USER_SERVICE.register(user2);
        USER_SERVICE.register(user3);
        USER_SERVICE.register(user4);
        USER_SERVICE.register(user5);

        users.add(user0);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    @Test
    public void loginShouldProceed() {
        boolean actual = USER_SERVICE.login("aazsbv@asnd.com", "dasjkdls1q");
        assertEquals(true, actual);
    }

    @Test
    public void registerShouldReturnSameUser() {
        User userToRegister = User.builder().withId(6).withEmail("aasbvkes@asnd.com").withPassword("das123jkdls1q").build();
        User registeredUser = USER_SERVICE.register(userToRegister);
        assertEquals(userToRegister, registeredUser);
    }

    @Test
    public void findAllUsersOnPageOne() {
        List<User> all = USER_SERVICE.findAll(1);
        assertThat(all, is(users));
    }

    @Test
    public void findById() {
        User byId = USER_SERVICE.findById(1);
        User user1 = User.builder().withId(1).withEmail("abvfsa@asnd.com").withPassword("fgsahjk2sa").build();
        assertEquals(byId, user1);
    }

    @Test
    public void findByEmail() {
        User user3 = User.builder().withId(3).withEmail("abxcv@asnd.com").withPassword("tyuiascxa").build();
        User byEmail = USER_SERVICE.findByEmail("abxcv@asnd.com");
        assertEquals(byEmail, user3);
    }
}