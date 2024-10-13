package TestingMethods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestfullAPITestingAssured {
    public static void main(String[] args) {

        // Base URI of JSONPlaceholder API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Sending the GET request and validating response
        Response response =
                given()
                        .header("Content-Type", "application/json") // Setting header
                        .when()
                        .get("/users")  // Sending GET request
                        .then()
                        .statusCode(200)  // Validating response status code
                        .body("[0].name", equalTo("Leanne Graham"))  // Validating response body content
                        .extract().response();  // Extracting response to use later if needed

        // Optionally print the response for debugging
        System.out.println("Response Body: " + response.asString());
    }
}
