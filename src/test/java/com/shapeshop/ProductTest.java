package com.shapeshop;

import com.shapeshop.config.ShapeShopTest;
import com.shapeshop.config.TestConfig;
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


public class ProductTest extends ShapeShopTest {

    @org.junit.Test
    public void getProducts() throws Exception {

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/products")).andExpect(matcher.isOk());

        JSONArray recievedArray = extractJSONArrayFromResponse(resultActions);

        JSONArray expectedArray = expectedArray();

        System.out.println("recievedArray " + recievedArray);
        System.out.println("expectedArray " + expectedArray);

        JSONAssert.assertEquals(
                expectedArray, recievedArray, JSONCompareMode.LENIENT);
    }

    private JSONArray expectedArray() {
        JSONObject p1 = new JSONObject().put("id", 13);
        p1.put("id", 1);
        p1.put("name", "hamburger");
        p1.put("price", 1.5);
        p1.put("type", "main");
        p1.put("imageFilename", "na.png");
        p1.put("company", new JSONObject()
                .put("name", "carlscafe").put("id", 1));
        p1.put("orders", new JSONArray());

        JSONObject p2 = new JSONObject();
        p2.put("id", 2);
        p2.put("name", "hotdog");
        p2.put("price", 7.9);
        p2.put("type", "main");
        p2.put("imageFilename", "na.png");
        p1.put("company", new JSONObject()
                .put("name", "carlscafe").put("id", 1));
        p1.put("orders", new JSONArray());

        JSONObject p3 = new JSONObject();
        p3.put("id", 3);
        p3.put("name", "donut");
        p3.put("price", 7.9);
        p3.put("type", "main");
        p3.put("imageFilename", "na.png");
        p1.put("company", new JSONObject()
                .put("name", "carlscafe").put("id", 1));
        p1.put("orders", new JSONArray());

        JSONObject p4 = new JSONObject();
        p4.put("id", 4);
        p4.put("name", "coke");
        p4.put("price", 4.5);
        p4.put("type", "drinks");
        p4.put("imageFilename", "na.png");
        p1.put("company", new JSONObject()
                .put("name", "carlscafe").put("id", 1));
        p1.put("orders", new JSONArray());

        JSONObject p5 = new JSONObject();
        p5.put("id", 5);
        p5.put("name", "water");
        p5.put("price", 4.5);
        p5.put("type", "drinks");
        p5.put("imageFilename", "na.png");
        p1.put("company", new JSONObject()
                .put("name", "carlscafe").put("id", 1));
        p1.put("orders", new JSONArray());

        JSONArray array = new JSONArray();
        array.put(p1);
        array.put(p2);
        array.put(p3);
        array.put(p4);
        array.put(p5);
        return array;
    }
}
