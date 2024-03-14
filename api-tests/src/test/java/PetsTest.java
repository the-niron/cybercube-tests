import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.Pet;
import utils.CommonUtils;
import utils.Constants;
import utils.Validations;

import java.io.IOException;

public class PetsTest {
    Response response;
    CommonUtils utils = new CommonUtils();
    Pet pets = new Pet();
    @Test
    public void createPetWithValidData() throws IOException {
        String requestBody = "createPet.json";
        String id = "id";
        String name = "name";
        response = pets.createPetRequest(requestBody);
        // Validate response code is 200
        Validations.ValidateResponseCode(response.getStatusCode(), Constants.STATUS_CODE_200);
        // Validate the fields in pet creation response body
        Validations.ValidateValuesInResponseBody(
                utils.getInputDataFromRequests(requestBody, id), id, response);
        Validations.ValidateValuesInResponseBody(
                utils.getInputDataFromRequests(requestBody, name), name, response);
    }
    @Test
    public void getPetWithValidId() {
    String petId = "10";
    response = pets.getPetRequest(petId);
    Validations.ValidateResponseCode(response.getStatusCode(), Constants.STATUS_CODE_200);
    // Validate retrieved comments contain the posted comment
    Validations.ValidateValuesAreNotEqual(
            response.body().jsonPath().getString("id"), petId, "Response didn't contain the pet ID: " + petId);
    Validations.ValidateValueExist("name", response);
    }
    @Test
    public void getPetWithInvalidId() {
        String petId = "233";
        response = pets.getPetRequest(petId);
        Validations.ValidateResponseCode(response.getStatusCode(), Constants.STATUS_CODE_404);
    }

}
