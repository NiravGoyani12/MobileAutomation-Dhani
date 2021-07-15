package com.dhaniMobile.screens;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceScreen extends ScreenBase {
    public InsuranceScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    TestBase testBase = new TestBase();

    @FindBy(css = ".InsurancePage-bannerBtn")
    public WebElement getInsuredNowBtn;

    @FindBy(css = ".u-dfCenterCenter .dhani-Btn")
    public WebElement availNowBtn;

    @FindBy(xpath = "/html/body/app-root/app-personal-info/div[2]/div[2]/div[1]/div[1]")
    public WebElement sumInsuredSummary;

    public void tapGetInsuredNow() {
        testBase.sleep(1000);
        testBase.getWebView();
        testBase.scrollIntoViewSelenium(getInsuredNowBtn);
        getInsuredNowBtn.click();
    }

    public void tapAvailNow() {
        testBase.sleep(5000);
        testBase.getWebView();
        driver.switchTo().window((String)driver.getWindowHandles().toArray()[2]);
        availNowBtn.click();
    }

    public boolean isSumInsuredDisplayed() {
        testBase.sleep(5000);
        testBase.getWebView();
        driver.switchTo().window((String)driver.getWindowHandles().toArray()[2]);
        return sumInsuredSummary.isDisplayed() && sumInsuredSummary.getText().contains("Sum Insured");
    }
}
