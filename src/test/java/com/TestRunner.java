package com;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.IOException;

@CucumberOptions(
        plugin = {"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = {"src/test/resources/features/"},
        glue = {"com.stepDefinitions"},
        tags = "@ignored"
)

public class TestRunner extends AbstractTestNGCucumberTests {

        @DataProvider(parallel = false)
        @Override
        public Object[][] scenarios() { return super.scenarios();}

        @AfterSuite
        public static void cleanup() throws IOException{
                System.out.println("Ran once the after all the tests");
        }
}

