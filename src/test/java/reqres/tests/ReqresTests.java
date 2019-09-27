package reqres.tests;

import com.epam.http.response.RestResponse;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reqres.ReqresApi;

import static com.epam.http.requests.RequestData.requestBody;
import static com.epam.http.requests.RequestData.requestData;
import static com.epam.http.requests.ServiceInit.init;
import static java.lang.String.format;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static reqres.ReqresApi.*;

public class ReqresTests {

    public static final int DEFAULT_AMOUNT_OF_USERS_PER_PAGE = 6;
    public static final String PAGE_NUM = "2";

    @BeforeClass
    public void initService() {
        init(ReqresApi.class);
    }

    /* 1. GET list of all users */
    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("Users"))
    public void getAllUsersListAndCheckItIsNotEmpty() {
        RestResponse response = usersGet
                .call();
        response.isOk();
    }

    /* 2. GET first names of all users on page 2 */
    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("Users"))
    public void getFirstNamesOfTheUsersOnConcretePage(){
        RestResponse response = getUserListOnConcretePage
                .call(requestData(d ->
                            d.queryParams.add("page", PAGE_NUM)
                ));
        response.isOk();
        response.assertThat().body("page", equalTo(Integer.parseInt(PAGE_NUM)));
        response.assertThat().body("data.first_name.size()", equalTo(DEFAULT_AMOUNT_OF_USERS_PER_PAGE));
    }

    /* 3. Create a new user with the name "Arnold" and
    Job as "Dev" and print new users details name and ID */
    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("Users"))
    public void createNewUserAndVerifyCreationTest() {
        String userName = "Arnold";
        String userJob = "Dev";
        RestResponse response = postCreateUserWithNameAndJob
                .call(requestBody(format("{\"name\": \"%s\"," +
                                         " \"job\": \"%s\"}",
                        userName, userJob)));
        response.isOk().body("name", equalTo(userName));
    }


    /* 4. Update the user's name to "Sam" */
    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("Users"))
    public void updateUserNameAndVerifyChangesTest() {
        String userId = "1";
        String newUserName = "Sam";
        RestResponse response = updateUserById
                .call(requestData(d -> {
                            d.pathParams.add("user_id", userId);
                            d.body = format("{\"id\": \"%s\"," +
                                            " \"name\": \"%s\"}",
                                    userId, newUserName);
                }));
        response.isOk().body("name", equalTo(newUserName));
    }

    /* 5. Delete the user */
    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("Users"))
    public void deleteUserAndVerifyDeletionTest() {
        String userId = "1";
        RestResponse response = deleteUserById
                .call(requestData(d -> {
                    d.pathParams.add("user_id", userId);
                }));
        response.isOk();
    }
}
