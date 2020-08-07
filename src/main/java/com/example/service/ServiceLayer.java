package com.example.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceLayer {

    List<Integer> retrieveData(Integer index);

    Boolean submitData(Integer index, List<Integer> data);
}
