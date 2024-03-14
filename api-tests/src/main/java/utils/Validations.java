package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class Validations {

  public static void ValidateResponseCode(int actualCode, int expectedCode) {
    Assert.assertEquals(actualCode, expectedCode);
  }

  public static void ValidateValuesInResponseBody(
      String expectedValue, String JsonPath, Response response) {
    Assert.assertTrue(expectedValue.contains(response.body().jsonPath().getString(JsonPath)));
  }

  public static void ValidateValueExist(String JsonPath, Response response) {
    Assert.assertNotNull(response.body().jsonPath().getString(JsonPath));
  }

  public static void ValidateValuesAreNotEqual(String json, String id, String message) {
    Assert.assertTrue(json.contains(id), message);
  }
}
