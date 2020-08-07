package com.example.business;

import com.example.data.Dao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DemappControllerMockitoTests {

    @InjectMocks
    DemappController demappController;

    @Mock
    Dao daoMock;

    @Test
    void testEndpoint_test() {
        assertEquals(Arrays.asList(1, 2, 3), this.demappController.getDemappDataTest());
    }

    @Test
    void testEndpoint_fetch_nonExisting() {
        Mockito.when(daoMock.retrieveData(1)).thenReturn(Arrays.asList());
        assertEquals(Arrays.asList(), this.demappController.getDemappData(1));
    }

    @Test
    void testEndpoint_fetch_submit() {
        Obj obj = new Obj();
        obj.setIndex(10);
        obj.setData(Arrays.asList(1, 2, 3));

        Mockito.when(daoMock.submitData(obj.getIndex(), obj.getData())).thenReturn(true);
        assertEquals(true, this.demappController.postDemappData(obj));
    }

    @Test
    void testEndpoint_fetch_submit_twice() {
        Obj obj = new Obj();
        obj.setIndex(100);
        obj.setData(Arrays.asList(1, 2, 3));

        Mockito.when(daoMock.submitData(obj.getIndex(), obj.getData())).thenReturn(true);
        assertTrue(this.demappController.postDemappData(obj));

        Mockito.when(daoMock.submitData(obj.getIndex(), obj.getData())).thenReturn(false);
        assertFalse(this.demappController.postDemappData(obj));
    }

    @Test
    void testEndpoint_fetch_submit_retrieve() {
        Obj obj = new Obj();
        obj.setIndex(1000);
        obj.setData(Arrays.asList(1, 2, 3));

        Mockito.when(daoMock.submitData(obj.getIndex(), obj.getData())).thenReturn(true);
        assertTrue(this.demappController.postDemappData(obj));

        Mockito.when(daoMock.retrieveData(obj.getIndex())).thenReturn(obj.getData());
        assertEquals(obj.getData(), this.demappController.getDemappData(obj.getIndex()));
    }

}
