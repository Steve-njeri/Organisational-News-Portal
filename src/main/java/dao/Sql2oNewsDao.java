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

//    Get all general news
    @Override
    public List<News> getAllNews() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }

//    Get general news
    @Override
    public List<News> getNews(int id) {
        String sql = "SELECT * from news where id=:id";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .addParameter("id",id)
                    .executeAndFetch(News.class);
        }

    }

    @Override
    public List<DepartmentNews> getDepartmentNews(int departmentId) {
        String sql = "SELECT * FROM news where departmentId=:departmentId";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("departmentId",departmentId)
                    .executeAndFetch(DepartmentNews.class);
        }
    }



    //    add general news
    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (user_Id,title,content) values (:user_id,:title, :content";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setid(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

//    add department news
    @Override
    public void addDepartmentNews(DepartmentNews departmentNews){
            String sql = " INSERT INTO news (user_id,title,content,departmentId) values (:user_id,:title,:content:departmentId) ";
            try (Connection con = sql2o.open()) {
                int id = (int) con.createQuery(sql, true)
                        .addParameter("user_id", departmentNews.getUser_id())
                        .addParameter("title",departmentNews.getTitle())
                        .addParameter("content",departmentNews.getContent())
                        .addParameter("departmentId", departmentNews.getDepartmentId())
                        .executeUpdate().getKey();
                departmentNews.setid(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
        }

//    Find general news by Id
    @Override
    public News findNewsById(int id) {
        String sql = " SELECT * FROM news where id=:id";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(News.class);
        }

    }

//    find department news by id
    @Override
    public DepartmentNews findDepartmentNewsById(int id) {
        String sql = " select * FROM news where id=:id";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .addParameter("id",id)
                    .executeAndFetchFirst(DepartmentNews.class);
        }
    }

//    updated general news
    @Override
    public void updateNews(News news, int user_id, String content) {
        String sql = "UPDATE news set (userId, content) = (:user_id, :content)  where id=:id ";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("user_id",user_id)
                    .addParameter("content",content)
                    .addParameter("id",news.getId())
                    .executeUpdate();
            news.setUser_id(user_id);
            news.setContent(content);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

//    Update department news
    @Override
    public void updateDepartmentNews(DepartmentNews departmentNews, int user_id, String content, int departmentId) {
        String sql = "UPDATE news set (user_id, content,departmentId) = (:user_id,  :content,:departmentId)  where id=:id ";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("user_id",user_id)
                    .addParameter("content",content)
                    .addParameter("departmentId",departmentId)
                    .addParameter("id",departmentNews.getId())
                    .executeUpdate();
            departmentNews.setUser_id(user_id);
            departmentNews.setContent(content);
            departmentNews.setDepartmentId(departmentId);
        }
    }

//    delete all news by id
    @Override
    public void deleteById(int id) {
        String sql = "DELETE from news WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println("Error");
        }

    }

//    clear all general and department news
    @Override
    public void clearAllNews() {
        String sql="DELETE FROM news";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
