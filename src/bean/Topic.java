package bean;

import java.util.Date;

public class Topic {
    private int topic_id;
    private String title;
    private String content;
    private Date created;
    private int userId;
    private int state;

    public Topic(int topic_id, String title, String content, Date created, int userId, int state) {
        this.topic_id = topic_id;
        this.title = title;
        this.content = content;
        this.created = created;
        this.userId = userId;
        this.state = state;
    }

    public Topic() {

    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topic_id=" + topic_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", userId=" + userId +
                ", state=" + state +
                '}';
    }
}
