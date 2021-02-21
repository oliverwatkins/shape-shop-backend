package com.shapeshop;

import net.minidev.json.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.Assert.*;


@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GetOrdersTest {


	StatusResultMatchers matcher = MockMvcResultMatchers.status();
    @Autowired
    private MockMvc mvc;


    @org.junit.Test
    public void orders() throws Exception {

    	mvc.perform(MockMvcRequestBuilders.get("/alpenhof/orders")).andExpect(matcher.isForbidden());


    	String requestJson = "{\"username\": \"admin\",\"password\": \"foo\"}";

    	ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType("application/json").content(requestJson)).andExpect(matcher.is(200));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        System.out.println("contentAsString " + contentAsString);

        String token = contentAsString.substring(8, contentAsString.length()-2);

        System.out.println("token " + token);

        assertNotNull(token);

    	resultActions = mvc.perform(MockMvcRequestBuilders.get("/alpenhof/orders").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));

        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();


//		JSONObject jo = new JSONObject(contentAsString);
//        System.out.println("contentAsString " + JSONObject.toScontentAsString);


//		JSONParser parser = new JSONParser();
//		String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";

//		try{
//			Object obj = parser.parse(s);
//			JSONArray array = (JSONArray)obj;


		String actual2 = "[{\"id\":1,\"company\":{\"id\":1,\"name\":\"alpenhof\"},\"creditCardEntity\":{\"id\":1,\"number\":\"xxx-xxx-xxxx-6345\",\"expDate\":\"22/22\",\"name\":\"JJ Binks\",\"type\":\"VISA\"},\"addressEntity\":{\"name\":\"Jar Jar Binks\",\"street\":\"Bluw Lane Hwy 12\",\"postcode\":\"41412\",\"telephone\":\"+(09)928423444\",\"email\":\"jj@gmail.com\"},\"orderItems\":[{\"id\":1,\"product\":{\"id\":14,\"name\":\"Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2},{\"id\":2,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":1}],\"date\":1613840754497,\"paymentType\":\"CARD\",\"deliveryType\":\"DELIVERY\",\"amount\":null,\"state\":\"OPEN\",\"payment\":\"CARD\",\"selectedProducts\":[{\"id\":1,\"product\":{\"id\":14,\"name\":\"Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2},{\"id\":2,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":1}]},{\"id\":2,\"company\":{\"id\":1,\"name\":\"alpenhof\"},\"creditCardEntity\":null,\"addressEntity\":{\"name\":\"Luke Skywalker\",\"street\":\"1 Baker st\",\"postcode\":\"62344\",\"telephone\":\"+(09)34534444\",\"email\":\"ls@gmail.com\"},\"orderItems\":[{\"id\":3,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":4,\"product\":{\"id\":14,\"name\":\"Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}],\"date\":1613840754524,\"paymentType\":\"CASH\",\"deliveryType\":\"DELIVERY\",\"amount\":null,\"state\":\"OPEN\",\"payment\":\"CASH\",\"selectedProducts\":[{\"id\":3,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":4,\"product\":{\"id\":14,\"name\":\"Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}]},{\"id\":3,\"company\":{\"id\":1,\"name\":\"alpenhof\"},\"creditCardEntity\":{\"id\":2,\"number\":\"xxx-xxx-xxxx-6523\",\"expDate\":\"12/24\",\"name\":\"P Leah\",\"type\":\"MASTERCARD\"},\"addressEntity\":{\"name\":\"Darth Vader\",\"street\":null,\"postcode\":null,\"telephone\":\"+(09)42344333\",\"email\":null},\"orderItems\":[{\"id\":5,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":6,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2},{\"id\":7,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}],\"date\":1613840754530,\"paymentType\":\"CARD\",\"deliveryType\":\"PICKUP\",\"amount\":null,\"state\":\"OPEN\",\"payment\":\"CARD\",\"selectedProducts\":[{\"id\":5,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":6,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2},{\"id\":7,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}]},{\"id\":4,\"company\":{\"id\":1,\"name\":\"alpenhof\"},\"creditCardEntity\":{\"id\":2,\"number\":\"xxx-xxx-xxxx-6523\",\"expDate\":\"12/24\",\"name\":\"P Leah\",\"type\":\"MASTERCARD\"},\"addressEntity\":{\"name\":\"Darth Vader\",\"street\":null,\"postcode\":null,\"telephone\":\"+(09)42344333\",\"email\":null},\"orderItems\":[{\"id\":8,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":9,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}],\"date\":1613840754539,\"paymentType\":\"CARD\",\"deliveryType\":\"PICKUP\",\"amount\":null,\"state\":\"CLOSED\",\"payment\":\"CARD\",\"selectedProducts\":[{\"id\":8,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":9,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}]}]";

		//TODO improve this test to look at exact JSON structure
		assertTrue(contentAsString.contains("Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree"));


