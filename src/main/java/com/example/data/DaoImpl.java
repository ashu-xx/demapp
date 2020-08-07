package com.example.data;

import com.example.aspect.TrackTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class DaoImpl implements Dao {

    @Autowired
    private DaoStorage storage;

    @Override
    @TrackTime
    public List<Integer> retrieveData(Integer index) {
        if (index == 1) {
            return Arrays.asList(9,9,9);
        } else {
            return this.storage.retrieve(index);
        }
    }

    @Override
    @TrackTime
    public Boolean submitData(Integer index, List<Integer> data) {
        return this.storage.submit(index, data);
    }
}
