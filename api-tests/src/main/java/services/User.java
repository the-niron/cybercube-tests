package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.CommonUtils;
import utils.Constants;

import java.io.IOException;

public class User {
  CommonUtils utils = new CommonUtils();
  Response response;
  RequestSpecification httpPutRequest;
  RequestSpecification httpGetRequest;

  public Response updateUserRequest(String body)
      throws IOException {
    RestAssured.baseURI = Constants.BASE_URL;
    httpPutRequest = RestAssured.given();
    response =
            httpPutRequest
            .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
            .body(utils.readFile(Constants.REQUESTS_DIR + body))
            .post(Constants.USER_RESOURCE_PATH);
    return response;
  }

    public Response userLoginRequest(String username, String password) {
      RestAssured.baseURI = Constants.BASE_URL;
      httpGetRequest = RestAssured.given();
      response =
              httpGetRequest
                      .queryParam("username",username)
                      .queryParam("password",password)
                      .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                      .get(String.format(Constants.USER_RESOURCE_PATH + "/login"));
      return response;
    }
}
