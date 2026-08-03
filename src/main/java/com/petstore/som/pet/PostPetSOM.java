package com.petstore.som.pet;

import com.awa.framework.core.PlaywrightDriver;
import com.awa.framework.utilities.ConfigReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.petstore.pojo.Pet;
import com.petstore.som.PrepareRequest;

public class PostPetSOM {
    static String endpoint = "/v2/pet";
    String method = "POST";
    String contentType = "application/json";

    public static PetPostResponse createPet(Pet pet) throws JsonProcessingException {
        System.out.println("----------------------------------------------");
        System.out.println("-------------Create Pet------------------------");
        System.out.println("----------------------------------------------");
        // Create Playwright instance
        String baseUrl = ConfigReader.getProperty("api.baseURL");
        APIRequestContext apiContext = PlaywrightDriver.getApiContext(baseUrl);
        APIResponse response = apiContext.post(baseUrl + endpoint, PrepareRequest.requestOptions(pet));

        System.out.println("Response Status : " + response.status());
        System.out.println("Response Body : " + response.text());


        ObjectMapper mapper = new ObjectMapper();
        PetPostResponse petPostResponse  = mapper.readValue(response.text(), PetPostResponse.class);


        assert response.ok();
        //cleanup activity
        apiContext.dispose();
        //playwright.close();
        return petPostResponse;
    }
}
