package com.petstore.testdata;

import com.petstore.pojo.*;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.UUID;

public class PetStoreDataProvider {
    @DataProvider(name = "users")
    public static Object[][] users() {
        String suffix = UUID.randomUUID().toString().substring(0, 8);
        return new Object[][]{{new User("user_" + suffix, "Amit", "Tripathi", "amit_" + suffix + "@example.com", "amit@123", "9876543210")}};
    }

    @DataProvider(name = "pets")
    public static Object[][] pets() {
        Category category = new Category(1, "Dogs");
        Tag tag1 = new Tag(12, "Golden Retriever");
        Tag tag2 = new Tag(15, "Friendly");
        Pet pet = new Pet(System.currentTimeMillis(), category, "Max", List.of("https://example.com/max.png"), List.of(tag1, tag2), "available");
        return new Object[][]{{pet}};
    }
}
