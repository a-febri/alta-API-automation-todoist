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
    public static String DELETE_PROJECT = "https://api.todoist.com/rest/v1/{id}";

    @Step("Delete project with valid id")
    public void deleteProjectValidID(String id) {
      SerenityRest.given()
              .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }

    @Step("Delete project without authorized")
    public void deleteProjectUnauthorized(String id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Delete project not register id")
    public void deleteProjectNotRegisterId(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }

    @Step("Delete project with minimum digit id")
    public void deleteProjectMinimumId(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }

    @Step("Delete project with invalid id")
    public void deleteProjectInvalidId(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }
    @Step("Delete project with special char id")
    public void deleteProjectSpecialChar(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }

}