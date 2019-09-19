
package JsonClasses;

import java.util.List;

import ApiTests.ApiTestExample;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Example extends ApiTestExample {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("data")
    @Expose
    private List<JsonClasses.Datum> data = null;

    public Integer getPage() {

        return page;
    }


    public void setPage(Integer page) {

        this.page = page;
    }

    public Integer getPerPage() {

        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {

        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<JsonClasses.Datum> getData() {
        return data;
    }

    public void setData(List<JsonClasses.Datum> data) {
        this.data = data;
    }

    public Response getList(){

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

    @Test
    public void GetData(){


        Response response = GetList();
        String result = response.jsonPath().prettify();

        Gson gson = new Gson();
        Example exampleTestClass = gson.fromJson(result, Example.class);

        for (Datum data : exampleTestClass.getData()){
            System.out.println("ID: "+ data.getId());
            System.out.println("Name: "+ data.getName());
            System.out.println("Year: "+ data.getYear());
            System.out.println("Color: "+ data.getColor());
            System.out.println("Pantone Value: "+ data.getPantoneValue());
            System.out.println(" ");



        }

    }


}
