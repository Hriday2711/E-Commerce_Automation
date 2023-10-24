package api;

import interfaces.API_Interface;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.Logger;
import static io.restassured.RestAssured.*;

public class methods extends endpoints implements API_Interface {


    @Override
    public void getAllProductsList() throws Exception {
        Logger.logAction("Getting list of all Products via API");
        Response response = given().when().get(allProductsList);
        Assert.assertEquals(response.getStatusCode(),200);
        Logger.logComment(response.getBody().print());
    }

    @Override
    public void getAllBrandsList() throws Exception {
        Logger.logAction("Getting list of all Brands via API");
        Response response = given().when().get(allBrandsList);
        Assert.assertEquals(response.getStatusCode(),200);
        Logger.logComment(response.getBody().print());
    }

    @Override
    public void searchProductsWithoutParameters() throws Exception {

    }

    @Override
    public void verifyLoginWithoutParameters() throws Exception {

    }

    @Override
    public void getUserDetailsByEmail() throws Exception {

    }
}
