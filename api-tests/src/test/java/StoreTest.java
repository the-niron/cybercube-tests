import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.Store;
import utils.CommonUtils;
import utils.Constants;
import utils.Validations;

import java.io.IOException;

public class StoreTest {
    Response response;
    Store store = new Store();
    CommonUtils utils = new CommonUtils();

    @Test
    public void createOrderWithValidData() throws IOException {
        String requestBody = "createOrder.json";
        String quantity = "quantity";
        String complete = "complete";
        response = store.createOrderRequest(requestBody);
        // Validate response code is 200
        Validations.ValidateResponseCode(response.getStatusCode(), Constants.STATUS_CODE_200);
        // Validate the fields in order response body
        Validations.ValidateValuesInResponseBody(
                utils.getInputDataFromRequests(requestBody, quantity), quantity, response);
        Validations.ValidateValuesInResponseBody(
                utils.getInputDataFromRequests(requestBody, complete), complete, response);
    }
    @Test(dependsOnMethods={"createOrderWithValidData"})
    public void validateOrderGetRequest() {
        response = store.getOrderRequest(2);
        Validations.ValidateResponseCode(response.getStatusCode(), Constants.STATUS_CODE_200);
        Assert.assertTrue(response.body().jsonPath().getString("status").contains("approved"));
    }

    @Test(dependsOnMethods={"validateOrderGetRequest"})
    public void validateOrderDeleteRequest() {
        response = store.deleteOrderRequest(2);
        Validations.ValidateResponseCode(response.getStatusCode(), Constants.STATUS_CODE_200);
        // Make a get request and validate entry doesn't exist
        Response getResponse = store.getOrderRequest(2);
        Validations.ValidateResponseCode(getResponse.getStatusCode(), Constants.STATUS_CODE_200);
    }


}
