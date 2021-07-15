package com.dhaniMobile.screens.webCards;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PharmacyCardScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public PharmacyCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "/html/body/app-root/div[1]/app-header/header/div/div[2]/div[1]/a")
    public WebElement cardNoKycDescription;

    // will change when new changes with full kyc implemented
    @FindBy(xpath = "/html/body/app-root/div[1]/app-header/header/div/div[2]/div[1]/a")
    public WebElement cardFullKycDescription;

    public String getNoKycCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(cardNoKycDescription, 15, "Card description is not visible");
        return cardNoKycDescription.getText();
    }

    public String getFullKycCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(cardFullKycDescription, 15, "Card description is not visible");
        return cardFullKycDescription.getText();
    }

}
