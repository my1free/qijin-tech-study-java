package tech.qijin.study.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.qijin.study.transaction.mysql.db2.dao.User2Dao;
import tech.qijin.study.transaction.mysql.db2.model.User2;

import java.util.List;

@Service
public class User2Service {
    @Autowired
    private User2Dao user2Dao;

    public List<User2> listUser2() {
        return user2Dao.selectAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer updateUser2() {
        return user2Dao.update();
    }
}
