package com.dhaniMobile.screens;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class ServicesScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public ServicesScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.indiaBulls:id/services_label")
    public WebElement noKycCardDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/home_available_now_label")
    public WebElement fullKycCardDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile']")
    public WebElement mobileTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='DTH']")
    public WebElement dthTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Datacard']")
    public WebElement datacardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Electricity']")
    public WebElement electricityTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gas']")
    public WebElement gasTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Landline']")
    public WebElement landlineTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Broadband']")
    public WebElement broadbandTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Water']")
    public WebElement waterTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LPG']")
    public WebElement lpgTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cable TV']")
    public WebElement cableTvTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Life Insurance']")
    public WebElement lifeInsuranceTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FASTag']")
    public WebElement fastagTile;

    public String getCardDescription(String userType) {

        testBase.getNativeView();
        switch (userType.toLowerCase(Locale.ROOT)) {
            case "no kyc":
                testBase.waitForElementVisibility(noKycCardDescription, 7, "text is not displayed");
                return noKycCardDescription.getText();
            case "full kyc":
                testBase.waitForElementVisibility(fullKycCardDescription, 10, "text is not displayed");
                return fullKycCardDescription.getText();
            default:
                throw new IllegalStateException("Unexpected card name: " + userType.toLowerCase(Locale.ROOT));
        }
    }

    public void clickOnService(String service) {

        testBase.scrollIntoView(service);

        switch (service.toLowerCase(Locale.ROOT)) {
            case "mobile":
                mobileTile.click();
                break;
            case "dth":
                dthTile.click();
                break;
            case "datacard":
                datacardTile.click();
                break;
            case "electricity":
                electricityTile.click();
                break;
            case "gas":
                gasTile.click();
                break;
            case "landline":
                landlineTile.click();
                break;
            case "broadband":
                broadbandTile.click();
                break;
            case "water":
                waterTile.click();
                break;
            case "lpg":
                lpgTile.click();
                break;
            case "cable tv":
                cableTvTile.click();
                break;
            case "life insurance":
                lifeInsuranceTile.click();
                break;
            case "fastag":
                fastagTile.click();
                break;
            default:
                throw new IllegalStateException("Unexpected card name: " + service.toLowerCase(Locale.ROOT));
        }

    }
}
