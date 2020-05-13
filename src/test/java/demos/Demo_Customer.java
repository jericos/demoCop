package demos;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_Customer {

    @Test
    public void postTokenTest(){

        // Define BaseURI
        RestAssured.baseURI = "https://servicewapdigitaldes0100.azurewebsites.net/ecom-onco/auth/v2";

        String resource = "3335e89d-f67a-4b6e-85e1-f32c5413e512";

        JSONObject requestParams = new JSONObject();
        requestParams.put("resource", resource);

        // Request Object
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        // Response
        Response response = httpRequest.request(Method.POST, "/token/");

        // ResponseBody
        String responseBody = response.getBody().asString();
        System.out.println("Response body is : " + responseBody);

        //status code validation
        int statusCode = response.statusCode();
        System.out.println("Status code is : " + statusCode);
        Assert.assertEquals(statusCode, 200);

        String bearer = response.jsonPath().get("token_type")+response.jsonPath().get("access_token").toString();

        //==============================

        // Define BaseURI
        RestAssured.baseURI = "https://pdu-integration.eastus2.cloudapp.azure.com/rs-ne-cliente-oncologico-sld/servicio-al-cliente/oncologico";

        // Request Object
        RequestSpecification httprequest = RestAssured.given();

        // request payload sending along with post request
         requestParams = new JSONObject();
        requestParams.put("documentType", "DNI");
        requestParams.put("documentId", "30000021");

        httprequest.header("Content-Type", "application/json");
        httpRequest.auth().basic("authorization",bearer);
        httprequest.body(requestParams.toJSONString());

        // response object
         response = httprequest.request(Method.POST, "/v1/customer");

        // imprimimos response en la consola
         responseBody = response.getBody().asString();
        System.out.println("Response body is : " + responseBody);

        //status code validation
         statusCode = response.statusCode();
        System.out.println("Status code is : " + statusCode);
        Assert. assertEquals(statusCode, 201);

        //success code validation
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");

        //status line validation
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
    }
}
