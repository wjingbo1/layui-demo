package COM.Util;

import java.sql.*;


/**
 * JDBC快速入门
 */
public class utils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection connection = null;//连接数据库
        PreparedStatement ps = null;//Statement 对象用于将 SQL 语句发送到数据库中。
        ResultSet rs = null;
        //1. 导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudent","root", "1767737316.");
        return connection;
    }

    public static void close(Connection connection ) {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement ps ) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void close(ResultSet resultSet ) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
