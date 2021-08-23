package dao;

import models.DepartmentNews;
import models.News;

import java.util.List;

public interface NewsDao {


    List<News> getAllNews();
    List<News> getNews(int id);
    List<DepartmentNews> getDepartmentNews(int departmentId);

    void add(News news);
    void addDepartmentNews(DepartmentNews departmentNews);

    News findNewsById(int id);
    DepartmentNews findDepartmentNewsById(int id);

    void updateNews(News news, int user_id, String content);
    void updateDepartmentNews(DepartmentNews departmentNews, int user_id, String content, int departmentId);

    void deleteById(int id);
    void clearAllNews();

}
