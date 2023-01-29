package cv.com.restwithspringbootjava.integrationtest.swagger;

import cv.com.restwithspringbootjava.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
class SwaggerIntegrationTest {

    @Test
    void shouldDisplaySwaggerUiPage() {

        final var content = given()
                .basePath("/swagger-ui/index.html")
                .port(TestConfig.SERVER_PORT)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body().asString();

        assertTrue(content.contains("Swagger UI"));
    }
}
