package com.dhaniMobile.screens.services;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class LifeInsuranceServiceScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public LifeInsuranceServiceScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Set up your Free Cashback Card to continue']")
    public WebElement noKycLifeInsuranceTileDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/edtTxtOperator")
    public WebElement fullKycLifeInsuranceTileDescription;

    public String getLifeInsuranceCardDescription(String userType) {

        testBase.getNativeView();

        switch (userType.toLowerCase(Locale.ROOT)) {
            case "no kyc":
                testBase.waitForElementVisibility(noKycLifeInsuranceTileDescription, 7, "text is not displayed");
                return noKycLifeInsuranceTileDescription.getText();
            case "full kyc":
                testBase.waitForElementVisibility(fullKycLifeInsuranceTileDescription, 10, "text is not displayed");
                return fullKycLifeInsuranceTileDescription.getText();
            default:
                throw new IllegalStateException("Unexpected card name: " + userType.toLowerCase(Locale.ROOT));
        }
    }
}
