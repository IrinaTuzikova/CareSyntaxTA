package reqres;

import com.epam.http.annotations.ServiceDomain;
import com.epam.http.annotations.*;
import com.epam.http.requests.RestMethod;

import static io.restassured.http.ContentType.JSON;

@ServiceDomain("https://reqres.in/api")

public class ReqresApi {
    public static final String USERS = "/users";

    @ContentType(JSON) @GET(USERS)
    public static RestMethod usersGet;

    //GET first names of all users on page 2
    @ContentType(JSON) @GET("/users?page={page}")
    public static RestMethod getUserWithNameAndOnConcretePage;

    //Create a new user with the name "Arnold"
    //and Job as "Dev" and print new users details name and ID
    @ContentType(JSON) @POST("/users")
    public static RestMethod postCreateUserWithNameAndJob;

    //Update the user's name to "Sam"
    @ContentType(JSON) @PUT("/users/{user_id}")
    public static RestMethod updateUserName;

    //Delete the user
    @ContentType(JSON) @DELETE("/users/{user_id}")
    public static RestMethod deleteUserById;
}
