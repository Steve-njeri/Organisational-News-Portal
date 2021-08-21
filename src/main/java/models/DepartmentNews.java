package models;

import java.sql.Timestamp;
import java.util.Objects;

public class DepartmentNews extends News {
    private int departmentId;

    public DepartmentNews(int user_id, String title, String content, Timestamp postdate, int departmentId) {

        super(user_id, title, content, postdate);
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        DepartmentNews departmentNews = (DepartmentNews) o;
        return departmentId == departmentNews.departmentId;

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departmentId);
    }
}
