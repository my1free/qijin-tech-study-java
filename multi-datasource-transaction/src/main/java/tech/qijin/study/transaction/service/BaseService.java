package tech.qijin.study.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.qijin.study.transaction.mysql.db1.model.User1;
import tech.qijin.study.transaction.mysql.db2.model.User2;

import java.util.List;

@Service
public class BaseService {
    @Autowired
    private User1Service user1Service;
    @Autowired
    private User2Service user2Service;

    public List<User1> listUser1() {
        return user1Service.listUser1();
    }

    public List<User2> listUser2() {
        return user2Service.listUser2();
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer updateUser1() {
        Integer res = user1Service.updateUser1();
        if (true) {
            throw new IllegalStateException("user1");
        }
        return res;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer updateUser2() {
        Integer res = user2Service.updateUser2();
        if (true) {
            throw new IllegalStateException("user2");
        }
        return res;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser12() {
        Integer res1 = user1Service.updateUser1();
        Integer res2 = user2Service.updateUser2();
        if (true) {
            throw new IllegalStateException("user12");
        }
        return res1 > 0 && res2 > 0;
    }
}
