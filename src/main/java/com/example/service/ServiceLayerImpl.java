package com.example.service;

import com.example.aspect.TrackTime;
import com.example.data.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayerImpl implements ServiceLayer {

    @Autowired
    private Dao dao;

    @Override
    @TrackTime
    public List<Integer> retrieveData(Integer index) {
        return this.dao.retrieve(index);
    }

    @Override
    @TrackTime
    public Boolean submitData(Integer index, List<Integer> data) {
        return this.dao.submit(index, data);
    }

}
