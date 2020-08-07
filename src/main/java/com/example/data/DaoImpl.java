package com.example.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DaoImpl implements Dao {

    private Map<Integer, List<Integer>> store = new HashMap<>();

    public List<Integer> retrieve(Integer key) {
        return this.store.getOrDefault(key, new ArrayList<Integer>());
    }

    public Boolean submit(Integer key, List<Integer> data) {
        if (this.store.containsKey(key)) {
            return false;
        } else {
            this.store.put(key, data);
            return true;
        }
    }
}
