package tech.qijin.study.mysql.conn.pool;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class MySqlConnPool implements ConnPool {
    private static MySqlConnPool connPool;
    private String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
    private String username = "admin";
    private String password = "Admin_@123";
    private int poolSize = 10;
    LinkedList<Connection> pool = Lists.newLinkedList();

    private MySqlConnPool() {
    }

    // 初始化
    public synchronized static MySqlConnPool getInstance() {
        if (connPool == null) {
            connPool = new MySqlConnPool();
            connPool.init();
        }
        return connPool;
    }

    private void init() {
        IntStream.range(0, poolSize).forEach(idx -> {
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                pool.add(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public Connection getConnection() {
        synchronized (this) {
            if (CollectionUtils.isEmpty(pool)) {
                throw new IllegalStateException("no connection");
            }
            return pool.poll();
        }
    }

    public void releaseConnection(Connection connection) {
        synchronized (this) {
            if (connection != null) {
                pool.add(connection);
            }
        }
    }
}
