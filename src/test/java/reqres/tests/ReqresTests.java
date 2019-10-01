package reqres.tests;

import com.epam.http.response.ResponseStatusType;
import com.epam.http.response.RestResponse;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reqres.Info;
import reqres.ReqresApi;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static com.epam.http.requests.RequestData.requestBody;
import static com.epam.http.requests.RequestData.requestData;
import static com.epam.http.requests.ServiceInit.init;
import static java.lang.String.format;
import static org.hamcrest.core.IsEqual.equalTo;
import static reqres.ReqresApi.*;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class ReqresTests {

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
    public void getFirstNamesOfTheUsersOnConcretePage() {
        ArrayList<String> firstNames = new ArrayList<>();
        Info entity = getInfoOnSecondPage
                .asData(Info.class);
        int amountOfUsersPerPage = entity.per_page;
        for (int i = 0; i < amountOfUsersPerPage; i++){
            String firstName = (String) ((LinkedHashMap) ((ArrayList) entity.data).get(i)).get("first_name");
            firstNames.add(firstName);
        }
        logger.toLog("[AUT-INFO] The final list is :: " + firstNames.toString());
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

    /* 6. Get resource list */
    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("resource"))
    public void getResourcesListAndCheckItIsNotEmpty() {
        RestResponse response = getResource
                .call();
        response.isOk();
    }

    /* 7. Get single resource */
    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("resource"))
    public void getSingleResourcesAndCheckItIsNotEmpty() {
        String resourceId = "2";
        RestResponse response = getSingleResource
                .call(requestData(d ->
                        d.pathParams.add("resource_id", resourceId)));
        response.isOk();
    }

    /* 8. Single resource not found */
    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("resource"))
    public void getUnavailableSingleResourcesAndCheckItIsNotEmpty() {
        String resourceId = "23";
        RestResponse response = getSingleResource
                .call(requestData(d ->
                        d.pathParams.add("resource_id", resourceId)));
        response.isStatus(ResponseStatusType.getStatusTypeFromCode(404));
    }
}
