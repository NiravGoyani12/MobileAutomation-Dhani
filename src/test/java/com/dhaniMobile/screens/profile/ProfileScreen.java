package com.dhaniMobile.screens.profile;

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

public class ProfileScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public ProfileScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.indiaBulls:id/logout")
    public WebElement logoutBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/user_name")
    public WebElement welcomeUserText;

    @AndroidFindBy(id = "com.indiaBulls:id/tvRight")
    public WebElement yesButtonInConfirmationPopup;

    @AndroidFindBy(id = "com.indiaBulls:id/kycLevel")
    public WebElement cardDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/transaction_limit_card")
    public WebElement setTransactionLimitBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FAQs & Customer Care']")
    public WebElement faqsCustomerLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact Us']")
    public WebElement contactUsLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms & Conditions']")
    public WebElement tcLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    public WebElement privacyPolicyLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View Statement / Make Payments & Service Requests']")
    public WebElement viewStatementLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Saved Cards']")
    public WebElement mySavedCardsLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Money']")
    public WebElement addMoneyLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transaction Statement']")
    public WebElement transactionStatementLabel;

    @AndroidFindBy(id = "com.indiaBulls:id/photo_icon")
    public WebElement addPhotoIcon;

    public void clickLogout() {
        testBase.scrollIntoView("Log Out");
        testBase.getNativeView();
        testBase.waitForElementVisibility(logoutBtn, 5, "Logout button is not displayed");
        logoutBtn.click();
    }

    public Boolean IsDisplayed() {
        try {
            testBase.waitForElementVisibility(welcomeUserText, 5, "Profile page is not displayed");
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void ClickYesInConfirmationPopup() {
        testBase.waitForElementVisibility(yesButtonInConfirmationPopup, 5, "Yes button in Confirmation popup is not displayed");
        yesButtonInConfirmationPopup.click();
    }

    public String getCardDescription(String userType) {

        testBase.getNativeView();
        switch(userType.toLowerCase(Locale.ROOT)) {
            case "no kyc":
                testBase.waitForElementVisibility(cardDescription, 10, "text is not displayed");
                return cardDescription.getText();
            case "full kyc":
                testBase.waitForElementVisibility(cardDescription, 10, "text is not displayed");
                return cardDescription.getText();
            default:
                throw new IllegalStateException("Unexpected card name: " + userType.toLowerCase(Locale.ROOT));
        }
    }

    public void tapSetTransactionLimit() {
        setTransactionLimitBtn.click();
    }

    public void clickOnLabel(String label) {

        testBase.scrollIntoView(label);

        switch(label.toLowerCase(Locale.ROOT)) {
            case "faqs & customer care":
                faqsCustomerLabel.click();
                break;
            case "contact us":
                contactUsLabel.click();
                break;
            case "terms & conditions":
                tcLabel.click();
                break;
            case "privacy policy":
                privacyPolicyLabel.click();
                break;
            case "view statement / make payments & service requests":
                viewStatementLabel.click();
            break;
            case "my saved cards":
                testBase.sleep(1000);
                testBase.scrollIntoView("My Saved Cards");
                mySavedCardsLabel.click();
            break;
            case "add money":
                testBase.scrollIntoView("Add Money");
                addMoneyLabel.click();
            break;
            case "transaction statement":
                testBase.scrollIntoView("Transaction Statement");
                transactionStatementLabel.click();
            break;
            default:
                throw new IllegalStateException("Unexpected label: " + label.toLowerCase(Locale.ROOT));
        }
    }

    public void clickToAddPhoto() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(addPhotoIcon, 10, "add photo icon is not displayed");
        addPhotoIcon.click();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Set up your Free Cashback Card to continue']")
    public WebElement noKycCardDescription;

    public boolean isFCCScreenDisplayed() {
        return noKycCardDescription.isDisplayed();
    }

    @FindBy(xpath = "/html/body/app-root/app-statement/div/div[1]/div[2]/h3")
    public WebElement generalWalletStatementScreen;

    public boolean isGeneralWalletStatementScreenDisplayed() {
        testBase.sleep(20000);
        testBase.getWebView();
        return generalWalletStatementScreen.isDisplayed();
    }
}
