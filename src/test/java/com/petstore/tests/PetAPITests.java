package com.petstore.tests;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.petstore.pojo.Category;
import com.petstore.pojo.Pet;
import com.petstore.pojo.Tag;
import com.petstore.som.pet.PetPostResponse;
import com.petstore.som.pet.PostPetSOM;
import org.testng.annotations.Test;
import java.util.List;

public class PetAPITests {

    @Test(description = "Test to create a new pet in the Petstore API")
    public void testCreatePets() throws JsonProcessingException {
//      User user = new User("amittripathi", "Amit", "Tripathi", "amit.tripathi@gmail.com", "amit@123", "9876543210");
//      UserPOSTResponse userResponse = PostUserSOM.createUser(user);
//      System.out.println("Message : " + userResponse.getMessage());
//      System.out.println("Code : " + userResponse.getCode());
//      System.out.println("Type : " + userResponse.getType());

        Category category = new Category();
        category.setId(1);
        category.setName("Dogs");

        Tag tag1 = new Tag();
        tag1.setId(12);
        tag1.setName("Golden Retriever");

        Tag tag2 = new Tag();
        tag2.setId(15);
        tag2.setName("Friendly");

        // 3. Build Pet Request Object
        Pet petPayload = new Pet();
        petPayload.setId(459201L);
        petPayload.setCategory(category);
        petPayload.setName("Max");
        petPayload.setPhotoUrls(List.of("https://example.com", "https://example.com"));
        petPayload.setTags(List.of(tag1, tag2));
        petPayload.setStatus("available");

        // 4. Fire API Request using your SOM Pattern
        // (Ensure you create the PostPetSOM class to handle the RestAssured/HTTP POST logic)
        PetPostResponse petResponse = PostPetSOM.createPet(petPayload);

        // 5. Console Validation / Verification
        System.out.println("Created Pet Name: " + petResponse.getName());
        System.out.println("Created Pet ID: " + petResponse.getId());
        System.out.println("Pet Status: " + petResponse.getStatus());
    }
}
