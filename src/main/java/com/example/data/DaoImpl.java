package com.example.data;

import java.util.*;

public class DaoImpl implements Dao {

    private final Map<Integer, List<Integer>> store = new HashMap<>();

    @Override
    public List<Integer> retrieve(Integer key) {
        return this.store.getOrDefault(key, new ArrayList<Integer>());
    }

    @Override
    public Boolean submit(Integer key, List<Integer> data) {
        if (this.store.containsKey(key)) {
            return false;
        } else {
            this.store.put(key, data);
            return true;
        }
    }

    @Override
    public List<Integer> remove(Integer key) {
        final List<Integer> data = this.store.remove(key);
        if (data == null) {
            return Collections.emptyList();
        }
        return data;
    }
}
