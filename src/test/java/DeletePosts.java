import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeletePosts extends TestBase {

    @Test
    public void shouldDeletePost() {
        given().
                pathParams("id", "2").
                when().
                delete(POSTS + "/{id}").
                then().
                statusCode(200);
    }
}
