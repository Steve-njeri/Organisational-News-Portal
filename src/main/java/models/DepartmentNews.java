package models;

import java.sql.Timestamp;

public class DepartmentNews extends News {

    public DepartmentNews(int user_id, String title, String content, Timestamp postdate) {
        super(user_id, title, content, postdate);
    }
}
