package com.shapeshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
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

import com.shapeshop.util.JwtUtil;


@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestHTTPTest {

	
//	MockMvcResultMatchers m = MockMvcResultMatchers.status();
	
	
	StatusResultMatchers matcher = MockMvcResultMatchers.status();
    @Autowired
    private MockMvc mvc;
    
    
    @org.junit.Test
    public void shouldNotauthenticate() throws Exception {
    	String requestJson = "{\"username\": \"XXXX\",\"password\": \"foo\"}";
    	
        mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType("application/json").content(requestJson)).andExpect(matcher.isForbidden());
    }
    
    @org.junit.Test
    public void shouldAuthenticate() throws Exception {
    	String requestJson = "{\"username\": \"user\",\"password\": \"foo\"}";
    	
    	ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType("application/json").content(requestJson)).andExpect(matcher.is(200));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        // should get back this :
//        {"jwt":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwic2NvcGVzIjoiUk9MRV9VU0VSIiwiaWF0IjoxNTgxMjU0OTU3LCJleHAiOjE1ODEyNzI5NTd9.HGzOuI4SQGJ-MN2Kb09jwwZj7N-2CsoepisUX0wtTb8"}
        System.out.println("contentAsString " + contentAsString);
        
        String token = contentAsString.substring(8, contentAsString.length()-2);
        
        System.out.println("token " + token);
        
        assertNotNull(token);
        
        
    	ResultActions resultActions2 = mvc.perform(MockMvcRequestBuilders.get("/user").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));
        
        MvcResult result2 = resultActions2.andReturn();
        String contentAsString2 = result2.getResponse().getContentAsString();

        // should get back this :
//        {"jwt":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwic2NvcGVzIjoiUk9MRV9VU0VSIiwiaWF0IjoxNTgxMjU0OTU3LCJleHAiOjE1ODEyNzI5NTd9.HGzOuI4SQGJ-MN2Kb09jwwZj7N-2CsoepisUX0wtTb8"}
        System.out.println("contentAsString " + contentAsString2);
        
        assertEquals("user", contentAsString2);

        //cant access admin!!
    	mvc.perform(MockMvcRequestBuilders.get("/admin").header("Authorization", "Bearer " + token)).andExpect(matcher.is(403));

    }
    
    
    
    @org.junit.Test
    public void should_USERS() throws Exception {
    	
    	
        mvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(matcher.isForbidden());
    }

    @org.junit.Test
    public void should_ADMIN() throws Exception {
    	
    	
        mvc.perform(MockMvcRequestBuilders.get("/admin")).andExpect(matcher.isForbidden());
    }


    @org.junit.Test
    public void shouldNotAllowAcce_HELLO() throws Exception {
    	
    	
        mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(matcher.isOk());
    }

    



}