package stepDefination;

import api.methods;
import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import utils.PageObjects_Base;

public class ApiStepDefination extends PageObjects_Base {

    @Test
    @And("^Get List of All Products via API$")
    public void getAllProductsListFromAPI() throws Exception{
        apiMethods.getAllProductsList();
    }

    @Test
    @And("^Get List of All Brands via API$")
    public void getAllBrandsListFromAPI() throws Exception {
        apiMethods.getAllBrandsList();
    }
}
