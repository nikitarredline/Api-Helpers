package api;

import helpers.http.HttpHelper;
import io.restassured.response.Response;

public class CourseApi {

    public static Response getAllCourses() {
        return HttpHelper.get("/cource/get/all");
    }
}