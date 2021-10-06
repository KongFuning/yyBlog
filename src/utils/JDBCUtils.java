package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    //定义成员变量
    private static DataSource ds;
    static {
        try {
            //读取配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("durid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //资源释放
    public static void close(ResultSet rs, Statement stmt,Connection conn) throws SQLException {
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
        if(conn != null) conn.close();

    }
    //资源释放
    public static void close(Statement stmt,Connection conn) throws SQLException {
        if(stmt != null) stmt.close();
        if(conn != null) conn.close();
    }

    //获取DataSource

    public static DataSource getDs() {
        return ds;
    }
}
