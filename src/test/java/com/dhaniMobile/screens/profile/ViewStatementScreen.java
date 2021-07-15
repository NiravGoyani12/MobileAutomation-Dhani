package com.dhaniMobile.screens.profile;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ViewStatementScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public ViewStatementScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@text='Your Loan Summary']")
    public WebElement viewStatementCardDescription;


    public String getViewStatementCardDescription() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(viewStatementCardDescription, 7, "Card description is not visible");
        return viewStatementCardDescription.getText();
    }
}
