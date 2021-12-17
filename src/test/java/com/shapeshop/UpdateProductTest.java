package com.shapeshop;


import com.shapeshop.config.ShapeShopTest;
import com.shapeshop.config.TestConfig;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.runner.RunWith;
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class UpdateProductTest extends ShapeShopTest {


    /**
     * update product with ID and change its name
     */
    @org.junit.Test
    public void updateProduct() throws Exception {

        String updateProductJSON =
                "{\"name\": \"XXXXXXXXX\"," +
                "\"price\": \"4.5\", " +
                "\"id\": \"2\"}";

        String token = authenticate("admin", "admin");

        mvc.perform(MockMvcRequestBuilders.put("/alpenhof/products/2")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(updateProductJSON)).andExpect(matcher.is(200));

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/alpenhof/products/2").contentType("application/json")
                .content(updateProductJSON)).andExpect(matcher.is(200));
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Assert.assertThat(contentAsString, CoreMatchers.containsString("XXXXXXXXX"));
    }



    private String loginAsAdmingAndGetToken() throws Exception {
        String requestJson = "{\"username\": \"admin\",\"password\": \"admin\"}";

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/authenticate")
                .contentType("application/json").content(requestJson)).andExpect(matcher.is(200));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        String token = contentAsString.substring(8, contentAsString.length()-2);

        assertNotNull(token);
        return token;
    }
}
