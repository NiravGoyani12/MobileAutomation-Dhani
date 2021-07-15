package com.dhaniMobile.screens.nativeCards;

import com.dhaniMobile.base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCardScreen extends ScreenBase {

    public ShoppingCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Shopping']")
    public WebElement noKycCardDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/browser_label")
    public WebElement fullKycCardDescription;

    public String getNoKycCardDescription(){
        return noKycCardDescription.getText();
    }

    public String getFullKycCardDescription(){
        return fullKycCardDescription.getText();
    }
}
