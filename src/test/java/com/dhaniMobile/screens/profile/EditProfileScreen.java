package com.dhaniMobile.screens.profile;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EditProfileScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public EditProfileScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.indiaBulls:id/profile_picture_iv")
    public WebElement addPhotoIconOnEditProfile;

    @AndroidFindBy(id = "com.indiaBulls:id/title_txt_vw")
    public WebElement addPhotoCardDescription;

    public void clickAddPhotoEditProfile() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(addPhotoIconOnEditProfile, 10, "Card description is not visible");
        addPhotoIconOnEditProfile.click();
    }

    public String getSetPhotoTextEditProfile() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(addPhotoCardDescription, 10, "Card description is not visible");
        return addPhotoCardDescription.getText();
    }
}
