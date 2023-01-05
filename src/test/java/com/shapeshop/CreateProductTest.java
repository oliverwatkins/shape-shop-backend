package com.shapeshop;


import com.shapeshop.config.ShapeShopTest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class CreateProductTest extends ShapeShopTest {

    @Test
    public void createProduct() throws Exception {
        JSONObject createProductJSON = extractJSONObjectFromFileName("src/test/resources/createProduct.json");

        String token = authenticate("admin", "admin");

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/carlscafe/products")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(createProductJSON.toString())).andExpect(matcher.is(200));

        JSONObject ja = extractJSONObjectFromResponse(resultActions);

        System.out.println("ja " + ja);
        //TODO do some kind of compare. returned prod should have an id created.

    }

    @Test
    public void createProduct_catDoesntExist() throws Exception {
        JSONObject createProductJSON = extractJSONObjectFromFileName("src/test/resources/createProduct_catDoesntExist.json");

        String token = authenticate("admin", "admin");

        mvc.perform(MockMvcRequestBuilders.post("/carlscafe/products")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(createProductJSON.toString())).andExpect(matcher.is(500)); //category does not exist
    }

}
