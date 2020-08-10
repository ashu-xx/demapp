package com.example.api.v1.common;

import java.util.List;

public class Obj {
    private Integer index;

    public Obj(Integer index, List<Integer> data) {
        this.index = index;
        this.data = data;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    private List<Integer> data;

    public Integer getIndex() {
        return index;
    }
    public List<Integer> getData() {
        return data;
    }
}
