package com.shapeshop;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AuthenticationHTTPTests.class,
        CategoryTest.class,
        OrdersTest.class,
        ProductTest.class,
        UpdateProductTest.class,
})

public class TestSuite {
}  