package com.dhaniMobile.screens;

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

public class HomeScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // web cards
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Free Cashback Card']")
    public WebElement freeCashbackCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OneFreedom Credit']")
    public WebElement freedomCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stocks']")
    public WebElement stocksCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Insurance']")
    public WebElement insuranceCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Supersaver Card']")
    public WebElement superSaverCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Credit Line']")
    public WebElement creditLineCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Free Health Card']")
    public WebElement freeHealthCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pharmacy']")
    public WebElement pharmacyCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video Call a Doctor']")
    public WebElement videoCallDoctorCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dost']")
    public WebElement dhaniDostCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dhani Zone']")
    public WebElement dhaniZoneCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Covid Care Health Kit']")
    public WebElement covidCareCardTile;


    // native cards

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Play Free Games']")
    public WebElement playFreeGamesCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile Recharge']")
    public WebElement mobileRechargeCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Shopping']")
    public WebElement shoppingCardTile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transfer Money']")
    public WebElement transferMoneyCardTile;

    // health 365 web
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Health 365']")
    public WebElement health365CardTile;

    @AndroidFindBy(id = "com.indiaBulls:id/bottom_tab_home")
    public WebElement homeBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/bottom_tab_shopping")
    public WebElement shoppingBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/bottom_tab_my_card")
    public WebElement myCardBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/bottom_tab_services")
    public WebElement servicesBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/bottom_tab_profile")
    public WebElement profileBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/home_notification")
    public WebElement notificationBell;

    @AndroidFindBy(className = "android.widget.TextView")
    public WebElement appInbox;

    @AndroidFindBy(id = "com.indiaBulls:id/home_chat")
    public WebElement supportIcon;

    @AndroidFindBy(id = "com.indiaBulls:id/home_wallet_balance_btn")
    public WebElement addLabel;

    @AndroidFindBy(id = "com.indiaBulls:id/home_daily_credit_limit_btn")
    public WebElement inActiveLabel;

    @AndroidFindBy(id = "com.indiaBulls:id/credit_card_limit")
    public WebElement applyNowAvailableCreditLabel;

    public Boolean isHomeButtonDisplayed() {
        testBase.waitForElementVisibility(homeBtn, 5, "Home btn is not visible");
        return homeBtn.isDisplayed();
    }

    public void clickOnNotificationBell() {
        testBase.waitForElementVisibility(notificationBell, 5, "Notification bell is not displayed");
        notificationBell.click();
    }

    public Boolean isAppInboxDisplayed() {
        testBase.waitForElementVisibility(appInbox, 5, "App inbox is not displayed");
        return appInbox.isDisplayed();
    }

    public void clickOnSupportIcon() {
        testBase.waitForElementVisibility(supportIcon, 5, "Support icon is not displayed");
        supportIcon.click();
    }

    public void clickOnNativeCard(String cardName) {

        testBase.scrollIntoView(cardName);

        switch(cardName.toLowerCase(Locale.ROOT)) {
            case "play free games":
                playFreeGamesCardTile.click();
                break;
            case "mobile recharge":
                mobileRechargeCardTile.click();
                break;
            case "shopping":
                shoppingCardTile.click();
                break;
            case "transfer money":
                transferMoneyCardTile.click();
                break;
            default:
                throw new IllegalStateException("Unexpected card name: " + cardName.toLowerCase(Locale.ROOT));
        }
    }

    public void clickOnWebCard(String cardName){

        testBase.scrollIntoView(cardName);

        switch(cardName.toLowerCase(Locale.ROOT)) {

            case "free cashback card":
                freeCashbackCardTile.click();
                break;
            case "onefreedom credit":
                freedomCardTile.click();
                break;
            case "stocks":
                stocksCardTile.click();
                break;
            case "pharmacy":
                pharmacyCardTile.click();
                break;
            case "video call a doctor":
                videoCallDoctorCardTile.click();
                break;
            case "covid care health kit":
                covidCareCardTile.click();
                break;
            case "insurance":
                insuranceCardTile.click();
                break;
            case "credit line":
                creditLineCardTile.click();
                break;
            case "dost":
                dhaniDostCardTile.click();
                break;
            case "free health card":
                freeHealthCardTile.click();
                break;
            case "private patient":
                creditLineCardTile.click();
                break;
            case "dhani zone":
                dhaniZoneCardTile.click();
                break;
            case "health 365":
                health365CardTile.click();
                break;
            case "supersaver card":
                superSaverCardTile.click();
                break;
            default:
                throw new IllegalStateException("Unexpected card name: " + cardName.toLowerCase(Locale.ROOT));
        }
    }

    public void clickOnFooterBtn(String footerBtn) {

        switch(footerBtn.toLowerCase(Locale.ROOT)) {

            case "shopping":
                shoppingBtn.click();
                break;
            case "my card":
                myCardBtn.click();
                break;
            case "services":
                servicesBtn.click();
                break;
            case "profile":
                profileBtn.click();
                break;
            default:
                throw new IllegalStateException("Unexpected card name: " + footerBtn.toLowerCase(Locale.ROOT));
        }
    }

    public void clickOnLabel(String label) {

        switch(label.toLowerCase(Locale.ROOT)) {
            case "add":
                addLabel.click();
                break;
            case "inactive":
                inActiveLabel.click();
                break;
            case "available credit limit":
                applyNowAvailableCreditLabel.click();
                break;
            default:
                throw new IllegalStateException("Unexpected label: " + label.toLowerCase(Locale.ROOT));
        }
    }
}
