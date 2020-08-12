package com.example.api.v1.controller;

import com.example.api.v1.common.Obj;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DemappControllerTests {

    @Autowired
    DemappController demappController;

    @Test
    void testEndpoint_test() {
        assertEquals(Arrays.asList(1, 2, 3), this.demappController.getDemappDataTest());
    }

    @Test
    void testEndpoint_fetch_nonExisting() {
        assertEquals(Collections.emptyList(), this.demappController.getDemappData(1));
    }

    @Test
    void testEndpoint_submit() {
        Obj obj = new Obj(10, Arrays.asList(1, 2, 3));
        assertEquals(true, this.demappController.postDemappData(obj));
    }

    @Test
    void testEndpoint_submit_twice() {
        Obj obj = new Obj(100, Arrays.asList(1, 2, 3));
        assertTrue(this.demappController.postDemappData(obj));
        assertFalse(this.demappController.postDemappData(obj));
    }

    @Test
    void testEndpoint_submit_retrieve() {
        Obj obj = new Obj(1000, Arrays.asList(1, 2, 3));
        assertTrue(this.demappController.postDemappData(obj));
        assertEquals(obj.getData(), this.demappController.getDemappData(obj.getIndex()));
    }

    @Test
    void testEndpoint_remove_nonExisting() {
        assertEquals(Collections.emptyList(), this.demappController.removeDemappData(999));
    }

    @Test
    void testEndpoint_submit_remove_retrieve() {
        Obj obj = new Obj(10000, Arrays.asList(1, 2, 3));

        assertTrue(this.demappController.postDemappData(obj));
        assertEquals(obj.getData(), this.demappController.getDemappData(obj.getIndex()));

        assertEquals(obj.getData(), this.demappController.removeDemappData(obj.getIndex()));
        assertEquals(Collections.emptyList(), this.demappController.getDemappData(obj.getIndex()));
    }
}
