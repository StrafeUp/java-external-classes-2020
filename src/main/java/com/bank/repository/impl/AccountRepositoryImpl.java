package com.bank.repository.impl;

import com.bank.domain.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.Page;
import com.bank.utility.CollectionUtility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {

    private final Map<Integer, Account> accountOfUser = new HashMap<>();

    @Override
    public void save(Account entity) {
        accountOfUser.put(entity.getId(), entity);
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.ofNullable(accountOfUser.get(id));
    }

    @Override
    public long count() {
        return accountOfUser.size();
    }

    @Override
    public List<Account> findAll(int page, int itemsPerPage) {
        return null;
    }

    @Override
    public Pageable<Account> findAll(Page page) {
        return null;
    }

    public List<Account> findAll() {
        return CollectionUtility.nullSafeListInitialize((List<Account>) accountOfUser.values());
    }

    @Override
    public void update(Account entity) {
        accountOfUser.replace(entity.getId(), entity);
    }

    @Override
    public void deleteById(Integer id) {
        accountOfUser.remove(id);
    }
}
