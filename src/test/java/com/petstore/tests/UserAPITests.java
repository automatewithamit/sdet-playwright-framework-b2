package com.petstore.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.petstore.pojo.User;
import com.petstore.som.user.PostUserSOM;
import com.petstore.som.user.UserPOSTResponse;
import com.petstore.testdata.PetStoreDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAPITests {
    @Test(dataProvider = "users", dataProviderClass = PetStoreDataProvider.class, groups = {"api"})
    public void testCreateUser(User user) throws JsonProcessingException {
        UserPOSTResponse userResponse = PostUserSOM.createUser(user);
        Assert.assertEquals(userResponse.getCode(), 200);
        Assert.assertEquals(userResponse.getType(), "unknown");
        Assert.assertFalse(userResponse.getMessage().isBlank());
    }
}
