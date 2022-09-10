package com.shapeshop;

import com.shapeshop.config.ShapeShopTest;
import org.json.JSONArray;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class CategoryTest extends ShapeShopTest {

    @org.junit.Test
    public void getCategories() throws Exception {

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/carlscafe/categories")).andExpect(matcher.isOk());

        JSONArray recievedArray = extractJSONArrayFromResponse(resultActions);
        JSONArray expectedArray = extractJSONArrayFromFileName("src/test/resources/categoriesList_carl.json");

        System.out.println("recievedArray " + recievedArray);
        System.out.println("expectedArray " + expectedArray);

        //expect biskits and teas
        JSONAssert.assertEquals(
                expectedArray, recievedArray, JSONCompareMode.LENIENT);
    }

    @org.junit.Test
    public void createCategory() throws Exception {

        String token = authenticate("admin", "admin");

        String createCategoryJSON =
            "{\"name\": \"scones\" }";

        //create a cat
        createCategoryOverHTTP(token, createCategoryJSON);

        //get all cats
        ResultActions resultActions2 = getCategoriesOverHTTP();

        JSONArray recievedArray = extractJSONArrayFromResponse(resultActions2);
        JSONArray expectedArray = extractJSONArrayFromFileName("src/test/resources/categoriesList_carl_after_create.json");

        //expect biskits and teas, amd scones
        JSONAssert.assertEquals(
                expectedArray, recievedArray, JSONCompareMode.LENIENT);
    }


    @org.junit.Test
    public void deleteCategory() throws Exception {

        String token = authenticate("admin", "admin");

        String createCategoryJSON =
                "{\"name\": \"scones\" }";

        //create a cat
        createCategoryOverHTTP(token, createCategoryJSON);

        String createProductJSON =
                "{\"name\": \"jam scone\" }";

        //create a prod
        createProductOverHTTP(token, createProductJSON, "scones");


        //get prods
        //TODO jam scone should be there


        //delete cat
        //TODO

        //get prods from cat
        //TODO should throw e


        //get all prods
        //TODO jam scone should not exist.





//        //create a cat
//        createProductOverHTTP(token, createCategoryJSON);

        //get all cats
        ResultActions resultActions2 = getCategoriesOverHTTP();

        JSONArray recievedArray = extractJSONArrayFromResponse(resultActions2);
        JSONArray expectedArray = extractJSONArrayFromFileName("src/test/resources/categoriesList_carl_after_create.json");

        System.out.println("recievedArray " + recievedArray);
        System.out.println("expectedArray " + expectedArray);

        //expect biskits and teas, amd scones
        JSONAssert.assertEquals(
                expectedArray, recievedArray, JSONCompareMode.LENIENT);

        String createProductJSON =
                "{\"name\": \"scones\" }";




    }
}
