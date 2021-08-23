import static spark.Spark.*;

import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUsersDao;
import exceptions.ApiException;
import models.Department;
import models.DepartmentNews;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Sql2oUsersDao usersDao;

        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/organisationals_portal";
        Sql2o sql2o = new Sql2o(connectionString, "stephen", "123456");

        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);

        conn = sql2o.open();


        // get all users details
        get("/users", "application/json", (request, response) -> {
            if (usersDao.getAllUsers().size()> 0) {
                return gson.toJson(usersDao.getAllUsers());
            }else {
                return "{\"message\":\"I'm sorry, but no users are currently listed in the database.\"}";
            }
        });

        // Getting each user
        get("/users/:id", "application/json", (request, response) -> { //accept a request in format JSON from an app
            int user_id = Integer.parseInt(request.params("id"));
            Users usersToFind = usersDao.findUserById(user_id);
            if (usersToFind == null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists", request.params("id")));
            }
            return gson.toJson(usersToFind);
        });

        // Posts all Users details
        post("/users/new", "application/json", (request, response) -> {
            Users users = gson.fromJson(request.body(), Users.class);
            usersDao.addUsers(users);
            response.status(201);
            return gson.toJson(users);
        });


        //Getting all departments
        get("/department", "application/json", (req, res) -> {
            System.out.println(departmentDao.getAll());

            if(departmentDao.getAll().size() > 0){
                return gson.toJson(departmentDao.getAll());
            } else {
                return "{\"message\":\"I'm sorry, but no departments are currently listed in the database.\"}";
            }

        });

        // Getting each department
        get("department/:id", "application/json", (request, response) -> {
            int id =Integer.parseInt(request.params("id"));
            Department department = departmentDao.findById(id);
            if(department != null){
                return gson.toJson(department);
            }else{
                throw new Error("Department with that Id does not exist");
            }
        });

        // Posts all Departments details
        post("/department/new","application/json",(request, response) -> {
            Department department =gson.fromJson(request.body(),Department.class);
            departmentDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });


        //Getting news
        get("/news", "application/json", (request, response) -> {

            if (newsDao.getAllNews().size()> 0) {
                return gson.toJson(newsDao.getAllNews());
            }else {
                return "{\"message\":\"I'm sorry, but no news are currently listed in the database.\"}";
            }
        });

        //Posting news
        post("/news/new", "application/json", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            newsDao.add(news);
            response.status(201);
            return gson.toJson(news);
        });

        post("/DepartmentNews/new", "application/json", (request, response)->{
            DepartmentNews departmentNews = gson.fromJson(request.body(), DepartmentNews.class);

            newsDao.addDepartmentNews(departmentNews);
            response.status(201);
            response.type("application/json");

            response.redirect("/news/department");
            return null; //gson.toJson(departmentNews);
        });


        // Filters
        exception(ApiException.class, (exc, request, response) -> {
            ApiException err = exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            response.type("application/json"); //after does not run in case of an exception.
            response.status(err.getStatusCode()); //set the status
            response.body(gson.toJson(jsonMap));  //set the output.
        });

        after((request, response) ->{
            response.type("application/json");
        });
    }



}
