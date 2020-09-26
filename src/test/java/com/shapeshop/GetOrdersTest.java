//package com.shapeshop;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.result.StatusResultMatchers;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import com.shapeshop.util.JwtUtil;
//
//
//@EnableWebMvc
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class GetOrdersTest {
//
//	
//	StatusResultMatchers matcher = MockMvcResultMatchers.status();
//    @Autowired
//    private MockMvc mvc;
//    
//
//    @org.junit.Test
//    public void orders() throws Exception {
//    	
//    	mvc.perform(MockMvcRequestBuilders.get("/alpenhof/orders")).andExpect(matcher.isForbidden());
//    	
//    	
//    	String requestJson = "{\"username\": \"admin\",\"password\": \"foo\"}";
//    	
//    	ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType("application/json").content(requestJson)).andExpect(matcher.is(200));
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        System.out.println("contentAsString " + contentAsString);
//        
//        String token = contentAsString.substring(8, contentAsString.length()-2);
//        
//        System.out.println("token " + token);
//        
//        assertNotNull(token);
//
//    	resultActions = mvc.perform(MockMvcRequestBuilders.get("/alpenhof/orders").header("Authorization", "Bearer " + token)).andExpect(matcher.is(200));
//        
//        result = resultActions.andReturn();
//        contentAsString = result.getResponse().getContentAsString();
//
//        System.out.println("contentAsString " + contentAsString);
//    }
//    
//
//}