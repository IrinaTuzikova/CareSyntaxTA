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
import static com.epam.http.requests.RequestData.requestPathParams;
import static com.epam.http.requests.ServiceInit.init;
import static java.lang.String.format;
import static org.hamcrest.core.IsEqual.equalTo;
import static reqres.ReqresApi.*;

public class ReqresTests {

    int PAGE_NUM = 2;

    @BeforeClass
    public void initService() {
        init(ReqresApi.class);
    }

    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("Users"))
    public void getAllUsersListAndCheckItIsNotEmpty() {
        RestResponse response = usersGet
                .call();
        response.isOk().body("first_name", equalTo("Michael"));
    }

    //GET first names of all users on page 2
    @Test(groups = "func")
    @Features(@Feature( "API"))
    @Stories(@Story("Users"))
    public void getFirstNamesOfTheUsersOnConcretePage(){
        RestResponse response = getUserWithNameAndOnConcretePage
                .call(requestPathParams("page", "2"));
        response.isOk();

    }

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

}
