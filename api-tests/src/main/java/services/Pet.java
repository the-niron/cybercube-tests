package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.CommonUtils;
import utils.Constants;

import java.io.IOException;

public class Pet {
  CommonUtils utils = new CommonUtils();
  Response response;
  RequestSpecification httpPostRequest;
  RequestSpecification httpGetRequest;

  public Response createPetRequest(String json)
      throws IOException {
    RestAssured.baseURI = Constants.BASE_URL;
    httpPostRequest = RestAssured.given();
    response =
        httpPostRequest
            .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
            .body(utils.readFile(Constants.REQUESTS_DIR + json))
            .post(Constants.PET_RESOURCE_PATH);
    return response;
  }

    public Response getPetRequest(String id) {
      RestAssured.baseURI = Constants.BASE_URL;
      httpGetRequest = RestAssured.given();
      response =
              httpGetRequest
                      .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                      .get(String.format(Constants.PET_RESOURCE_PATH + "/" + id));
      return response;
    }
}
