package models;
import java.util.Objects;

public class DepartmentNews extends News {
    private int departmentId;

    public DepartmentNews(int id, int user_id, String title, String content,int departmentId) {
        super(id, user_id, title, content);
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
