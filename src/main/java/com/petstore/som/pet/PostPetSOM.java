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
    private static final String ENDPOINT = "/v2/pet";

    public static PetPostResponse createPet(Pet pet) throws JsonProcessingException {
        String baseUrl = ConfigReader.getProperty("api.baseURL");
        APIRequestContext apiContext = PlaywrightDriver.getApiContext(baseUrl);
        APIResponse response = apiContext.post(ENDPOINT, PrepareRequest.requestOptions(pet));
        try {
            if (!response.ok()) {
                throw new AssertionError("Create pet failed. Status: " + response.status() + ", Body: " + response.text());
            }
            return new ObjectMapper().readValue(response.text(), PetPostResponse.class);
        } finally {
            PlaywrightDriver.closeApiContext();
            PlaywrightDriver.closePlaywright();
        }
    }
}
