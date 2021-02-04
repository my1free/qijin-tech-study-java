package tech.qijin.study.mysql.conn.pool;

import java.sql.*;

public class ConnPoolMain {
    public static void main(String[] args) throws SQLException {
        ConnPool connPool = MySqlConnPool.getInstance();
        Connection connection = connPool.getConnection();
        String sql = "select * from test";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSetMetaData resultSetMetaData = preparedStatement.getMetaData();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Integer c1 = resultSet.getInt("c1");
            Integer c2 = resultSet.getInt("c2");
        }
    }
}
