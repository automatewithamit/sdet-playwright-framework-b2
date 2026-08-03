package com.petstore.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.petstore.som.user.PostUserSOM;
import com.petstore.pojo.User;
import com.petstore.som.user.UserPOSTResponse;
import org.testng.annotations.Test;

public class UserAPITests {


    @Test
public void testCreateUser() throws JsonProcessingException {
        User user = new User("amittripathi", "Amit", "Tripathi", "amit.tripathi@gmail.com", "amit@123", "9876543210");
        UserPOSTResponse userResponse = PostUserSOM.createUser(user);

        System.out.println("Message : " + userResponse.getMessage());
        System.out.println("Code : " + userResponse.getCode());
        System.out.println("Type : " + userResponse.getType());

}



}
