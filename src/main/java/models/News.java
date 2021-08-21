package models;

import java.sql.Timestamp;

public class News {
    private int id;
    private int user_id;
    private String title;
    private String content;
    private Timestamp postdate;

    public News(int id, int userId, String title, String content, Timestamp postdate) {
        this.id = id;
        this.user_id = userId;
        this.title = title;
        this.content = content;
        this.postdate = postdate;
    }
}
