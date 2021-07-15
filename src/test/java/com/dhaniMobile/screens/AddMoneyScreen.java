package com.dhaniMobile.screens;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddMoneyScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public AddMoneyScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.indiaBulls:id/btn_load_money")
    public WebElement addMoneyBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/txtViewAmt100")
    public WebElement add100Btn;

    @AndroidFindBy(id = "com.indiaBulls:id/et_amount")
    public WebElement amountInput;

    public boolean isDisplayed() {
        testBase.waitForElementVisibility(addMoneyBtn, 5, "Add Money screen is not displayed");
        return addMoneyBtn.isDisplayed();
    }

    public void tap100AmountBtn() {
        add100Btn.click();
    }

    public void tapAddMoneyBtn() {
        addMoneyBtn.click();
        testBase.sleep(7000);
    }
}
