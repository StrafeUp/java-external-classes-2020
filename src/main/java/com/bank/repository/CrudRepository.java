package com.bank.repository;


import com.bank.repository.impl.Pageable;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E> {
    //create
    void save(E entity);

    //read
    Optional<E> findById(Integer id);



    List<E> findAll(int page, int itemsPerPage);

    default Pageable<E> findAll(Page page) {
        return null;
    }

    // Get count of all elements
    long count();
    //update
    void update(E entity);

    //delete
    void deleteById(Integer id);
}
