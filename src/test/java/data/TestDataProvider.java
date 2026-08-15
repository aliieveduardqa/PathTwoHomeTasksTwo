package data;

import org.testng.annotations.DataProvider;

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
}
