package com.dhaniMobile.screens.games;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Basketball extends ScreenBase {

    TestBase testBase = new TestBase();

    public Basketball(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
    public WebElement continueBtn;

    public void clickOnContinueBtn() {
        testBase.getNativeView();
        continueBtn.click();
    }
}
