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
    public void updateProductPrice() throws Exception {

        //update hotdog price from 7.9 to 5.5
        String updateProductJSON =
                "{ \"price\": \"5.5\" }";

        String token = authenticate("admin", "admin");

        // update product 2
        mvc.perform(MockMvcRequestBuilders.put("/carlscafe/products/2")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(updateProductJSON)).andExpect(matcher.is(200));

        // get product 2
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/products/2").contentType("application/json")
                .content(updateProductJSON)).andExpect(matcher.is(200));

        JSONObject obj = extractJSONObjectFromResponse(resultActions);
        JSONObject expectedObject = extractJSONObjectFromFileName("src/test/resources/updatedProduct.json");

        System.out.println("recievedArray " + obj);
        System.out.println("expectedArray " + expectedObject);

        //compare (ignore dangling entities)
        JSONAssert.assertEquals(expectedObject, obj, JSONCompareMode.LENIENT);
    }

    //TODO this test will fail if ALL tests are run. See super class for teardown TODO
    @Test
    public void createProduct() throws Exception {
        JSONObject createProductJSON = extractJSONObjectFromFileName("src/test/resources/createProduct.json");

        String token = authenticate("admin", "admin");

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/carlscafe/products")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(createProductJSON.toString())).andExpect(matcher.is(200));

//        MvcResult mvcResult = resultActions.andReturn();

        JSONObject ja = extractJSONObjectFromResponse(resultActions);

        System.out.println("ja " + ja);
//        System.out.println("expectedArray " + expectedObject);

//        JSONAssert.assertEquals(createProductJSON, ja, JSONCompareMode.LENIENT);
//        resultActions.andExpect(matcher.is(200));

    }

    @Test
    public void createProduct_catDoesntExist() throws Exception {
        JSONObject createProductJSON = extractJSONObjectFromFileName("src/test/resources/createProduct_catDoesntExist.json");

        String token = authenticate("admin", "admin");

        mvc.perform(MockMvcRequestBuilders.post("/carlscafe/products")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(createProductJSON.toString())).andExpect(matcher.is(500)); //category does not exist



    }


//    protected void createProductOverHTTP(String token, String createProductJSON, String cat) throws Exception {
//        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/" + defaultCompany + "/" + cat + "/products")
//                .header("Authorization", "Bearer " + token).contentType("application/json")
//                .content(createProductJSON));
//
//        MvcResult mvcResult = resultActions.andReturn();
//        resultActions.andExpect(matcher.is(200));
//    }

    @Test
    public void updateWrongProduct() throws Exception {

        //update product (2) that exists in carls cafe. But updating in annies art.
        String updateProductJSON =
                "{\"name\": \"big mac\" }";

        String token = authenticate("admin", "admin");

        // update
        mvc.perform(MockMvcRequestBuilders.put("/anniesart/products/2")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(updateProductJSON)).andExpect(matcher.is(404));
    }

}
