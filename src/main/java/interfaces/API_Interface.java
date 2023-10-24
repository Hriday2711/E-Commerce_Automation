package interfaces;

public interface API_Interface {

    /**
     * API Method to fetch all products list from e-commerce website
     * @throws Exception
     */
    void getAllProductsList() throws Exception;

    /**
     * API method to fetch all brands list from e-commerce website
     */
    void getAllBrandsList() throws Exception;

    /**
     * API Method to Search Products in the e-commerce website without search parameter
     */
    void searchProductsWithoutParameters() throws Exception;

    /**
     * API Method to verify User login without parameters
     */
    void verifyLoginWithoutParameters() throws Exception;

    /**
     * API Method to fetch the User Account Details by email provided by the user
     */
    void getUserDetailsByEmail() throws Exception;
}
