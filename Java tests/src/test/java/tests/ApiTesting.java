package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import pojos.Author;

import static io.restassured.RestAssured.given;

public class ApiTesting {
    private static final RequestSpecification REQ_SPEQ =
            new RequestSpecBuilder()
                    .setBaseUri("https://fakerestapi.azurewebsites.net/api/v1")
                    .setBasePath("/Authors")
                    .setContentType(ContentType.JSON)
                    .build();

    @Before
    public void setFilter(){ RestAssured.filters(new AllureRestAssured()); }

    @Test
    public void getRequest(){
        given()
                .spec(REQ_SPEQ)
                .when().get()
                .then()
                .log().all()
                .statusCode(200 );
    }

    @Test
    public void postRequest(){
        Author author = Author.builder()
                .firstName("Daniil")
                .lastName("Borisevich")
                .build();

        given()
                .spec(REQ_SPEQ)
                .body(author)
                .when().post()
                .then()
                .log().all()
                .statusCode(200);
    }
}
