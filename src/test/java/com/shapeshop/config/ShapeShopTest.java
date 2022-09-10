package com.shapeshop.config;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;

import static org.junit.Assert.assertNotNull;


@Import(TestConfig.class)
@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class ShapeShopTest {


    @Autowired
    protected MockMvc mvc;

    protected StatusResultMatchers matcher = MockMvcResultMatchers.status();

    @Before
    public void before() throws Exception{
        System.out.println("is this before each??");
    }

    @After
    public void tearDown() throws SQLException {
        clearDatabase();
    }

    /**
     * TODO reset database between all tests. Currently tests are not working if executed sequentially
     */

    public void clearDatabase() throws SQLException {
//        Connection c = datasource.getConnection();
//        Statement s = c.createStatement();
//
//        // Disable FK
//        s.execute("SET REFERENTIAL_INTEGRITY FALSE");
//
//        // Find all tables and truncate them
//        Set<String> tables = new HashSet<String>();
//        ResultSet rs = s.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES  where TABLE_SCHEMA='PUBLIC'");
//        while (rs.next()) {
//            tables.add(rs.getString(1));
//        }
//        rs.close();
//        for (String table : tables) {
//            s.executeUpdate("TRUNCATE TABLE " + table);
//        }
//
//        // Idem for sequences
//        Set<String> sequences = new HashSet<String>();
//        rs = s.executeQuery("SELECT SEQUENCE_NAME FROM INFORMATION_SCHEMA.SEQUENCES WHERE SEQUENCE_SCHEMA='PUBLIC'");
//        while (rs.next()) {
//            sequences.add(rs.getString(1));
//        }
//        rs.close();
//        for (String seq : sequences) {
//            s.executeUpdate("ALTER SEQUENCE " + seq + " RESTART WITH 1");
//        }
//
//        // Enable FK
//        s.execute("SET REFERENTIAL_INTEGRITY TRUE");
//        s.close();
//        c.close();
    }

    /**
     * UTILITY METHODS :
     */

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

    protected JSONArray extractJSONArrayFromFileName(String filePath) throws FileNotFoundException {
        String newOrderJSON = getString(filePath);

        JSONArray obj = new JSONArray(newOrderJSON);
        return obj;
    }

    protected JSONObject extractJSONObjectFromFileName(String filePath) throws FileNotFoundException {
        String newOrderJSON = getString(filePath);

        JSONObject obj = new JSONObject(newOrderJSON);
        return obj;
    }

    private String getString(String filePath) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            sb.append(s);
        }
        in.close();
        String json = sb.toString();
        return json;
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


    String defaultCompany = "carlscafe";

    protected ResultActions getCategoriesOverHTTP() throws Exception {
        ResultActions resultActions2 = mvc.perform(MockMvcRequestBuilders.get("/{" + defaultCompany + "}/categories").contentType("application/json")
        ).andExpect(matcher.is(200));
        return resultActions2;
    }

    protected void createCategoryOverHTTP(String token, String createCategoryJSON) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/{" + defaultCompany + "}/categories")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(createCategoryJSON)).andExpect(matcher.is(200));
    }

    protected void createProductOverHTTP(String token, String createProductJSON, String cat) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/{" + defaultCompany + "}/{" + cat + "}/products")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(createProductJSON)).andExpect(matcher.is(200));
    }
}
