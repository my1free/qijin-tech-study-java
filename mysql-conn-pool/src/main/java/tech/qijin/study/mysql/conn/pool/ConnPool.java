package tech.qijin.study.mysql.conn.pool;

import java.sql.Connection;

public interface ConnPool {
    // 租用连接
    Connection getConnection();

    // 归还连接
    void releaseConnection(Connection connection);
}
