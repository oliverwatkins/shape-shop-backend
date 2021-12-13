package com.shapeshop;

import org.json.JSONArray;
import org.json.JSONObject;
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

@Import(TestConfig.class)
@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductTest {

    StatusResultMatchers matcher = MockMvcResultMatchers.status();
    @Autowired
    private MockMvc mvc;

    /**
     * Get orders via HTTP
     */
    @org.junit.Test
    public void getProducts() throws Exception {

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/alpenhof/products")).andExpect(matcher.isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        JSONObject p1 = new JSONObject();
        p1.put("id", 13);
        p1.put("name", "hamburger");
        p1.put("price", 1.5);
        p1.put("type", "main");
        p1.put("imageFilename", "na.png");

        JSONObject p2 = new JSONObject();
        p2.put("id", 14);
        p2.put("name", "hotdog");
        p2.put("price", 7.9);
        p2.put("type", "main");
        p2.put("imageFilename", "na.png");

        JSONObject p3 = new JSONObject();
        p3.put("id", 15);
        p3.put("name", "donut");
        p3.put("price", 7.9);
        p3.put("type", "main");
        p3.put("imageFilename", "na.png");

        JSONObject p4 = new JSONObject();
        p4.put("id", 16);
        p4.put("name", "coke");
        p4.put("price", 4.5);
        p4.put("type", "drinks");
        p4.put("imageFilename", "na.png");

        JSONObject p5 = new JSONObject();
        p5.put("id", 17);
        p5.put("name", "water");
        p5.put("price", 4.5);
        p5.put("type", "drinks");
        p5.put("imageFilename", "na.png");

        JSONArray array = new JSONArray();
        array.put(p1);
        array.put(p2);
        array.put(p3);
        array.put(p4);
        array.put(p5);

        JSONArray array2 = new JSONArray(contentAsString);

        JSONAssert.assertEquals(
                array, array2, JSONCompareMode.LENIENT);
    }

}
