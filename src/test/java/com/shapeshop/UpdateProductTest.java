package com.shapeshop;


import com.shapeshop.config.ShapeShopTest;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class UpdateProductTest extends ShapeShopTest {

    @org.junit.Test
    public void updateProduct() throws Exception {

        //update price from 4.5 to 5.5
        String updateProductJSON =
                "{\"name\": \"hamburger\"," +
                "\"price\": \"5.5\", " +
                "\"id\": \"2\"}";

        String token = authenticate("admin", "admin");

        // update
        mvc.perform(MockMvcRequestBuilders.put("/carlscafe/products/2")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(updateProductJSON)).andExpect(matcher.is(200));

        // get
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/products/2").contentType("application/json")
                .content(updateProductJSON)).andExpect(matcher.is(200));

        JSONObject obj = extractJSONObjectFromResponse(resultActions);
        JSONObject expectedObject = extractJSONObjectFromFileName("src/test/resources/updatedProduct.json");

        JSONAssert.assertEquals(expectedObject, obj, JSONCompareMode.STRICT);
    }
}
