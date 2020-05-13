package demos;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.CommonServicesUtil;
import services.EndPoint;
import services.RestAssuredConfiguration;

public class Demo10_POST_request {

    public static String abaseURI = "https://int.ecommerce.autos.delorean.digital.pacificoseguros.com/api";
    public static String abasePath = "/api/delorean-autos-biz-services/insurances/vehicle";

    @Test
    public void postRequest() {

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
    }

    public static Response postRequest(String authorization, String captchaToken, String channel) {

        String strBody = CommonServicesUtil.getBodyChannel(channel);
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(abaseURI, abasePath, 0);
        requestSpecification.header("X-Captcha-Token", captchaToken);
        return new RestAssuredConfiguration().getResponsePost(requestSpecification.body(strBody), EndPoint.POST_REQUEST);
    }

}
