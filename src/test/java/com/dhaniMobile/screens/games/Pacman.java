package com.dhaniMobile.screens.games;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pacman extends ScreenBase {

    TestBase testBase = new TestBase();

    public Pacman(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

   @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/img")
    private WebElement playBtn;

    @FindBy(xpath = "//*[@id=\"play\"]/img")
    private WebElement tapToStartScreen;

    public void tapPlayBtn() {
        testBase.sleep(3000);
        testBase.getNativeView();
        testBase.getWebView();
        testBase.scrollIntoViewSelenium(playBtn);
        playBtn.click();
    }

    public void tapToStart() {
        testBase.sleep(3000);
        testBase.getNativeView();
        testBase.getWebView();
        tapToStartScreen.click();
    }
}
