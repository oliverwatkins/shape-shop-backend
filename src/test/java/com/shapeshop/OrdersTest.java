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

import java.util.Date;

import static org.junit.Assert.*;

@Import(TestConfig.class)
@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrdersTest {

	StatusResultMatchers matcher = MockMvcResultMatchers.status();
    @Autowired
    private MockMvc mvc;

	/**
	 * Get orders via HTTP
	 */
	@org.junit.Test
    public void getOrders() throws Exception {

        String token = authenticate();

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/orders").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        JSONArray recievedArray = new JSONArray(contentAsString);
        JSONArray expectedArray = expectedArray();

        System.out.println("recievedArray " + recievedArray);
        System.out.println("expectedArray " + expectedArray);

        JSONAssert.assertEquals(expectedArray, recievedArray, JSONCompareMode.STRICT);
    }



    private JSONArray expectedArray() {

        JSONObject order = new JSONObject();
        order.put("date", 1639619535992l);
        order.put("creditCardEntity", new JSONObject()
                .put("number", "xxxx-xxxx-xxxx-1234")
                .put("name", "Bob")
                .put("id", 1)
                .put("type", "VISA")
                .put("expDate", "22/22"));
        order.put("deliveryType", "DELIVERY");
        order.put("company", new JSONObject()
                .put("name", "carlscafe").put("id", 1));
        order.put("id", 1);
        order.put("state", "OPEN");
        order.put("addressEntity", new JSONObject()
                .put("street", "Bluw Lane Hwy 12")
                .put("name", "Bob")
                .put("postcode", "41412")
                .put("telephone", "+(09)928423444")
                .put("id", 1)
                .put("email", "jj@gmail.com"));
        order.put("orderItems", new JSONArray()
                .put(new JSONObject().put("product", new JSONObject()
                        .put("imageFilename", "na.png")
                        .put("price", 7.9)
                        .put("name", "hotdog")
                        //TODO company and orders hanging off the product entity is redundant
                        .put("company", new JSONObject().put("name", "carlscafe").put("id", 1))
                        .put("orders", new JSONArray())
                        .put("id", 14)
                        .put("type", "main"))
                    .put("amount", 1)
                    .put("id", 1)

        ));
        order.put("paymentType", "CARD");

        JSONArray array = new JSONArray();
        array.put(order);
        return array;
    }

    private String authenticate() throws Exception {
        String requestJson = "{\"username\": \"admin\",\"password\": \"admin\"}";

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType("application/json").content(requestJson)).andExpect(matcher.isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        System.out.println("contentAsString " + contentAsString);

        String token = contentAsString.substring(8, contentAsString.length()-2);

        assertNotNull(token);
        return token;
    }
}
