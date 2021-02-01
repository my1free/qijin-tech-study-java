package tech.qijin.study.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.qijin.study.transaction.mysql.db1.dao.User1Dao;
import tech.qijin.study.transaction.mysql.db1.model.User1;

import java.util.List;

@Service
public class User1Service {
    @Autowired
    private User1Dao user1Dao;

    public List<User1> listUser1() {
        return user1Dao.selectAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer updateUser1() {
        return user1Dao.update();
    }
}
