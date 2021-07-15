package com.dhaniMobile.screens.nativeCards;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MobileRechargeScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public MobileRechargeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Set up your Free Cashback Card to continue']")
    public WebElement noKycCardDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Current Balance']")
    public WebElement fullKycCardDescription;

//    @AndroidFindBy(xpath = "")
//    public WebElement enterMobileField;

//    @AndroidFindBy(xpath = "")
//    public WebElement selectOperatorOption;

//    @AndroidFindBy(xpath = "")
//    public WebElement selectAreaOption;
//
//    @AndroidFindBy(xpath = "")
//    public WebElement amountField;
//
//    @AndroidFindBy(xpath = "")
//    public WebElement rechargeBtn;
//
//    @AndroidFindBy(xpath = "")
//    public WebElement orderSummaryTextLabel;

    public String getNoKycCardDescription(){
        return noKycCardDescription.getText();
    }

    public String getFullKycCardDescription(){
        return fullKycCardDescription.getText();
    }

//    public void enterMobileForRecharge(String mobileNum) {
//        testBase.getNativeView();
//        testBase.waitForElementVisibility(enterMobileField, 7,"mobile text field is not visible");
//        enterMobileField.sendKeys(mobileNum);
//    }

//    public void selectOperator(String operator) {
//        testBase.getNativeView();
//        testBase.waitForElementVisibility(selectOperatorOption, 7,"operator is not visible");
//    }

//    public void selectArea(String area) {
//        testBase.getNativeView();
//        testBase.waitForElementVisibility(selectAreaOption, 7,"area is not visible");
//    }
//
//    public void enterRechargeAmount(String amount) {
//        testBase.getNativeView();
//        testBase.waitForElementVisibility(amountField, 7,"amount field is not visible");
//    }
//
//    public void clickOnRecharge() {
//        testBase.getNativeView();
//        testBase.waitForElementVisibility(rechargeBtn, 7,"recharge button is not visible");
//        rechargeBtn.click();
//    }
//
//    public String getOrderSummaryText() {
//        testBase.getNativeView();
//        testBase.waitForElementVisibility(orderSummaryTextLabel, 7,"order summary text is not visible");
//        return orderSummaryTextLabel.getText();
//    }
}
