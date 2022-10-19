package com.shapeshop.config;

import com.shapeshop.config.mockdata.AnniesArtSupplies;
import com.shapeshop.config.mockdata.Carlscafe;
import com.shapeshop.entity.AddressEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.CreditCardEntity;
import com.shapeshop.entity.UserEntity;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.*;
import com.shapeshop.security.PasswordUtils;
import com.shapeshop.service.ProductService;
import lombok.val;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;

import static org.junit.Assert.assertNotNull;


@Import(TestConfig.class)
@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class ShapeShopTest {

    @Autowired
    OrderRepository oRep;

    @Autowired
    private PasswordUtils passwordValidationService;

    @Autowired
    ProductRepository pRep;

    @Autowired
    ProductCategoryRepository pCatRep;

    @Autowired
    OrderItemRepository oiRep;

    @Autowired
    CompanyRepository cRep;

    @Autowired
    CategoryRepository catRep;

    @Autowired
    CreditCardRepository ccRep;

    @Autowired
    AddressRepository aRep;

    @Autowired
    ProductService pSer;

    @Autowired
    UserRepository uRep;

    @Autowired
    protected MockMvc mvc;

    protected StatusResultMatchers matcher = MockMvcResultMatchers.status();

    @Before
    public void before() throws Exception{


        clearDatabase();

        System.out.println("*************************");
        System.out.println("");
        System.out.println("");
        System.out.println("is this before each test?? or each class??");
        System.out.println("");
        System.out.println("");
        System.out.println("*************************");
        System.out.println("-->>> create some companies ! ");

        cRep.save(new CompanyEntity("carlscafe"));
        cRep.save(new CompanyEntity("anniesart"));

        AddressEntity a = new AddressEntity("Bob", "Bobby street 12", "41412", "+(09)928423444", "bob@gmail.com");
        aRep.save(a);
        AddressEntity a2 = new AddressEntity("Jane", "1 Baker st", "62344", "+(09)34534444", "jane@gmail.com");
        aRep.save(a2);

        CreditCardEntity cc = new CreditCardEntity("xxxx-xxxx-xxxx-1234", "22/22", "Bob", "VISA");
        ccRep.save(cc);
        CreditCardEntity cc2 = new CreditCardEntity("xxx-xxx-xxxx-6789", "12/24", "Jane", "MASTERCARD");
        ccRep.save(cc2);

        AnniesArtSupplies.createCategories(catRep, cRep);
        Carlscafe.createCategories(catRep, cRep);
        Carlscafe.createProducts(pRep, cRep, catRep, pSer);
        AnniesArtSupplies.createProducts(pRep, cRep, catRep, pSer);
        Carlscafe.createOrders(oRep, cRep, pRep, ccRep, aRep, oiRep);
        AnniesArtSupplies.createOrders(oRep, cRep, pRep, ccRep, aRep, oiRep);

        String fpasss = passwordValidationService.encryptPassword("foo");
        String apasss = passwordValidationService.encryptPassword("admin");
        String upasss = passwordValidationService.encryptPassword("user");

        System.out.println("-->>> create some users ! admin password = " + apasss);
        System.out.println("-->>> create some users ! user password = " + upasss);
        System.out.println("-->>> create some users ! foo password = " + fpasss);

//			TODO users should be bound to company
        uRep.save(new UserEntity(UserRole.ROLE_ADMIN, "admin", apasss));
        uRep.save(new UserEntity(UserRole.ROLE_USER, "user", upasss));
        uRep.save(new UserEntity(UserRole.ROLE_USER, "foo", fpasss));
    }


    @Autowired
    EntityManager entitymanager;

    /**
     * TODO reset database between all tests. Currently tests are not working if executed sequentially
     */
    @Transactional
    public void clearDatabase() throws SQLException {

        oiRep.deleteAll();
        uRep.deleteAll();
        oRep.deleteAll();
        pCatRep.deleteAll();
        catRep.deleteAll();
        pRep.deleteAll();
        ccRep.deleteAll();
        aRep.deleteAll();
        cRep.deleteAll();

        //TODO truncate is not working. Use truncate instead of deleteAll because
        // this resets the sequences
//        oiRep.truncate();
//        uRep.truncate();
//        oRep.truncate();
//        pCatRep.truncate();
//        catRep.truncate();

        System.out.println("****************************");
        System.out.println("");
        System.out.println("cleared database");
        System.out.println("");
        System.out.println("****************************");
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

    protected void deleteCategoryOverHTTP(String token, String createCategoryJSON) throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/" + defaultCompany + "/categories")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(createCategoryJSON)).andExpect(matcher.is(200));
    }



    protected String getCategoriesOverHTTP() throws Exception {
        ResultActions resultActions2 = mvc.perform(MockMvcRequestBuilders.get("/" + defaultCompany + "/categories").contentType("application/json")
        ).andExpect(matcher.is(200));

        JSONArray jsonArray = extractJSONArrayFromResponse(resultActions2);

        return jsonArray.toString();
    }

    protected String getProductsOverHTTP() throws Exception {
        ResultActions resultActions2 = mvc.perform(MockMvcRequestBuilders.get("/" + defaultCompany + "/products").contentType("application/json")
        ).andExpect(matcher.is(200));

        JSONArray jsonArray = extractJSONArrayFromResponse(resultActions2);

        return jsonArray.toString();
    }

    protected void createCategoryOverHTTP(String token, String createCategoryJSON) throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/" + defaultCompany + "/categories")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(createCategoryJSON)).andExpect(matcher.is(200));

        MvcResult mvcResult = resultActions.andReturn();
        resultActions.andExpect(matcher.is(200));
    }

    protected void createProductOverHTTP(String token, String createProductJSON, String cat) throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/" + defaultCompany + "/" + cat + "/products")
                .header("Authorization", "Bearer " + token).contentType("application/json")
                .content(createProductJSON));

        MvcResult mvcResult = resultActions.andReturn();
        resultActions.andExpect(matcher.is(200));
    }
}
