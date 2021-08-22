package dao;

import models.DepartmentNews;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {

    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<News> getAllNews() {
        return null;
    }

    @Override
    public List<News> getNews() {
        return null;
    }

    @Override
    public List<DepartmentNews> getDepartmentNews() {
        return null;
    }

    @Override
    public void addNews(News news) {

    }


    @Override
    public void addDepartmentNews(DepartmentNews departmentNews) {

    }

    @Override
    public News findGeneralNewsById(int id) {
        return null;
    }

    @Override
    public DepartmentNews findDepartmentNewsById(int id) {
        return null;
    }

    @Override
    public void updateNews(News news, int user_id, String content) {

    }

    @Override
    public void updateDepartmentNews(DepartmentNews departmentNews, int user_id, String content, int departmentId) {

    }

    public void clearAllNews() {
    }

    @Override
    public void clearNews() {

    }

    @Override
    public void clearDepartmentNews() {

    }
}
