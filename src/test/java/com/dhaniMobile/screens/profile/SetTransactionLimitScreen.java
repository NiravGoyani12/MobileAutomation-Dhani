package com.dhaniMobile.screens.profile;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SetTransactionLimitScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public SetTransactionLimitScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.indiaBulls:id/tvTitle")
    public WebElement title;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement dailyLimit;

    @AndroidFindBy(id = "com.indiaBulls:id/btConfirmChange")
    public WebElement confirmChangesBtn;

    public Boolean isDisplayed() {
        try {
            testBase.waitForTextVisibility(By.id("com.indiaBulls:id/tvTitle"), "Set Transaction Limit", 5, "Set Transaction Limit page is not displayed");
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void enterMinAmountPerTransaction(int limit) {
        dailyLimit.clear();
        dailyLimit.sendKeys(String.valueOf(limit));
    }

    public void tanConfirmChange() {
        confirmChangesBtn.click();
    }
}
