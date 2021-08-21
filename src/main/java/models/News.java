package models;

import java.sql.Timestamp;
import java.util.Objects;

public class News {
    private int id;
    private int user_id;
    private String title;
    private String content;
    private Timestamp postdate;

    public News(int user_id, String title, String content, Timestamp postdate) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.postdate = postdate;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getPostdate() {
        return postdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(user_id, news.user_id) &&
                Objects.equals(title, news.title) &&
                Objects.equals(content, news.content) &&
                Objects.equals(postdate, news.postdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, title, content);
    }

}
