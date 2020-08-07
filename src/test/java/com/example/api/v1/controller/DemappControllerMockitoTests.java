package com.example.api.v1.controller;

import com.example.api.v1.common.Obj;
import com.example.service.ServiceLayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DemappControllerMockitoTests {

    @InjectMocks
    DemappController demappController;

    @Mock
    ServiceLayer serviceLayerMock;

    @Test
    void testEndpoint_test() {
        assertEquals(Arrays.asList(1, 2, 3), this.demappController.getDemappDataTest());
    }

    @Test
    void testEndpoint_fetch_nonExisting() {
        Mockito.when(this.serviceLayerMock.retrieveData(1)).thenReturn(Collections.emptyList());
        assertEquals(Collections.emptyList(), this.demappController.getDemappData(1));
    }

    @Test
    void testEndpoint_fetch_submit() {
        Obj obj = new Obj();
        obj.setIndex(10);
        obj.setData(Arrays.asList(1, 2, 3));

        Mockito.when(this.serviceLayerMock.submitData(obj.getIndex(), obj.getData())).thenReturn(true);
        assertEquals(true, this.demappController.postDemappData(obj));
    }

    @Test
    void testEndpoint_fetch_submit_twice() {
        Obj obj = new Obj();
        obj.setIndex(100);
        obj.setData(Arrays.asList(1, 2, 3));

        Mockito.when(this.serviceLayerMock.submitData(obj.getIndex(), obj.getData())).thenReturn(true).thenReturn(false);
        assertTrue(this.demappController.postDemappData(obj));
        assertFalse(this.demappController.postDemappData(obj));
    }

    @Test
    void testEndpoint_fetch_submit_retrieve() {
        Obj obj = new Obj();
        obj.setIndex(1000);
        obj.setData(Arrays.asList(1, 2, 3));

        Mockito.when(this.serviceLayerMock.submitData(obj.getIndex(), obj.getData())).thenReturn(true);

        assertTrue(this.demappController.postDemappData(obj));

        Mockito.when(this.serviceLayerMock.retrieveData(obj.getIndex())).thenReturn(obj.getData());
        assertEquals(obj.getData(), this.demappController.getDemappData(obj.getIndex()));
    }

}
