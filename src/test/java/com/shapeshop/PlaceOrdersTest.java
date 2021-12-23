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
        while(in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        String newOrderJSON = sb.toString();

        ResultActions xxx = mvc.perform(MockMvcRequestBuilders.post("/carlscafe/orders").contentType("application/json").content(newOrderJSON)).andExpect(matcher.is(200));

        String token = authenticate("admin", "admin");

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/orders").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));

        JSONArray recievedArray = extractJSONArrayFromResponse(resultActions);

        JSONArray expectedArray = expectedArray();

        System.out.println("recievedArray " + recievedArray);
        System.out.println("expectedArray " + expectedArray);

        JSONAssert.assertEquals(expectedArray, recievedArray, JSONCompareMode.STRICT);
    }
//    private Object parse(String s) {
//        try {
//            JSONParser parser = new JSONParse();
//            return parser.parse(s);
//        } catch (Exception e) {
//            throw new IllegalStateException("Invalid JSON: " + s, e);
//        }
//    }

    private JSONArray expectedArray() throws FileNotFoundException {



        Scanner in = new Scanner(new FileReader("src/test/resources/order_expected.json"));
        StringBuilder sb = new StringBuilder();
        while(in.hasNextLine()) {

            String s = in.nextLine();
//            System.out.println("recievedArray " + s);
            sb.append(s);
        }
        in.close();
        String newOrderJSON = sb.toString();

        JSONArray array = new JSONArray(newOrderJSON);
        return array;



//        JSONObject order = new JSONObject();
//        order.put("date", 1639619535992l);
//        order.put("creditCardEntity", new JSONObject()
//                .put("number", "xxxx-xxxx-xxxx-1234")
//                .put("name", "Bob")
//                .put("type", "VISA")
//                .put("expDate", "22/22"));
//        order.put("deliveryType", "DELIVERY");
//        order.put("company", new JSONObject()
//                .put("name", "carlscafe").put("id", 1));
//        order.put("id", 1);
//        order.put("state", "OPEN");
//        order.put("addressEntity", new JSONObject()
//                .put("street", "5 Bob st. Bobville")
//                .put("name", "Bob")
//                .put("postcode", "12345")
//                .put("telephone", "+(09)1234567")
//                .put("email", "bob@gmail.com"));
//        order.put("orderItems", new JSONArray()
//                .put(new JSONObject().put("product", new JSONObject()
//                                .put("imageFilename", "na.png")
//                                .put("price", 7.9)
//                                .put("name", "hotdog")
//                                //TODO company and orders hanging off the product entity is redundant
//                                .put("company", new JSONObject().put("name", "carlscafe").put("id", 1))
//                                .put("orders", new JSONArray())
//                                .put("id", 2)
//                                .put("type", "main"))
//                        .put("amount", 1)
//                        .put("id", 1)
//
//                ));
//        order.put("paymentType", "CARD");
//
//        JSONObject order2 = new JSONObject();
//        order2.put("date", 1639619535992l);
//        order2.put("creditCardEntity", new JSONObject()
//                .put("number", "xxxx-xxxx-xxxx-1234")
//                .put("name", "Bob")
//                .put("id", 1)
//                .put("type", "VISA")
//                .put("expDate", "22/22"));
//        order2.put("deliveryType", "DELIVERY");
//        order2.put("company", new JSONObject()
//                .put("name", "carlscafe").put("id", 1));
//        order2.put("id", 1);
//        order2.put("state", "OPEN");
//        order2.put("addressEntity", new JSONObject()
//                .put("street", "Bluw Lane Hwy 12")
//                .put("name", "Bob")
//                .put("postcode", "41412")
//                .put("telephone", "+(09)928423444")
//                .put("id", 1)
//                .put("email", "jj@gmail.com"));
//        order2.put("orderItems", new JSONArray()
//                .put(new JSONObject().put("product", new JSONObject()
//                                .put("imageFilename", "na.png")
//                                .put("price", 7.9)
//                                .put("name", "hotdog")
//                                //TODO company and orders hanging off the product entity is redundant
//                                .put("company", new JSONObject().put("name", "carlscafe").put("id", 1))
//                                .put("orders", new JSONArray())
//                                .put("id", 1)
//                                .put("type", "main"))
//                        .put("amount", 1)
//                        .put("id", 1)
//
//                )
//                .put(new JSONObject().put("product", new JSONObject()
//                                .put("imageFilename", "na.png")
//                                .put("price", 7.9)
//                                .put("name", "hamburger")
//                                //TODO company and orders hanging off the product entity is redundant
//                                .put("company", new JSONObject().put("name", "carlscafe").put("id", 1))
//                                .put("orders", new JSONArray())
//                                .put("id", 2)
//                                .put("type", "main"))
//                        .put("amount", 1)
//                        .put("id", 1)
//
//                )
//        );
//        order2.put("paymentType", "CARD");
//
//        JSONArray array = new JSONArray();
//        array.put(order);
//        array.put(order2);
//        return array;
    }
}

