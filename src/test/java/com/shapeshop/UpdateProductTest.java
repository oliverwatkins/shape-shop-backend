package com.shapeshop;


import com.shapeshop.config.ShapeShopTest;
import com.shapeshop.config.TestConfig;
import org.hamcrest.CoreMatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class UpdateProductTest extends ShapeShopTest {


    /**
     * update product with ID and change its name
     */
    @org.junit.Test
    public void updateProduct() throws Exception {

        //update price from 4.5 to 5.5
        String updateProductJSON =
                "{\"name\": \"hamburger\"," +
                "\"price\": \"5.5\", " +
                "\"id\": \"2\"}";

        String token = authenticate("admin", "admin");

        // update
        mvc.perform(MockMvcRequestBuilders.put("/alpenhof/products/2")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(updateProductJSON)).andExpect(matcher.is(200));

        // get
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/alpenhof/products/2").contentType("application/json")
                .content(updateProductJSON)).andExpect(matcher.is(200));

        JSONObject obj = extractJSONObjectFromResponse(resultActions);

        JSONObject expectedObject = expectedObject();

        JSONAssert.assertEquals(expectedObject, obj, JSONCompareMode.STRICT);
    }

    private JSONObject expectedObject() {

        JSONObject p1 = new JSONObject().put("id", 13);
        p1.put("id", 2);
        p1.put("name", "hamburger");
        p1.put("price", 5.5);
        p1.put("type", "main");
        p1.put("imageFilename", "na.png");
        p1.put("company", new JSONObject().put("name", "carlscafe").put("id", 1));
        p1.put("orders", new JSONArray());
        return p1;
    }
}
