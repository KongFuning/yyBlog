package services;

import Dao.topic;
import bean.Topic;
import bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.Date;
import java.util.List;

public class topicImpl implements topic {

    //使用Spring JDBC对druid数据库连接池进行简单封装，便于使用
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDs());

    //分页查询，用于将文章信息填入表格
    @Override
    public List<Topic> queryTopicByPage(int pageNum, int size) {
        int page=(pageNum-1)*size;
        //定义sql
        String sql = "select * from topic where state = 1 limit ?,?";
        //执行sql
        List<Topic> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Topic>(Topic.class),new Object[]{page,size});
        return list;
    }

    @Override
    public int topicNum() {
        //定义sql
        String sql = "select count(*) from topic where state=1";
        //执行sql
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class);
        return num;
    }

    @Override
    public User findUserById(int userId) {
        //定义sql
        String sql = "select * from user where id = ?";
        //执行sql
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);
        return user;
    }

    @Override
    public int releaseTopic(String title, String content, Date date, int userId) {
        //定义sql
        String sql = "insert into topic (title,content,created,userId) values (?,?,?,?)";
        //执行sql
        int count = jdbcTemplate.update(sql, new Object[]{title, content, date, userId});
        return count;
    }

    @Override
    public String getTopicNameById(int topicId) {
        //定义sql
        String sql = "select title from topic where topic_id = " + topicId;
        //执行sql
        String topicName = jdbcTemplate.queryForObject(sql,String.class);
        return topicName;
    }

    @Override
    public String getTopicContentById(int topicId) {
        //定义sql
        String sql = "select content from topic where topic_id = " + topicId;
        //执行sql
        String topicContent = jdbcTemplate.queryForObject(sql,String.class);
        return topicContent;
    }

    @Override
    public int modifyTopicById(int topicId,String topicName,String topicContent) {
        //定义sql
        String sql = "update topic set title=?,content=? where topic_id = " + topicId;
        //执行sql
        int count = jdbcTemplate.update(sql, new Object[]{topicName, topicContent});
        return count;
    }

    @Override
    public int deleteTopic(int topicId) {
        //定义sql
        String sql = "update topic set state = ? where topic_id = ?";
        //执行sql
        int count = jdbcTemplate.update(sql, new Object[]{0, topicId});
        return count;
    }

}
