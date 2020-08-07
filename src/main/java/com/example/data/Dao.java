package com.example.data;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface Dao {

    public List<Integer> retrieve(Integer key);

    public List<Integer> remove(Integer key);

    public Boolean submit(Integer key, List<Integer> data);
}
