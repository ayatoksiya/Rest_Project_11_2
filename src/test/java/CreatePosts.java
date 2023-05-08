import io.restassured.http.ContentType;
import model.Post;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreatePosts extends TestBase {

    String body = """
            {
                "userId": 11,
                "title": "Rest Practice Test",
                "body": "Totally new post"
              }""";

    @Test
    public void shouldCreatePost() {
        given().
                body(body).
                contentType(ContentType.JSON).
                when().
                post(POSTS).
                then().
                statusCode(201);
    }

    @Test
    public void shouldCreatePost2() {
        Post post = new Post(22, "Rest Practice Test", "Even more totally new post");
        given().
                body(post).
                contentType(ContentType.JSON).
                when().
                post(POSTS).
                then().
                statusCode(201);
    }
}
