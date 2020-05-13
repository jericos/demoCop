package demos;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1_GET_request {

    @Test
    void  getWeatherDetails(){

        //especificar  base URI

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        // request object
        RequestSpecification httprequest = RestAssured.given();

        // response object
        Response response = httprequest.request(Method.GET,"/Hyderabad");

        // imprimimos response en la consola
        String responseBody = response.getBody().asString();
        System.out.println("Response body is : "+responseBody);

        //statuws code validation
        int statusCode = response.statusCode();
        System.out.println("Status code is : "+statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line validation
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

//        JsonPath jsonPath = response.jsonPath();
//        System.out.println(jsonPath.get("Humidity"));
//        Assert.assertEquals(jsonPath.get("Humidity"),"44 Percent");
    }
}
