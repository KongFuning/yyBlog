package Dao;

import bean.User;

public interface user {

    //用户注册
    public boolean userRegister(String username,String password);
    //判断数据库中是否存在该用户
    public User userExists(String username);

    //用户登录
    public User userLogin(String username, String password);
}
