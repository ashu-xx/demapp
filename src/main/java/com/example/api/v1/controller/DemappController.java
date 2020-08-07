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
        final List<Integer> result = Arrays.asList(1, 2, 3);
        logger.info("GET: Result {}: ", result);
        return result;
    }

    @GetMapping("/fetch/{index}")
    public List<Integer> getDemappData(@PathVariable Integer index) {
        final List<Integer> result = this.serviceLayer.retrieveData(index);
        logger.info("GET: fetch {} Result {}: ", index, result);
        return result;
    }

    @GetMapping("/remove/{index}")
    public List<Integer> removeDemappData(@PathVariable Integer index) {
        final List<Integer> result = this.serviceLayer.removeData(index);
        logger.info("GET: remove [ index:{}, data:{} ]", index, result);
        return result;
    }

    @PostMapping("/submit")
    public Boolean postDemappData(@RequestBody Obj obj) {
        final Boolean result = this.serviceLayer.submitData(obj.getIndex(), obj.getData());
        logger.info("POST: submit [ index:{}, data:{} ] -> {}: ", obj.getIndex(), obj.getData(), result);
        return result;
    }

}
