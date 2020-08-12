package com.example.data.springjpa;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import javax.persistence.*;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Entity
public class DaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    Integer key;

    @Column
    Integer data;

    @Override
    public String toString() {
        return "DaoEntity{" +
                "id=" + id +
                ", key=" + key +
                ", data=" + data +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public DaoEntity() {}

    public DaoEntity(Integer key, Integer data) {
        super();
        this.key = key;
        this.data = data;
    }

    public static Example<DaoEntity> getKeyMatcherExampleExact(Integer key) {
        DaoEntity probe = new DaoEntity();
        probe.setKey(key);
        return Example.of(probe, ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("key", exact()));
    }

}
