package com.shapeshop;

import com.shapeshop.config.ShapeShopTest;
import org.json.JSONArray;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class PlaceOrdersTest extends ShapeShopTest {

    @org.junit.Test
    public void placeOrder() throws Exception {

        Scanner in = new Scanner(new FileReader("src/test/resources/order.json"));
        StringBuilder sb = new StringBuilder();
        while(in.hasNextLine()) {
            sb.append(in.nextLine());
        }
        in.close();
        String newOrderJSON = sb.toString();

        mvc.perform(MockMvcRequestBuilders.post("/carlscafe/orders").contentType("application/json").content(newOrderJSON)).andExpect(matcher.is(200));

        String token = authenticate("admin", "admin");

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/orders").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));

        JSONArray recievedArray = extractJSONArrayFromResponse(resultActions);

        JSONArray expectedArray = expectedArray();

        System.out.println("recievedArray " + recievedArray);
        System.out.println("expectedArray " + expectedArray);

        JSONAssert.assertEquals(expectedArray, recievedArray, JSONCompareMode.STRICT);
    }

    private JSONArray expectedArray() throws FileNotFoundException {

        Scanner in = new Scanner(new FileReader("src/test/resources/orderList_after_placeOrder_expected.json"));
        StringBuilder sb = new StringBuilder();
        while(in.hasNextLine()) {
            String s = in.nextLine();
            sb.append(s);
        }
        in.close();
        String newOrderJSON = sb.toString();

        JSONArray array = new JSONArray(newOrderJSON);
        return array;
    }
}
