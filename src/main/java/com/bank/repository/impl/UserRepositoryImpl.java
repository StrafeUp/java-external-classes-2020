package com.bank.repository.impl;


import com.bank.domain.User;
import com.bank.repository.Page;
import com.bank.repository.UserRepository;
import com.bank.utility.CollectionUtility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Integer, User> userIdToUser = new HashMap<>();
    private static int counter = 0;

    @Override
    public Optional<User> findByEmail(String email) {
        return userIdToUser.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public void save(User entity) {
        userIdToUser.put(entity.getId(), entity);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(userIdToUser.get(id));
    }

    @Override
    public long count() {
        return userIdToUser.size();
    }

    @Override
    public List<User> findAll(int page, int itemsPerPage) {
        return CollectionUtility.nullSafeListInitialize(userIdToUser.values().stream().skip((page - 1) * itemsPerPage).limit(itemsPerPage).collect(Collectors.toList()));
    }

    @Override
    public Pageable<User> findAll(Page page) {
        int pageNumber = page.getPageNumber();
        int itemsPerPage = page.getItemsPerPage();
        long maxPageNumber = count();

        return new Pageable<>(findAll(pageNumber, itemsPerPage), pageNumber, itemsPerPage, (int) maxPageNumber);
    }

    @Override
    public void update(User entity) {
        userIdToUser.replace(entity.getId(), entity);
    }

    @Override
    public void deleteById(Integer id) {
        userIdToUser.remove(id);
    }
}
