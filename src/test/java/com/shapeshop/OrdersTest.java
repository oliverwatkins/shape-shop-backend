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


public class OrdersTest extends ShapeShopTest {

    @org.junit.Test
    public void placeOrder() throws Exception {

        String token = authenticate("admin", "admin");

        //default orders. Bob has ordered 1 hotdog
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/orders").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));

        JSONArray recievedArrayPreOrder = extractJSONArrayFromResponse(resultActions);
        JSONArray expectedArrayPreOrder = extractJSONArrayFromFileName("src/test/resources/orderList.json");

        System.out.println("recievedArray " + recievedArrayPreOrder);
        System.out.println("expectedArray " + expectedArrayPreOrder);

        JSONAssert.assertEquals(expectedArrayPreOrder, recievedArrayPreOrder, JSONCompareMode.STRICT);

        // place order
        String newOrderJSON = getNewOrderJSON();
        mvc.perform(MockMvcRequestBuilders.post("/carlscafe/orders").contentType("application/json").content(newOrderJSON)).andExpect(matcher.is(200));

        // retrieve orders again. Bob has ordered 1 hotdog, and Bob has also ordered 1 hotdoge and 2 hamburgers
        resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/orders").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));

        JSONArray recievedArray = extractJSONArrayFromResponse(resultActions);
        JSONArray expectedArray = extractJSONArrayFromFileName("src/test/resources/orderList_after_placeOrder_expected.json");

        System.out.println("recievedArray " + recievedArray);
        System.out.println("expectedArray " + expectedArray);

        JSONAssert.assertEquals(expectedArray, recievedArray, JSONCompareMode.STRICT);
    }

    private String getNewOrderJSON() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/test/resources/order.json"));
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            sb.append(in.nextLine());
        }
        in.close();
        String newOrderJSON = sb.toString();
        return newOrderJSON;
    }
}
