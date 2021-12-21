package com.shapeshop;

import com.shapeshop.config.ShapeShopTest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class GetOrdersTest extends ShapeShopTest {


	/**
	 * Get orders via HTTP
	 */
	@org.junit.Test
    public void getOrders() throws Exception {

        String token = authenticate("admin", "admin");

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/orders").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));

        JSONArray recievedArray = extractJSONArrayFromResponse(resultActions);

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
                        .put("id", 2)
                        .put("type", "main"))
                    .put("amount", 1)
                    .put("id", 1)

        ));
        order.put("paymentType", "CARD");

        JSONArray array = new JSONArray();
        array.put(order);
        return array;
    }
}
