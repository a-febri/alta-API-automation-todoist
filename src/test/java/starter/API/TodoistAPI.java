package starter.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class TodoistAPI {
    public static String URL = "https://api.todoist.com";
    public static String AUTH = "d256eb8544ab45ff968db31541e1f058ce0ce5d6";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQUEST_BODY_FILE = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA_VALIDATOR_FILE = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String GET_ALL_PROJECTS = URL+"/rest/v1/{path}";
    public static String UPDATE_A_PROJECT = URL+"/rest/v1/projects/2299947157";
    public static String UPDATE_PROJECT_InvalidID = URL+"/rest/v1/projects/{id}";

    @Step("Get all projects")
    public void getAllProjects(String path){
        SerenityRest.given().headers("Authorization","Bearer "+AUTH)
                .pathParam("path", path);
    }
    @Step("Get all projects without Authorization")
    public void getAllProjectsWithoutAuthorization(String path){
        SerenityRest.given().pathParam("path", path);
    }
    @Step("Get all projects invalid path int")
    public void getAllProjectsInvalidPathInteger(int path){
        SerenityRest.given().headers("Authorization","Bearer "+AUTH)
            .pathParam("path", path);
    }
    @Step("Post update project")
    public void postUpdateProject(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer "+AUTH);
    }
    @Step("Post update project empty Authorization")
    public void postUpdateProjectEmptyAuthorization(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post update project invalid id")
    public void postUpdateProjectInvalidID(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer "+AUTH);
    }
}

