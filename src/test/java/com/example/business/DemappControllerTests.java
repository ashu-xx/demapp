package com.example.business;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DemappControllerTests {

    @Autowired
    DemappController demappController;

    @Test
    void testEndpointGet_test() {
        assertEquals(Arrays.asList(1, 2, 3), this.demappController.getDemappDataTest());
    }

    @Test
    void testEndpointGet_fetch_nonExisting() {
        assertEquals(Arrays.asList(), this.demappController.getDemappData(1));
    }

    @Test
    void testEndpointGet_fetch_submit() {
        Obj obj = new Obj();
        obj.setIndex(10);
        obj.setData(Arrays.asList(1, 2, 3));
        assertEquals(true, this.demappController.postDemappData(obj));
    }

    @Test
    void testEndpointGet_fetch_submit_twice() {
        Obj obj = new Obj();
        obj.setIndex(100);
        obj.setData(Arrays.asList(1, 2, 3));
        assertEquals(true, this.demappController.postDemappData(obj));
        assertEquals(false, this.demappController.postDemappData(obj));
    }

    @Test
    void testEndpointGet_fetch_submit_retrieve() {
        Obj obj = new Obj();
        obj.setIndex(1000);
        obj.setData(Arrays.asList(1, 2, 3));
        assertEquals(true, this.demappController.postDemappData(obj));
        assertEquals(obj.getData(), this.demappController.getDemappData(obj.getIndex()));
    }
}
