package com.dhaniMobile.screens.webCards;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class DhaniDostCardScreen extends ScreenBase {
    TestBase testBase = new TestBase();
    public DhaniDostCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Set up your Free Cashback Card to continue']")
    public WebElement NoKycCardDescription;

    @FindBy(css = ".dhani-Title")
    public WebElement fullKyccardDescription;

    @FindBy(xpath = "//app-referral-program/div/button")
    public WebElement referNowBtn;

    @FindBy(xpath = "//app-referral-products/div[3]/button")
    public WebElement referNowFreeCashbackCardIcon;

    @FindBy(xpath = "//app-referral-products/div[7]/button")
    public WebElement referNowDhaniOneFreedomIcon;

    @FindBy(xpath = "//app-referral-products/div[11]/button")
    public WebElement referDhaniSuperSaverIcon;

    @FindBy(xpath = "//app-referral-products/div[15]/button")
    public WebElement referDhaniDoctorIcon;

    @FindBy(xpath = "//app-referral-products/div[19]/button")
    public WebElement referDhaniPharmacyIcon;

    @AndroidFindBy(id = "com.indiaBulls:id/tvMessage")
    public WebElement referralLinkText;

    public String getNoKycCardDescription(){
        testBase.getNativeView();
        testBase.waitForElementVisibility(NoKycCardDescription, 5, "Card description is not visible");
        return NoKycCardDescription.getText();
    }

    public String getFullKycCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(fullKyccardDescription, 15, "Card description is not visible");
        return fullKyccardDescription.getText();
    }

    public void clickOnReferNowIcon() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.scrollIntoViewSelenium(referNowBtn);
        testBase.waitForElementVisibility(referNowBtn, 20, "Refer now icon is not visible");
        referNowBtn.click();
    }

    public void clickOnReferNowForCard(String cardType) {
        testBase.getNativeView();
        testBase.getWebView();
        switch(cardType.toLowerCase(Locale.ROOT)) {

            case "free cashback card":
                testBase.scrollIntoViewSelenium(referNowFreeCashbackCardIcon);
                referNowFreeCashbackCardIcon.click();
                break;
            case "dhani one freedom":
                testBase.scrollIntoViewSelenium(referNowDhaniOneFreedomIcon);
                referNowDhaniOneFreedomIcon.click();
                break;
            case "dhani super saver":
                testBase.scrollIntoViewSelenium(referDhaniSuperSaverIcon);
                referDhaniSuperSaverIcon.click();
                break;
            case "dhani doctor":
                testBase.scrollIntoViewSelenium(referDhaniDoctorIcon);
                referDhaniDoctorIcon.click();
                break;
            case "dhani pharmacy":
                testBase.scrollIntoViewSelenium(referDhaniPharmacyIcon);
                referDhaniPharmacyIcon.click();
                break;
            default:
                throw new IllegalStateException("Unexpected refer now icon: " + cardType.toLowerCase(Locale.ROOT));
        }
    }

    public String getRefferalLinkText() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(referralLinkText, 10, "Referral link  is not visible");
        return referralLinkText.getText();
    }
}
