package tests.apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import restAssuredFilters.RequestFilter;
import restAssuredFilters.ResponseFilter;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class API_Interception {

    public static String loginToken;

    @BeforeTest
    @Parameters({"apiBaseUrl"})
    public void setup(String apiBaseUrl){
        baseURI = apiBaseUrl;
    }

    @BeforeMethod
    public void consolePrint(){
        System.out.println("\n----------------------------------- NEW API TEST STARTED -----------------------------------\n");
    }

    @Test
    public void getLoginToken(){
        basePath = "/ecom/auth";
        Map<String, String> requestPayload = new HashMap<>();
        requestPayload.put("userEmail", "muskanv01lko@gmail.com");
        requestPayload.put("userPassword", "Mv@12345678");

        Response response = given()
                .contentType("application/json")
                .body(requestPayload)
                .log().all()
                .when()
                .post("/login");
        loginToken = response.body().jsonPath().getString("token");
        System.out.println("RECEIVED LOGIN TOKEN: " + loginToken);
    }

    @Test(description = "API Request Interception Test - Modify Order ID", dependsOnMethods = "getLoginToken")
    public void check_unauthorized_users_access_blocked() {
        String correctOrderId = "63bbc34a568c3e9fb1f0fadd";
        basePath = "/ecom/order/get-orders-for-customer/" + correctOrderId;

        Response response = given()
                .header("Authorization", loginToken)
                .contentType("application/json")
                .log().all()
                .filter(new RequestFilter())
                .when()
                .log().all()
                .get().then().log().all().extract().response();

        Assert.assertEquals(response.getStatusCode(), 403);

        System.out.println("\nVALIDATION COMPLETED - UNAUTHORIZED USER BLOCKED");
        System.out.println("\nResponse Status Code: " + response.getStatusCode());
        System.out.println("Interception Response: " + response.jsonPath().getString("message"));
    }


    @Test(description = "API Response Interception Test - Intercept response data payload", dependsOnMethods = "getLoginToken")
    public void zero_order_items_found(){
        basePath = "/ecom/order/get-orders-for-customer/";
        Response response =  given()
                .header("Authorization", loginToken)
                .filter(new ResponseFilter())
                .log().all()
                .when()
                .get("63bbc34a568c3e9fb1f0fadd");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getList("data").size(), 0);
        System.out.println("\nVALIDATION COMPLETED - RESPONSE INTERCEPTED TO SHOW ZERO ORDERS");
        System.out.println("\nResponse Status Code: " + response.getStatusCode());
        System.out.println("Interception Response: " + response.asString());
    }

}
