package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.nativeCards.MobileRechargeScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class MobileRechargeSteps extends TestBase {
    MobileRechargeScreen mobileRechargeScreen = new MobileRechargeScreen(driver);

//    @When("I Enter {string} Mobile number for recharge")
//    public void iEnterMobileNumberForRecharge(String mobileNum) {
//        mobileRechargeScreen.enterMobileForRecharge(mobileNum);
//    }
//
//    @And("I select an operator {string}")
//    public void iSelectAnOperator(String operator) {
//        mobileRechargeScreen.selectOperator(operator);
//    }
//
//    @And("I select the area {string}")
//    public void iSelectTheArea(String area) {
//        mobileRechargeScreen.selectArea(area);
//    }
//
//    @And("I enter mobile recharge amount {string}")
//    public void iEnterMobileRechargeAmount(String amount) {
//        mobileRechargeScreen.enterRechargeAmount(amount);
//    }
//
//    @And("I click on 'RECHARGE' button")
//    public void iClickOnRECHARGEButton() {
//        mobileRechargeScreen.clickOnRecharge();
//    }
//
//    @Then("the {string} page should be displayed")
//    public void thePageShouldBeDisplayed(String expText) {
//        assertThat(mobileRechargeScreen.getOrderSummaryText(), containsString(expText));
//    }
}
