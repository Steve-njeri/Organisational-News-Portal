package dao;

import models.DepartmentNews;
import models.News;

import java.util.List;

public interface NewsDao {


    List<News> getAllNews();
    List<News> getNews();
    List<DepartmentNews> getDepartmentNews();

    void addNews(News news);
    void addDepartmentNews(DepartmentNews departmentNews);

    News findGeneralNewsById(int id);
    DepartmentNews findDepartmentNewsById(int id);

    void updateNews(News news, int user_id, String content);
    void updateDepartmentNews(DepartmentNews departmentNews, int user_id, String content, int departmentId);

    void clearAllNews();
    void clearNews();
    void clearDepartmentNews();
}
