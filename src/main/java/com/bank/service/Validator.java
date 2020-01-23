package com.bank.service;

public interface Validator<E> {
    void validate(E entity);
}
