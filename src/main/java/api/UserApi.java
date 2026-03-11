package api;

import helpers.http.HttpHelper;
import io.restassured.response.Response;

public class UserApi {

    public static Response getAllUsers() {
        return HttpHelper.get("/user/get/all");
    }

    public static Response getUserScore(int id) {
        return HttpHelper.get("/user/get/" + id);
    }
}