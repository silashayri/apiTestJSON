package ApiTests;

import JsonClasses.Datum;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class ApiTestExample extends Datum {






public Response GetList() {
    RestAssured.baseURI = "https://reqres.in";

    Response response = given()
            .contentType("application/json")
            .when()
            .get("/api/unknown")
            .then()
            .extract().response();

    response.getBody().prettyPrint();

    return response;
}









}
