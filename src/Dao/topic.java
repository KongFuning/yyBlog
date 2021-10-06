package Dao;

import bean.Topic;
import bean.User;

import java.util.Date;
import java.util.List;

public interface topic {

    //分页查询，用于将文章信息填入表格
    List<Topic> queryTopicByPage(int pageNum,int size);

    //计算文章总数
    int topicNum();

    //根据userId找到写该文章的作者
    User findUserById(int userId);

    //发表一篇文章
    int releaseTopic(String title, String content, Date date,int userId);

    //根据id获取文章标题
    String getTopicNameById(int topicId);
    //根据id获取文章内容
    String getTopicContentById(int topicId);

    //根据id修改文章标题和内容
    int modifyTopicById(int topicId,String topicName,String topicContent);

    //根据id删除文章
    int deleteTopic(int topicId);
}
