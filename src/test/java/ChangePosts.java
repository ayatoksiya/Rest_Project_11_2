import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ChangePosts extends TestBase {

    String bodyPut = """
            {
                "userId": 33,
                "title": "Post Test",
                "body": "Change the whole post"
              }""";

    @Test
    public void shouldChangeWholePost() {
        given().
                body(bodyPut).
                contentType(ContentType.JSON).
                when().
                put(POSTS + "/5").
                then().
                statusCode(200);

    }

    String bodyPatch = """
            {
                "title": "Patch Test",
              }""";

    @Test
    public void shouldChangePartPost() {
        given().
                body(bodyPatch).
                contentType(ContentType.JSON).
                when().
                patch(POSTS + "/2").
                then().
                statusCode(200);
    }
}
