import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetPosts extends TestBase {

    @Test
    public void shouldGetAllPosts() {
        Response response =
                when().
                        get(POSTS).
                        then().
                        statusCode(200).
                        extract().
                        response();

        JsonPath jsonPath = response.jsonPath();
        Assertions.assertThat(jsonPath.get("body").toString()).isNotEmpty();
    }

    @Test
    public void shouldGetPostWithFirstId() {
        Response response =
                given().
                        pathParams("id", "1").
                        when().
                        get(POSTS + "/{id}").
                        then().
                        statusCode(200).
                        body(JsonSchemaValidator.matchesJsonSchema((new File("src/main/resources/postSchema.json")))).
                        extract().
                        response();

        JsonPath jsonPath = response.jsonPath();
        Assertions.assertThat(jsonPath.get("id").toString()).isEqualTo("1");
    }

    @Test
    public void shouldGetPostsWithId3() {
        Response response =
                given().
                        queryParam("userId", "3").
                        when().
                        get(POSTS).
                        then().
                        statusCode(200).
                        extract().
                        response();

        JsonPath jsonPath = response.jsonPath();
        Assertions.assertThat(jsonPath.getList("userId")).allMatch(e -> e.equals(3));
    }
}
