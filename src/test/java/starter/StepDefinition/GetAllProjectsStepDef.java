package starter.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import starter.API.TodoistAPI;
import starter.ResponseBody.TodoistResponse;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class GetAllProjectsStepDef {
    @Steps
    TodoistAPI todoistAPI;
    @Given("Get all projects with valid path {string}")
    public void getAllProjectsWithAllValidValue(String path) {
        todoistAPI.getAllProjects(path);
    }

    @When("Send request get all projects")
    public void sendRequestGetAllProjects() {
        SerenityRest.when().get(TodoistAPI.GET_ALL_PROJECTS);
    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Body contain id {int} and color {int}")
    public void bodyContainIdAndColor(int id, int color) {
        SerenityRest.then().body("id",Matchers.hasKey(id))
                .body("color", Matchers.hasKey(color));
    }
//Scenario2
    @Given("Get all projects with valid path {string} empty authorization")
    public void getAllProjectsEmptyAuthorization(String path) {
       todoistAPI.getAllProjectsWithoutAuthorization(path);
    }

    @Then("Should return {int} Unauthorized")
    public void shouldReturnUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(unauthorized);
    }

    @And("Body contain {string}")
    public void bodyContain(String message) {
        SerenityRest.then().body(equalTo(message));
    }
//Scenario3
    @Given("Get all projects invalid path {string} with special character")
    public void getAllProjectsInvalidWithSpecialCharacter(String path) {
        todoistAPI.getAllProjects(path);
    }

    @Then("Should return {int} bad request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
//Scenario4
    @Given("Get all projects invalid path {string} with character")
    public void getAllProjectsInvalidWithCharacter(String path) {
        todoistAPI.getAllProjects(path);
    }
    @Then("Should return {int} not found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @Given("Get all projects invalid path {int} with value integer")
    public void getAllProjectsInvalidPathWithValueInteger(int path) {
        todoistAPI.getAllProjectsInvalidPathInteger(path);
    }


}
