package tech.qijin.study.transaction.mysql.db2.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.qijin.study.transaction.mysql.db2.model.User2;

import java.util.List;

public interface User2Dao {
    @Select("select * from user2")
    List<User2> selectAll();

    @Update("update user2 set age=age+1 where id=1")
    Integer update();
}
