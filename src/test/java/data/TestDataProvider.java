package data;

import org.testng.annotations.DataProvider;
import common.utils.DataGenerator;

public class TestDataProvider {

    @DataProvider(name = "validLoginData")
    public static Object[][] getValidLoginData() {
        return new Object[][]{
                {"aliieveduardqa+1@sharkscode.com", "111111"}
        };
    }

    @DataProvider(name = "searchQueries")
    public static Object[][] getSearchQueries() {
        return new Object[][]{
                {"Gate of olympus"}
        };
    }
    @DataProvider(name = "registrationData")
    public static Object[][] getRegistrationData() {
        String uniqueEmail = DataGenerator.generateUniqueEmail("aliieveduardqa", "sharkscode.com");
        String password = "222222";

        return new Object[][]{
                {uniqueEmail, password}
        };
    }

}
