package com.dhaniMobile;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.utilities.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.junit.BeforeClass;

import java.io.*;

public class Hooks extends TestBase {

    @Before()
    public void startAppiumServer() {
        driver = CommonUtils.getAndroidDriver();
        applyImplicitWait();
    }

    @BeforeStep
    public void getDriverContext() {
        getView();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed() && driver != null) {
            scenario.attach(takeScreenshot(), "image/jpg", scenario.getName());
            saveLastPageContentToFile(scenario);
        }

        if (driver != null)
        {
            driver.quit();
        }

        log.info("Test execution completed");
    }


    private void saveLastPageContentToFile(Scenario scenario) {
        String pageSource = driver.getPageSource();
        String fileName = System.getProperty("user.dir")+"\\reports\\lastPage_" + scenario.getName() + ".html";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {
            writer.write(pageSource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
