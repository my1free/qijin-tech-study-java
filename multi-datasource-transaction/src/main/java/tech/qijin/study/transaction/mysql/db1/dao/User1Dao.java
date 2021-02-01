package tech.qijin.study.transaction.mysql.db1.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.qijin.study.transaction.mysql.db1.model.User1;

import java.util.List;

public interface User1Dao {
    @Select("select * from user1")
    List<User1> selectAll();

    @Update("update user1 set age=age+1 where id=1")
    Integer update();
}
