package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    @Test
    public void verifyHomeIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/home";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test
    public void verifyProfileIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/profile";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test
    public void verifyAdminCitiesIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test
    public void verifyAdminUsersIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/admin/users";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }
}