package com.bank.repository.impl;

import java.util.List;

public class Pageable<T> {
    private final List<T> items;
    private final int pageNumber;
    private final int itemsNumberPagePage;
    private final int maxPageNumber;

    public Pageable(List<T> items, int pageNumber, int itemsNumberPagePage, int maxPageNumber) {
        this.items = items;
        this.pageNumber = pageNumber;
        this.itemsNumberPagePage = itemsNumberPagePage;
        this.maxPageNumber = maxPageNumber;
    }

    public List<T> getItems() {
        return items;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getItemsNumberPagePage() {
        return itemsNumberPagePage;
    }

    public int getMaxPageNumber() {
        return maxPageNumber;
    }
}
