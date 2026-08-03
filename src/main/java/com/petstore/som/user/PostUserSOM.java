package com.petstore.som.user;

import com.awa.framework.core.PlaywrightDriver;
import com.awa.framework.utilities.ConfigReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.petstore.pojo.User;
import com.petstore.som.PrepareRequest;

public class PostUserSOM {
    //This Class is used to create the request body for creating a user in the petstore API
    String endpoint = "/v2/user";
    String method = "POST";
    String contentType = "application/json";

    public static UserPOSTResponse createUser(User user) throws JsonProcessingException {
        System.out.println("----------------------------------------------");
        System.out.println("-------------Create User------------------------");
        System.out.println("----------------------------------------------");
        // Create Playwright instance
        String baseUrl = ConfigReader.getProperty("api.baseURL");
        APIRequestContext apiContext = PlaywrightDriver.getApiContext(baseUrl);
        APIResponse response = apiContext.post(baseUrl +"/v2/user", PrepareRequest.requestOptions(user));

        System.out.println("Response Status : " + response.status());
        System.out.println("Response Body : " + response.text());


        ObjectMapper mapper = new ObjectMapper();
        UserPOSTResponse userResponse  = mapper.readValue(response.text(), UserPOSTResponse.class);


        assert response.ok();
        //cleanup activity
        apiContext.dispose();
        //playwright.close();
        return  userResponse;
    }


}
