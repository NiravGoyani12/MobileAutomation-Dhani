package com.dhaniMobile.step_def.profile;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.profile.EditProfileScreen;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EditProfileSteps extends TestBase {

    EditProfileScreen editProfileScreen = new EditProfileScreen(driver);

    @And("I tab 'Add photo' icon on edit profile")
    public void iTabAddPhotoIconOnEditProfile() {
        editProfileScreen.clickAddPhotoEditProfile();

    }

    @Then("the {string} text is displayed on edit profile")
    public void theTextIsDisplayedOnEditProfile(String expText) {
        assertThat(editProfileScreen.getSetPhotoTextEditProfile(), containsString(expText));
    }
}
