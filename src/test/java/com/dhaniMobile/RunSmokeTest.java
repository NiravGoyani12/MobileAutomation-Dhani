package com.dhaniMobile;

import com.dhaniMobile.base.TestBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        dryRun = false,
        tags = "@smoke and not @ignore and not @WIP",
        monochrome=true,
        plugin = {"pretty","summary",
                "html:target/cucumber-reports/report.html", "json:target/cucumber-reports/cucumber.json",
                })

public class RunSmokeTest {

    static TestBase testBase;

    @BeforeClass
    public static void initialize() throws Exception {
        testBase = new TestBase();
        testBase.startAppiumServer();
    }

    @AfterClass
    public static void quit(){
        testBase.closeAppiumServer();
    }
}
