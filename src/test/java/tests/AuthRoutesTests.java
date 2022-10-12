package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    /*
    Verify that user can't access "/home" route (home page) without successful login and that user remains on the "/login" route (login page).
     */
    @Test
    public void verifyHomeIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/home";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    /*
    Verify that user can't access "/profile" route (profile page) without successful login and that user remains on the "/login" route (login page).
     */
    @Test
    public void verifyProfileIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/profile";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    /*
    Verify that user can't access "/admin/cities" route (cities page) without successful login and that user remains on the "/login" route (login page).
     */
    @Test
    public void verifyAdminCitiesIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    /*
    Verify that user can't access "/admin/users" route (users page) without successful login and that user remains on the "/login" route (login page).
     */
    @Test
    public void verifyAdminUsersIsInaccessibleWithoutLogin() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String URL = "https://vue-demo.daniel-avellaneda.com/admin/users";

        getDriver().get(URL);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }
}