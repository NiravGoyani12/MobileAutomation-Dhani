package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.*;
import com.dhaniMobile.screens.profile.AboutUsScreen;
import com.dhaniMobile.screens.profile.ProfileScreen;
import com.dhaniMobile.screens.profile.SupportScreen;
import com.dhaniMobile.screens.profile.ViewStatementScreen;
import com.dhaniMobile.screens.services.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UtilsSteps extends TestBase {

    ShoppingScreen shoppingScreen = new ShoppingScreen(driver);
    MyCardScreen myCardScreen = new MyCardScreen(driver);
    ServicesScreen servicesScreen = new ServicesScreen(driver);
    ProfileScreen myProfileScreen = new ProfileScreen(driver);
    BroadbanServiceScreen broadbanServiceScreen = new BroadbanServiceScreen(driver);
    CableTvServiceScreen cableTvServiceScreen = new CableTvServiceScreen(driver);
    DatacardServiceScreen datacardServiceScreen = new DatacardServiceScreen(driver);
    DthServiceScreen dthServiceScreen = new DthServiceScreen(driver);
    ElectricityServiceScreen electricityServiceScreen = new ElectricityServiceScreen(driver);
    FasTagServiceScreen fasTagServiceScreen = new FasTagServiceScreen(driver);
    GasServiceScreen gasServiceScreen = new GasServiceScreen(driver);
    LandlineServiceScreen landlineServiceScreen = new LandlineServiceScreen(driver);
    LifeInsuranceServiceScreen lifeInsuranceServiceScreen = new LifeInsuranceServiceScreen(driver);
    LpgServiceScreen lpgServiceScreen = new LpgServiceScreen(driver);
    MobileServiceScreen mobileServiceScreen = new MobileServiceScreen(driver);
    WaterServiceScreen waterServiceScreen = new WaterServiceScreen(driver);
    SupportScreen supportScreen = new SupportScreen(driver);
    AboutUsScreen aboutUsScreen = new AboutUsScreen(driver);
    ViewStatementScreen viewStatementScreen = new ViewStatementScreen(driver);

    @When("^I wait for \"([^\"]*)\" milliseconds")
    public void wait_for_milliseconds(int ms) {
        sleep(ms);
    }

    @Then("^the \"([^\"]*)\" text is displayed on \"([^\"]*)\" screen with \"([^\"]*)\"$")
    public void theTextIsDisplayedOnScreenWith(String expText, String footerBtn, String userType) {

        String actTextInCardSection = "";
        switch (footerBtn.toLowerCase()) {
            case "shopping":
                actTextInCardSection = shoppingScreen.getCardDescription(userType);
                break;
            case "my card":
                actTextInCardSection = myCardScreen.getCardDescription(userType);
                break;
            case "services":
                actTextInCardSection = servicesScreen.getCardDescription(userType);
                break;
            case "profile":
                actTextInCardSection = myProfileScreen.getCardDescription(userType);
                break;
            default:
                throw new IllegalStateException("Unexpected card name: " + footerBtn.toLowerCase());
        }
        assertThat(actTextInCardSection, containsString(expText));
    }

    @Then("^the \"([^\"]*)\" text is displayed on \"([^\"]*)\" service screen with \"([^\"]*)\"$")
    public void theTextIsDisplayedOnServiceScreenWith(String expText, String service, String userType) {
        String actTextInCardSection = "";

        switch (service.toLowerCase()) {
            case "mobile":
                actTextInCardSection = mobileServiceScreen.getMobileCardDescription(userType);
                break;
            case "dth":
                actTextInCardSection = dthServiceScreen.getDthCardDescription(userType);
                break;
            case "datacard":
                actTextInCardSection = datacardServiceScreen.getDatacardCardDescription(userType);
                break;
            case "electricity":
                actTextInCardSection = electricityServiceScreen.getElectricityCardDescription(userType);
                break;
            case "gas":
                actTextInCardSection = gasServiceScreen.getGasCardDescription(userType);
                break;
            case "landline":
                actTextInCardSection = landlineServiceScreen.getLandlineCardDescription(userType);
                break;
            case "broadband":
                actTextInCardSection = broadbanServiceScreen.getBroadbandCardDescription(userType);
                break;
            case "water":
                actTextInCardSection = waterServiceScreen.getWaterCardDescription(userType);
                break;
            case "lpg":
                actTextInCardSection = lpgServiceScreen.getLpgCardDescription(userType);
                break;
            case "cable tv":
                actTextInCardSection = cableTvServiceScreen.getCableTvCardDescription(userType);
                break;
            case "life insurance":
                actTextInCardSection = lifeInsuranceServiceScreen.getLifeInsuranceCardDescription(userType);
                break;
            case "fastag":
                actTextInCardSection = fasTagServiceScreen.getFasTagCardDescription(userType);
                break;
            default:
                throw new IllegalStateException("Unexpected service name: " + service.toLowerCase());
        }
        assertThat(actTextInCardSection, containsString(expText));

    }

    @Then("the {string} text is displayed for {string} screen")
    public void theTextIsDisplayedForScreen(String expText, String label) {

        String actTextInCardSection = "";

        switch (label.toLowerCase()) {

            case "faqs & customer care":
                actTextInCardSection = supportScreen.getFaqsCustomerCardDescription();
                break;
            case "contact us":
                actTextInCardSection = supportScreen.getContacUsCardDescription();
                break;
            case "terms & conditions":
                actTextInCardSection = aboutUsScreen.getTCCardDescription();
                break;
            case "privacy policy":
                actTextInCardSection = aboutUsScreen.getPrivacyPolicyCardDescription();
                break;
            case "view statement / make payments & service requests":
                actTextInCardSection = viewStatementScreen.getViewStatementCardDescription();
                break;
            default:
                throw new IllegalStateException("Unexpected label: " + label.toLowerCase());
        }
        assertThat(actTextInCardSection, containsString(expText));
    }
}
