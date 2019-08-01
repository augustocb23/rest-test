package com.augus.restTest.domain.dto;

import java.util.List;

public class LazyList<T> {
    private int length;
    private List<T> payload;

    public LazyList(List<T> payload, int length) {
        this.length = length;
        this.payload = payload;
    }

    public int getLength() {
        return length;
    }

    public List<T> getPayload() {
        return payload;
    }
}
