package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.CommonUtils;
import utils.Constants;

import java.io.IOException;

public class Store {
  CommonUtils utils = new CommonUtils();
  Response response;
  RequestSpecification httpGetRequest;
  RequestSpecification httpDeleteRequest;
  RequestSpecification httpPostRequest;

  public Response getOrderRequest(int id) {
    RestAssured.baseURI = Constants.BASE_URL;
    httpGetRequest = RestAssured.given();
    response =
            httpGetRequest
            .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
            .get(Constants.STORE_RESOURCE_PATH+ "/" + id);
    return response;
  }

  public Response createOrderRequest(String json)
          throws IOException {
    RestAssured.baseURI = Constants.BASE_URL;
    httpPostRequest = RestAssured.given();
    response =
            httpPostRequest
                    .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                    .body(utils.readFile(Constants.REQUESTS_DIR + json))
                    .post(Constants.STORE_RESOURCE_PATH);
    return response;
  }

  public Response deleteOrderRequest(int id) {
    RestAssured.baseURI = Constants.BASE_URL;
    httpDeleteRequest = RestAssured.given();
    response =
            httpDeleteRequest
                    .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                    .get(Constants.STORE_RESOURCE_PATH+ "/" + id);
    return response;
  }
}
