package starter.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class TodoistAPI {
    public static String URL = "https://api.todoist.com";
    public static String AUTH = "d256eb8544ab45ff968db31541e1f058ce0ce5d6";
    public static String GET_PROJECT = URL+"/rest/v1/projects/{id}";
    public static String GET_PROJECT_INVALID = URL+"/rest/v1/projects=/=/";
    public static String POST_CREATE_PROJECT = URL+"/rest/v1/projects";
    public static String POST_CREATE_PROJECT_INVALID = URL+"/rest/v1=/=/=/projects";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQUEST_BODY_FILE = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA_VALIDATOR_FILE = DIR+"/src/test/resources/JSON/JsonSchema";

    @Step("Post Create Project Authorization")
    public void setPostCreateProject(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization", "Bearer d256eb8544ab45ff968db31541e1f058ce0ce5d6");
    }

    @Step("Post Create Project Unauthorized")
    public void setPostCreateProjectUnauthorized(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get projects")
    public void getProjects(String id){
        SerenityRest.given()
                .headers("Authorization", "Bearer d256eb8544ab45ff968db31541e1f058ce0ce5d6")
                .pathParam("id", id);
    }

    @Step("Get projects without auth")
    public void getProjectsWithoutAuth(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}