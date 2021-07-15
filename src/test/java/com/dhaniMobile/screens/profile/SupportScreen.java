package com.dhaniMobile.screens.profile;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SupportScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    @AndroidFindBy(id = "com.indiaBulls:id/category_label")
    public WebElement categories;

    @AndroidFindBy(id = "com.indiaBulls:id/faq_label")
    public WebElement faqsCardDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/toolbar_title")
    public WebElement contacUsCardDescription;

    public SupportScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public Boolean IsDisplayed() {
        try {
            testBase.waitForElementVisibility(categories, 5, "Support Categories page is not displayed");
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public String getFaqsCustomerCardDescription() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(faqsCardDescription, 7, "Card description is not visible");
        return faqsCardDescription.getText();
    }

    public String getContacUsCardDescription() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(contacUsCardDescription, 7, "Card description is not visible");
        return contacUsCardDescription.getText();
    }
}
