package reqres;

import com.epam.http.annotations.ServiceDomain;
import com.epam.http.annotations.*;
import com.epam.http.requests.RestMethod;

import static io.restassured.http.ContentType.JSON;

@ServiceDomain("https://reqres.in/api")

public class ReqresApi {

    @ContentType(JSON) @GET("/users")
    @QueryParameter(name = "page", value="2")
    public static RestMethod<Info> getInfoOnSecondPage;

    @ContentType(JSON) @GET("/users")
    public static RestMethod usersGet;

    @ContentType(JSON) @GET("/users")
    public static RestMethod getUserListOnConcretePage;

    @ContentType(JSON) @POST("/users")
    public static RestMethod postCreateUserWithNameAndJob;

    @ContentType(JSON) @PUT("/users/{user_id}")
    public static RestMethod updateUserById;

    @ContentType(JSON) @DELETE("/users/{user_id}")
    public static RestMethod deleteUserById;

}
