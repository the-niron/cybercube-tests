import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.User;
import utils.Constants;
import utils.Validations;

import java.io.IOException;

public class UserTest {
    Response response;
    User user = new User();
    @Test
    public void validateUserLoginRequest() {
        response = user.userLoginRequest("Bruce","Wayne");
        Validations.ValidateResponseCode(response.getStatusCode(), Constants.STATUS_CODE_200);
        Assert.assertTrue(response.body().jsonPath().getString("message").contains("logged in user session:"));
    }

    @Test
    public void validateUserUpdateRequest() throws IOException {
        response = user.updateUserRequest("updateUser.json");
        Validations.ValidateResponseCode(response.getStatusCode(), Constants.STATUS_CODE_200);
    }

}
