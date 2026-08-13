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
    private static final String ENDPOINT = "/v2/user";

    public static UserPOSTResponse createUser(User user) throws JsonProcessingException {
        String baseUrl = ConfigReader.getProperty("api.baseURL");
        APIRequestContext apiContext = PlaywrightDriver.getApiContext(baseUrl);
        APIResponse response = apiContext.post(ENDPOINT, PrepareRequest.requestOptions(user));
        try {
            if (!response.ok()) {
                throw new AssertionError("Create user failed. Status: " + response.status() + ", Body: " + response.text());
            }
            return new ObjectMapper().readValue(response.text(), UserPOSTResponse.class);
        } finally {
            PlaywrightDriver.closeApiContext();
            PlaywrightDriver.closePlaywright();
        }
    }
}