//		JSONAssert.assertEquals(actual2, contentAsString, true);

//		JSONAssert.assertEquals("[{\"id\":1,\"company\":{\"id\":1,\"name\":\"alpenhof\"},\"creditCardEntity\":{\"id\":1,\"number\":\"xxx-xxx-xxxx-6345\",\"expDate\":\"22/22\",\"name\":\"JJ Binks\",\"type\":\"VISA\"},\"addressEntity\":{\"name\":\"Jar Jar Binks\",\"street\":\"Bluw Lane Hwy 12\",\"postcode\":\"41412\",\"telephone\":\"+(09)928423444\",\"email\":\"jj@gmail.com\"},\"orderItems\":[{\"id\":1,\"product\":{\"id\":14,\"name\":\"Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2},{\"id\":2,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":1}],\"date\":1613840754497,\"paymentType\":\"CARD\",\"deliveryType\":\"DELIVERY\",\"amount\":null,\"state\":\"OPEN\",\"payment\":\"CARD\",\"selectedProducts\":[{\"id\":1,\"product\":{\"id\":14,\"name\":\"Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2},{\"id\":2,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":1}]},{\"id\":2,\"company\":{\"id\":1,\"name\":\"alpenhof\"},\"creditCardEntity\":null,\"addressEntity\":{\"name\":\"Luke Skywalker\",\"street\":\"1 Baker st\",\"postcode\":\"62344\",\"telephone\":\"+(09)34534444\",\"email\":\"ls@gmail.com\"},\"orderItems\":[{\"id\":3,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":4,\"product\":{\"id\":14,\"name\":\"Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}],\"date\":1613840754524,\"paymentType\":\"CASH\",\"deliveryType\":\"DELIVERY\",\"amount\":null,\"state\":\"OPEN\",\"payment\":\"CASH\",\"selectedProducts\":[{\"id\":3,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":4,\"product\":{\"id\":14,\"name\":\"Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}]},{\"id\":3,\"company\":{\"id\":1,\"name\":\"alpenhof\"},\"creditCardEntity\":{\"id\":2,\"number\":\"xxx-xxx-xxxx-6523\",\"expDate\":\"12/24\",\"name\":\"P Leah\",\"type\":\"MASTERCARD\"},\"addressEntity\":{\"name\":\"Darth Vader\",\"street\":null,\"postcode\":null,\"telephone\":\"+(09)42344333\",\"email\":null},\"orderItems\":[{\"id\":5,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":6,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2},{\"id\":7,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}],\"date\":1613840754530,\"paymentType\":\"CARD\",\"deliveryType\":\"PICKUP\",\"amount\":null,\"state\":\"OPEN\",\"payment\":\"CARD\",\"selectedProducts\":[{\"id\":5,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":6,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2},{\"id\":7,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}]},{\"id\":4,\"company\":{\"id\":1,\"name\":\"alpenhof\"},\"creditCardEntity\":{\"id\":2,\"number\":\"xxx-xxx-xxxx-6523\",\"expDate\":\"12/24\",\"name\":\"P Leah\",\"type\":\"MASTERCARD\"},\"addressEntity\":{\"name\":\"Darth Vader\",\"street\":null,\"postcode\":null,\"telephone\":\"+(09)42344333\",\"email\":null},\"orderItems\":[{\"id\":8,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":9,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}],\"date\":1613840754539,\"paymentType\":\"CARD\",\"deliveryType\":\"PICKUP\",\"amount\":null,\"state\":\"CLOSED\",\"payment\":\"CARD\",\"selectedProducts\":[{\"id\":8,\"product\":{\"id\":13,\"name\":\"Minestone - italienische Gemüsesuppe mit Basilikumpesto\",\"price\":4.50,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":3},{\"id\":9,\"product\":{\"id\":15,\"name\":\"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln\",\"price\":7.90,\"type\":\"main\",\"imageFilename\":\"pizza.png\"},\"amount\":2}]}]",
//				contentAsString, true);


    }


}
