package services;

import org.json.simple.JSONObject;

public class CommonServicesUtil {

    public static String getBodyChannel(String pChannel) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("channel", pChannel);
        return requestParams.toString();

    }
}
