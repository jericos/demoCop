package demos;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo12_PUT_Customer {

    @Test
    public void putCCustomer(){

        //Define BaseURI
        RestAssured.baseURI = "https://int.ecommerce.autos.delorean.digital.pacificoseguros.com/api/delorean-autos-biz-services/insurances/vehicle/";

        JSONObject requestParams = new JSONObject();
        requestParams.put("channel", "");

        //Request Object
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.header("x-captcha-token", "03AGdBq25OU55jJRTzKBOQDRnht1vjSjOsycB_7eiXHJDMtsA70jNpteHrbGNgD6Rv0xsz6bmNGlL862eFK2Hj7N611KblaE8WcYGum2zOJAsberNnDL7aOB3jy6tviUZCNsB9MnBA8P5-CSKIsIUbQpvLU6K0EU-3e3xMnV0D505KliHHnPfdeG1U14rdiIck4oHZbDK8we-JZ8TYZufMwKE_IboI17aHPyd62Xz-1ItxaerQMPVU2neeTNHaq1IT9e8ehdu_fX3aILJPQcUFPIMYxLZNXja11uCE5nBCvcL240A_sBcXOOun7qlrbHGxIYUoLFjrdjtUo1rHxsggXS-1-lrw2xYd2GImos6ut9ZaRsKBwgq5qE9C6N-W7UsdqC0GXiOOSKwYncti67EFJOefZTpxumi9tRrD8EPMW7yspDGz05yI1deQR5T_FoOqUm_SfFmI2J_shiYh5a94LGefTVOccCmuNeQqOf0m2j1CypopgQFoLxE");
        requestSpecification.body(requestParams.toJSONString());

        //Response
        Response response = requestSpecification.request(Method.POST, "/requests");

        //Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        Assert.assertEquals(response.statusCode(), 200);

        String requestId = response.jsonPath().get("id");
        //=======================================================

        // Define BaseURI
        RestAssured.baseURI = "https://int.ecommerce.autos.delorean.digital.pacificoseguros.com/api/delorean-autos-biz-services/insurances/vehicle";

        requestParams = new JSONObject();
        requestParams.put("documentType", "DNI");
        requestParams.put("documentId", "30000023");

        //Request Object
        requestSpecification = RestAssured.given();

        requestSpecification.pathParam("id", requestId);
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.header("authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlZWJjNGQ2MC03ODA2LTRkZDAtOWY0OS0zZmFmYjgzOTk1ZjIiLCJhdWQiOiJodHRwczovL2Vjb21tZXJjZS5uYXV0b3MuZGVsb3JlYW4uaW5ub3ZhY2lvbnBhY2lmaWNvLmNvbSIsInNjb3BlIjoiRUNPTU1FUkNFX0RFTE9SRUFOX1VTRVIiLCJpc3MiOiJodHRwczovL2Vucm9sbG1lbnQuZGVsb3JlYW4uaW5ub3ZhY2lvbnBhY2lmaWNvLmNvbSIsImV4cCI6MTU5MDIzOTMxOCwiaWF0IjoxNTg5MzM5MzE4LCJqdGkiOiI1ZjM1Y2Q2YS0xYWUzLTRkMGMtOTA1Yy1hZjg4MmFlODg4MzgifQ.RHtFQFcsy87C3QhCpRkdb7pidPsShzPC3zcuiT6T9C0");
        requestSpecification.log().all();

        //Response
        response = requestSpecification.request(Method.PUT, "/requests/{id}/customer");

        //Response body
        responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        Assert.assertEquals(response.statusCode(), 200);

    }
}
