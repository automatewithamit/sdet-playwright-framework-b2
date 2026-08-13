package com.petstore.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.petstore.pojo.Pet;
import com.petstore.som.pet.PetPostResponse;
import com.petstore.som.pet.PostPetSOM;
import com.petstore.testdata.PetStoreDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetAPITests {
    @Test(description = "Test to create a new pet in the Petstore API", dataProvider = "pets", dataProviderClass = PetStoreDataProvider.class, groups = {"api", "smoke"})
    public void testCreatePets(Pet petPayload) throws JsonProcessingException {
        PetPostResponse petResponse = PostPetSOM.createPet(petPayload);
        Assert.assertEquals(petResponse.getId(), petPayload.getId());
        Assert.assertEquals(petResponse.getName(), petPayload.getName());
        Assert.assertEquals(petResponse.getStatus(), petPayload.getStatus());
    }
}
