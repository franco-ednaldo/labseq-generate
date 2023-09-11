package com.example.labseq.application.core.domain;

import java.util.HashMap;

public class CacheSeq {
    private final HashMap<Long, Long> cache;

    public CacheSeq() {
        this.cache = new HashMap<>();
    }

    public boolean containsKey(Long key) {
        return this.cache.containsKey(key);
    }

    public Long get(Long key) {
        return this.cache.get(key);
    }

    public void put(Long key, Long value) {
        this.cache.put(key, value);
    }
}
