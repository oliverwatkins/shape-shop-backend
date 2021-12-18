package com.shapeshop.config;

import org.json.JSONArray;
import org.json.JSONObject;
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

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertNotNull;

@Import(TestConfig.class)
@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShapeShopTest {

    @Autowired
    protected MockMvc mvc;

    protected StatusResultMatchers matcher = MockMvcResultMatchers.status();
    
    @org.junit.Test
    public void test() throws Exception {
        System.out.println("need at least one test in file");
    }

    protected JSONArray extractJSONArrayFromResponse(ResultActions resultActions) throws UnsupportedEncodingException {
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        JSONArray recievedArray = new JSONArray(contentAsString);
        return recievedArray;
    }

    protected JSONObject extractJSONObjectFromResponse(ResultActions resultActions) throws UnsupportedEncodingException {
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        JSONObject recievedObj = new JSONObject(contentAsString);
        return recievedObj;
    }

    public String authenticate(String name, String password) throws Exception {
        String requestJson = "{\"username\":\"" + name + "\",\"password\": \"" + password + "\"}";

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/authenticate")
                .contentType("application/json").content(requestJson)).andExpect(matcher.isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        System.out.println("contentAsString " + contentAsString);

        String token = contentAsString.substring(8, contentAsString.length() - 2);

        assertNotNull(token);
        return token;
    }
}
