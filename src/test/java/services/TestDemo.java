package services;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo {

    private int statusOk = HttpStatus.SC_OK;
    private static String requestId = "";
    private static String authorization = "";

    @Test
    private void validatePostRequest() {

        int aStatusExpected = HttpStatus.SC_OK;
        String aChannel = "";

        Response response = ResponseServices.postRequest("", "", aChannel);
        authorization = response.header("authorization");
        requestId = response.path("id").toString();
        System.out.println("Id [" + requestId + "] - Authorization [" + authorization + "]");

        Assert.assertEquals(response.getStatusCode(), aStatusExpected);

    }

    public static void validatePostRequest(String aChannel) {

        int aStatusExpected = HttpStatus.SC_OK;

        Response response = ResponseServices.postRequest("", "", aChannel);
        authorization = response.header("authorization");
        requestId = response.path("id").toString();
        System.out.println("Id [" + requestId + "] - Authorization [" + authorization + "]");

        Assert.assertEquals(response.getStatusCode(), aStatusExpected);

    }
}
