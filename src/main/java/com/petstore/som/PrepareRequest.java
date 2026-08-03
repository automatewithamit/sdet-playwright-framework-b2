package com.petstore.som;

import com.microsoft.playwright.options.RequestOptions;

public class PrepareRequest {
    public static RequestOptions requestOptions(Object object){
        RequestOptions requestOption = RequestOptions.create()
                .setHeader("accept","application/json")
                .setHeader("Content-Type","application/json")
                .setData(object);

        return requestOption;
    }
}
