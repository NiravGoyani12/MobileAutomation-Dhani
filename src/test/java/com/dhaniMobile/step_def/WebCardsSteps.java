package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.webCards.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WebCardsSteps extends TestBase {

    FreeCashbackCardScreen freeCashbackCardScreen = new FreeCashbackCardScreen(driver);
    FreedomCardScreen freedomCardScreen = new FreedomCardScreen(driver);
    StocksCardScreen stocksCardScreen= new StocksCardScreen(driver);
    PharmacyCardScreen pharmacyCardScreen=new PharmacyCardScreen(driver);
    VideoCallDoctorCardScreen videoCallDoctorCardScreen= new VideoCallDoctorCardScreen(driver);
    InsuranceCardScreen insuranceCardScreen = new InsuranceCardScreen(driver);
    CreditLineScreen creditLineScreen = new CreditLineScreen(driver);
    SuperSaverScreen superSaverScreen = new SuperSaverScreen(driver);
    Health365CardScreen health365CardScreen = new Health365CardScreen(driver);
    CovidCareCardScreen covidCareCardScreen = new CovidCareCardScreen(driver);
    FreeHealthCardScreen freeHealthCardScreen = new FreeHealthCardScreen(driver);
    DhaniZoneCardScreen dhaniZoneCardScreen = new DhaniZoneCardScreen(driver);
    DhaniDostCardScreen dhaniDostCardScreen = new DhaniDostCardScreen(driver);
    PrivatePatientCardScreen privatePatientCardScreen = new PrivatePatientCardScreen(driver);

    @Then("^the url should contain with \"([^\"]*)\"$")
    public void the_url_should_contain(String url) {
        assertThat(getCurrentUrl(), containsString(url));
    }

    @Then("^the \"([^\"]*)\" text should be visible in the No KYC \"([^\"]*)\" web card section$")
    public void text_is_visible_on_no_kyc_web_card_section(String expText, String cardName) {

        String actTextInCardSection = "";

        switch(cardName.toLowerCase()) {

            case "free cashback card":
                actTextInCardSection = freeCashbackCardScreen.getNoKycCardDescription();
                break;
            case "onefreedom credit":
                actTextInCardSection = freedomCardScreen.getCardDescription();
                break;
            case "stocks":
                actTextInCardSection = stocksCardScreen.getCardDescription();
                break;
            case "pharmacy":
                actTextInCardSection = pharmacyCardScreen.getNoKycCardDescription();
                break;
            case "video call a doctor":
                actTextInCardSection = videoCallDoctorCardScreen.getNoKycCardDescription();
                break;
            case "insurance":
                actTextInCardSection = insuranceCardScreen.getNoKycCardDescription();
                break;
            case "credit line":
                actTextInCardSection = creditLineScreen.getCardDescription();
                break;
            case "supersaver card":
                actTextInCardSection = superSaverScreen.getCardDescription();
                break;
            case "health 365":
                actTextInCardSection = health365CardScreen.getCardDescription();
                break;
            case "covid care health kit":
                actTextInCardSection = covidCareCardScreen.getCardDescription();
                break;
            case "free health card":
                actTextInCardSection = freeHealthCardScreen.getNoKycCardDescription();
                break;
            case "dhani zone":
                actTextInCardSection = dhaniZoneCardScreen.getCardDescription();
                break;
            case "dost":
                actTextInCardSection = dhaniDostCardScreen.getNoKycCardDescription();
                break;
            case "private patient":
                actTextInCardSection = privatePatientCardScreen.getNoKycCardDescription();
                break;
            default:
                throw new IllegalStateException("Unexpected card name: " + cardName.toLowerCase());
        }

        assertThat(actTextInCardSection, containsString(expText));
    }

    @Then("^the \"([^\"]*)\" text should be visible in the full KYC \"([^\"]*)\" web card section$")
    public void text_is_visible_on_full_kyc_web_card_section(String expText, String cardName) {

        String actTextInCardSection = "";

        switch(cardName.toLowerCase()) {

            case "free cashback card":
                actTextInCardSection = freeCashbackCardScreen.getFullKycCardDescription();
                break;
            case "onefreedom credit":
                actTextInCardSection = freedomCardScreen.getCardDescription();
                break;
            case "stocks":
                actTextInCardSection = stocksCardScreen.getCardDescription();
                break;
            case "pharmacy":
                actTextInCardSection = pharmacyCardScreen.getFullKycCardDescription();
                break;
            case "video call a doctor":
                actTextInCardSection = videoCallDoctorCardScreen.getFullKycCardDescription();
                break;
            case "insurance":
                actTextInCardSection = insuranceCardScreen.getFullKycCardDescription();
                break;
            case "credit line":
                actTextInCardSection = creditLineScreen.getCardDescription();
                break;
            case "supersaver card":
                actTextInCardSection = superSaverScreen.getCardDescription();
                break;
            case "health 365":
                actTextInCardSection = health365CardScreen.getCardDescription();
                break;
            case "covid care health kit":
                actTextInCardSection = covidCareCardScreen.getCardDescription();
                break;
            case "free health card":
                actTextInCardSection = freeHealthCardScreen.getFullKycCardDescription();
                break;
            case "dhani zone":
                actTextInCardSection = dhaniZoneCardScreen.getCardDescription();
                break;
            case "dost":
                actTextInCardSection = dhaniDostCardScreen.getFullKycCardDescription();
                break;
            case "private patient":
                actTextInCardSection = privatePatientCardScreen.getFullKycCardDescription();
                break;
            default:
                throw new IllegalStateException("Unexpected card name: " + cardName.toLowerCase());
        }

        assertThat(actTextInCardSection, containsString(expText));
    }


    @When("^I close 'Advertise' popup on health 365 card$")
    public void i_close_advertise_pop_up_on_health_365card() throws MalformedURLException {
        health365CardScreen.closeHealthCardAdvertisePopup();
        sleep(15000);
    }

    @When("^I enter the pin code \"([^\"]*)\"$")
    public void enter_pin_code(String pinCode) throws MalformedURLException {
        health365CardScreen.enterPinCodeOnHealthCard(pinCode);
        sleep(15000);
    }

    @Then("the Get It For Free button on the Free Health Card should be displayed")
    public void theGetItForFreeButtonOnTheFreeHealthCardShouldBeDisplayed() {
       assertThat(freeHealthCardScreen.isGetItForFreeButtonDisplayed(), is(true));
    }
}

