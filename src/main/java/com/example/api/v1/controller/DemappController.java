package com.example.api.v1.controller;

import com.example.api.v1.common.Obj;
import com.example.service.ServiceLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class DemappController {

    @Autowired
    private ServiceLayer serviceLayer;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public List<Integer> getDemappDataTest() {
        List<Integer> result = Arrays.asList(1, 2, 3);
        logger.info("GET: Result {}: ", result);
        return result;
    }

    @GetMapping("/fetch/{index}")
    public List<Integer> getDemappData(@PathVariable Integer index) {
        List<Integer> result = this.serviceLayer.retrieveData(index);
        logger.info("GET: Result {}: ", result);
        return result;
    }

    @PostMapping("/submit")
    public Boolean postDemappData(@RequestBody Obj obj) {
        Boolean result = this.serviceLayer.submitData(obj.getIndex(), obj.getData());
        logger.info("POST: [ index:{}, data:{} ] -> {}: ", obj.getIndex(), obj.getData(), result);
        return result;
    }

}
