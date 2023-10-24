package api;

public class endpoints {

        public static String getBaseURL() {
                return baseURL;
        }
        private static String baseURL = "https://automationexercise.com/api";
        public static String allProductsList = baseURL + "/productsList";
        public static String allBrandsList = baseURL + "/brandsList";
        public static String searchProduct = baseURL + "/searchProduct";
        public static String verifyLogin = baseURL + "/verifyLogin";
        public static String getUserAccountDetails = baseURL + "/getUserDetailByEmail";

}
