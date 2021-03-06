package com.shapeshop;

import org.junit.Ignore;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for authentication, login, 403 errors etc.
 */
@Import(TestConfig.class)
@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationHTTPTests {

	StatusResultMatchers matcher = MockMvcResultMatchers.status();
    @Autowired
    private MockMvc mvc;


    @Ignore
    @org.junit.Test
    public void shouldNotauthenticate() throws Exception {

    	mvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(matcher.isForbidden());

    	mvc.perform(MockMvcRequestBuilders.get("/admin")).andExpect(matcher.isForbidden());

    	//public
    	mvc.perform(MockMvcRequestBuilders.get("/alpenhof/products")).andExpect(matcher.isOk());

    	String requestJson = "{\"username\": \"IDoNotExistInTheDB\",\"password\": \"foo\"}";

        mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType("application/json").content(requestJson)).andExpect(matcher.isForbidden());
    }


    @org.junit.Test
    public void shouldAuthenticateUser() throws Exception {
    	String requestJson = "{\"username\": \"user\",\"password\": \"user\"}";

    	ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType("application/json").content(requestJson)).andExpect(matcher.is(200));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        System.out.println("contentAsString " + contentAsString);

        String token = contentAsString.substring(8, contentAsString.length()-2);

        System.out.println("token " + token);

        assertNotNull(token);

        /*
         * A logged in 'user' should be able to access /user
         */

    	resultActions = mvc.perform(MockMvcRequestBuilders.get("/user").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));

        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();

        System.out.println("contentAsString " + contentAsString);

        assertEquals("user", contentAsString);

        /*
         * A logged in 'user' should NOT be able to access /admin
         */
    	mvc.perform(MockMvcRequestBuilders.get("/admin").header("Authorization", "Bearer " + token)).andExpect(matcher.is(403));

    }


    @org.junit.Test
    public void shouldAuthenticateAdmin() throws Exception {




    	String requestJson = "{\"username\": \"admin\",\"password\": \"admin\"}";

    	ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType("application/json").content(requestJson)).andExpect(matcher.is(200));







        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        System.out.println("contentAsString " + contentAsString);

        String token = contentAsString.substring(8, contentAsString.length()-2);

        System.out.println("token " + token);

        assertNotNull(token);

        /**
         * A logged in 'admin' should be able to access /user
         */
    	resultActions = mvc.perform(MockMvcRequestBuilders.get("/user").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));

        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();

        System.out.println("contentAsString " + contentAsString);

        assertEquals("user", contentAsString);

        /**
         * A logged in 'admin' should be able to access /admin
         */
        mvc.perform(MockMvcRequestBuilders.get("/admin").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));
    }
}
