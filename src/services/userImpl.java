package services;

import Dao.user;
import bean.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class userImpl implements user {

    //使用Spring JDBC对druid数据库连接池进行简单封装，便于使用
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDs());

    //用户注册的逻辑实现
    @Override
    public boolean userRegister(String username, String password) {
        //定义sql 将用户名和密码加入数据库
        String sql = "insert into user values(null,?,?)";
        //执行sql
        int count = jdbcTemplate.update(sql, new Object[]{username, password});
        return count > 0 ? true : false;
    }

    //判断数据库中是否存在该用户
    @Override
    public User userExists(String username) {
        User user;
        try {
            //定义sql
            String sql = "select * from user where username = ?";
            //执行sql
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    //用户登录的逻辑实现
    @Override
    public User userLogin(String username, String password) {
        User user;
        try {
            //定义sql 查询数据库 是否有这条数据
            String sql = "select id,username,password from user where username = ? and password = ?";
            //执行sql
            user = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class), new Object[]{username, password});
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
