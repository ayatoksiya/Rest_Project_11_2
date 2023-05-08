import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String POSTS = BASE_URL + "/posts";

    @BeforeEach
    public void setup() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
