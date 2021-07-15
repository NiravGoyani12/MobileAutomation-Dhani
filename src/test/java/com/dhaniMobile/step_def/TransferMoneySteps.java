package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.TransferMoneyScreen;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TransferMoneySteps extends TestBase {

    TransferMoneyScreen transferMoney = new TransferMoneyScreen(driver);

    @And("I click on Transfer to Bank")
    public void iClickOnTransferToBank() {
        transferMoney.clickOnTransferToBank();
    }

    @And("I click on Add a Bank Account")
    public void iClickOnAddABankAccount() {
        sleep(3000);
        transferMoney.clickOnAddABankAccount();
    }

    @And("I press Add account button")
    public void iPressAddAccountButton() {
        transferMoney.clickOnAddaAccountButton();
    }

    @And("I select  Account to transfer money")
    public void iSelectAccountToTransferMoney() {
        transferMoney.selectAccountToTransferMoney();
    }

    @And("I press continue button")
    public void iPressContinueButton() {
        transferMoney.clickOnContinueButton();
    }

    @And("I click Transfer button")
    public void iClickTransferButton() {
        transferMoney.clickOnTransferButton();
    }

    @And("I click on Send Money section")
    public void iClickOnSendMoneySection() {
        transferMoney.clickOnSendMoneySection();
    }

    @And("^I enter \"([^\"]*)\" mobile number of (?:.*)$")
    public void iEnterMobileNumberOfRecipientOrRequester(String mobileNumber) {
        transferMoney.enterMobileNumber(mobileNumber);
    }

    @And("^I enter \"([^\"]*)\" amount that needs to be transferred (?:.*)$")
    public void iEnterAmountThatNeedsToBeTransferredTo(String amount) {
        transferMoney.enterAmountThatNeedsToBeTransferred(amount);
    }

    @And("I enter thank you message as {string}")
    public void iEnterThankYouMessageAs(String message) {
        transferMoney.enterThankyouMessage(message);
    }

    @And("I press Send Money Button")
    public void iPressSendMoneyButton() {
        transferMoney.pressSendMoneyButton();
    }

    @And("I click on request money")
    public void iClickOnRequestMoney() {
        transferMoney.clickOnRequestMoney();
    }

    @And("I enter requesting  message as {string}")
    public void iEnterRequestingMessageAs(String message) {
        transferMoney.enterRequestingMessage(message);
    }

    @And("I press Request Money Button")
    public void iPressRequestMoneyButton() {
        transferMoney.pressRequestMoneyButton();
    }

    @Then("the Success title for {string} with {string} should be displayed")
    public void theSuccessTitleForWithShouldBeDisplayed(String transaction, String expText) {

        String actTextInCardSection = "";

        switch(transaction.toLowerCase()) {

            case "add bank":
                actTextInCardSection = transferMoney.getSuccessMsgAddBankAccount();
                break;
            case "transfer money to bank":
                actTextInCardSection = transferMoney.getSuccessMsgTransferToBank();
                break;
            case "send money":
                actTextInCardSection = transferMoney.getSuccessMsgSendMoney();
                break;
            case "request money":
                actTextInCardSection = transferMoney.getSuccessMsgRequestMoney();
                break;
            default:
                throw new IllegalStateException("Unexpected transaction: " + transaction.toLowerCase());
        }

        assertThat(actTextInCardSection, containsString(expText));
    }

    @And("I enter following details to create  saving Account")
    public void iEnterDetailsToCreateSavingAccount(DataTable dataTable) {
        List<Map<String, String>> data =  dataTable.asMaps();
        transferMoney.insertDetailsToCreateSavingAccount(
                data.get(0).get("Name") ,
                data.get(0).get("Number") + (long) (Math.random()*Math.pow(10,10)),
                data.get(0).get("Code"));
    }

    @Then("I remove Added Bank Account")
    public void iRemoveAddedBankAccount() {
        transferMoney.removeBankAccount();
    }
}
