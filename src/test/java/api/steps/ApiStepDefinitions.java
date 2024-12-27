package api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiStepDefinitions {

    private Response response;

    @Given("I send a GET request to string")
    public void iSendAGETRequestTo(String url) {
        response = given().get(url);
    }

    @When("I receive the response")
    public void iReceiveTheResponse() {
        response.then().log().all();
    }
    // status response
    @Then("the response status code should be int")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }
    // status response
    @Then("the user name should be string")
    public void theUserNameShouldBe(String expectedName) {
        response.then().body("data.first_name", equalTo(expectedName));
    }
}
