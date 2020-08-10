package com.example.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoJdbcImpl implements Dao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private boolean ifContains(Integer key) {

        logger.info(" ifContains {}", key);
        Boolean exists = this.jdbcTemplate.queryForObject(
                "SELECT EXISTS (SELECT key FROM db WHERE key = ? LIMIT 1)",
                new Object[]{key},
                Boolean.class);
        return exists != null && exists;
    }

    @Override
    public List<Integer> retrieve(Integer key) {

        logger.info(" retrieve {}", key);
        return this.jdbcTemplate.queryForList(
                "SELECT data FROM db WHERE key=?",
                new Object[]{key},
                Integer.class);
    }

    @Override
    public Boolean submit(Integer key, List<Integer> data) {

        logger.info(" submit {}", key);
        if (this.ifContains(key)) {
            return false;
        } else {
            data.forEach(elem ->
            this.jdbcTemplate.update(
                    "INSERT INTO db (key,data) values (?, ?)",
                    key, elem));
            return true;
        }
    }

    @Override
    public List<Integer> remove(Integer key) {

        logger.info(" remove {}", key);
        List<Integer> data = this.retrieve(key);
        if (!data.isEmpty()) {
            this.jdbcTemplate.update(
                    "DELETE FROM db WHERE key=?",
                    key);
        }
        return data;
    }
}
