package models;
import java.util.Objects;

public class News {
    private int id;
    private int user_id;
    private String title;
    private String content;

    public News(int id, int user_id, String title, String content) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
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
                Objects.equals(content, news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, title, content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setid(int id) {
        this.id = id;
    }
}
