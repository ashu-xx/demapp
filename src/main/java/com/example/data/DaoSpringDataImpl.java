package com.example.data;

import com.example.data.springjpa.DaoEntity;
import com.example.data.springjpa.DaoSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoSpringDataImpl implements Dao {

    @Autowired
    DaoSpringDataRepository repository;;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private boolean ifContains(Integer key) {

        logger.info(" ifContains {}", key);
        return this.repository.exists(DaoEntity.getKeyMatcherExampleExact(key));
    }

    @Override
    public List<Integer> retrieve(Integer key) {

        logger.info(" retrieve {}", key);
        List<Integer> result = new ArrayList<>();

        this.repository.findAll(DaoEntity.getKeyMatcherExampleExact(key))
                .forEach(elem -> result.add(elem.getData()));

        return result;
    }

    @Override
    public Boolean submit(Integer key, List<Integer> data) {

        logger.info(" submit {}", key);
        if (this.ifContains(key)) {
            return false;
        } else {
            data.forEach(elem -> this.repository.save(new DaoEntity(key, elem)));
            return true;
        }
    }

    @Override
    public List<Integer> remove(Integer key) {

        logger.info(" remove {}", key);
        List<Integer> data = this.retrieve(key);
        if (!data.isEmpty()) {
            List<DaoEntity> daoList = new ArrayList<>(
                    this.repository.findAll(DaoEntity.getKeyMatcherExampleExact(key)));
            this.repository.deleteAll(daoList);
        }
        return data;
    }
}
