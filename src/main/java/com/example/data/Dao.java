package com.example.data;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dao {

    List<Integer> retrieveData(Integer index);

    Boolean submitData(Integer index, List<Integer> data);
}
