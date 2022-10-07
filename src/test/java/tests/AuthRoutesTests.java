package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    @Test (priority = 1)
    public void test1_verifyHomeIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/home";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test (priority = 2)
    public void test2_verifyProfileIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/profile";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test (priority = 3)
    public void test3_verifyAdminCitiesIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test (priority = 4)
    public void test4_verifyAdminUsersIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/admin/users";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }
}