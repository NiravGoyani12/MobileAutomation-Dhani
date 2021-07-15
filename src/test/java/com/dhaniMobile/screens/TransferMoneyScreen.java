package com.dhaniMobile.screens;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TransferMoneyScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public TransferMoneyScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Set up your Free Cashback Card to continue']")
    public WebElement noKycCardDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transfer Money']")
    public WebElement fullKycCardDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/clTransferToBank")
    public WebElement transferToBank;

    @AndroidFindBy(id = "com.indiaBulls:id/btn_transfer")
    public WebElement transferButton;

    @AndroidFindBy(id = "com.indiaBulls:id/clSendMoney")
    public WebElement sendMoneyBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/clRequestMoney")
    public WebElement requestMoney;

    @AndroidFindBy(id = "com.indiaBulls:id/add_account")
    public WebElement addAnotherBankAccountBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/acc_name")
    public WebElement accountHolderNameTxtField;

    @AndroidFindBy(id = "com.indiaBulls:id/acc_number")
    public WebElement accountNumberTxtField;

    @AndroidFindBy(id = "com.indiaBulls:id/ifsc_code")
    public WebElement ifscCodeTxtField;

    @AndroidFindBy(id = "com.indiaBulls:id/add_account")
    public WebElement addAnotherBankAccount;

    @AndroidFindBy(id = "com.indiaBulls:id/edittext_enter_recipient_number")
    public WebElement mobileNumberTxtField;

    @AndroidFindBy(id = "com.indiaBulls:id/edittext_add_message")
    public WebElement messageForRecipientTxtField;

    @AndroidFindBy(id = "com.indiaBulls:id/btn_send_money")
    public WebElement sendMoneyButton;

    @AndroidFindBy(id = "com.indiaBulls:id/edittext_amount_to_send")
    public WebElement amountTxtField;

    @AndroidFindBy(id = "com.indiaBulls:id/edittext_add_message")
    public WebElement messageForRequesterTxtField;

    @AndroidFindBy(id = "com.indiaBulls:id/btn_send_money")
    public WebElement requestMoneyButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup")
    public WebElement selectAccountToTransferMoney;

    @AndroidFindBy(id = "com.indiaBulls:id/btn_transfer")
    public WebElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transaction successful']")
    public WebElement successMessageForMoneyTransferToBank;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Yay! Your request for cash was a success']")
    public WebElement successMessageForRequestMoney;

    @AndroidFindBy(id = "com.indiaBulls:id/textview_payment_sent_message")
    public WebElement successMessageForSendMoney;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Yay! Your Bank account has been added successfully']")
    public WebElement successMessageForAddingNewAccount;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView[3]")
    public WebElement deleteAccountBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/tvRight")
    public WebElement confirmDeleteBtn;


    public String getNoKycCardDescription() {
        return noKycCardDescription.getText();
    }

    public String getFullKycCardDescription() {
        return fullKycCardDescription.getText();
    }

    public void clickOnTransferToBank() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(transferToBank, 5, "transfer to bank button is not visible");
        transferToBank.click();
    }

    public void clickOnAddABankAccount() {
        addAnotherBankAccountBtn.click();
    }

    public void clickOnAddaAccountButton() {
        addAnotherBankAccount.click();
    }

    public void insertDetailsToCreateSavingAccount(String name, String number, String code) {
        accountHolderNameTxtField.sendKeys(name);
        accountNumberTxtField.sendKeys(number);
        ifscCodeTxtField.sendKeys(code);
        testBase.sleep(4000);
    }

    public void selectAccountToTransferMoney() {
        selectAccountToTransferMoney.click();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void clickOnTransferButton() {
        testBase.waitForElementVisibility(transferButton, 5, "Transfer Button is not visible");
        transferButton.click();
    }

    public void clickOnSendMoneySection() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(sendMoneyBtn, 5, "send money button is not visible");
        sendMoneyBtn.click();
    }

    public void enterAmountThatNeedsToBeTransferred(String amount) {
        amountTxtField.sendKeys(amount);
    }

    public void pressSendMoneyButton() {
        sendMoneyButton.click();
    }

    public void clickOnRequestMoney() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(requestMoney, 5, "send money button is not visible");
        requestMoney.click();
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberTxtField.sendKeys(mobileNumber);
    }

    public void pressRequestMoneyButton() {
        requestMoneyButton.click();
    }

    public void enterThankyouMessage(String message) {
        messageForRecipientTxtField.sendKeys(message);
    }

    public void enterRequestingMessage(String message) {
        messageForRequesterTxtField.sendKeys(message);
    }

    public String getSuccessMsgAddBankAccount() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(successMessageForAddingNewAccount, 10, "add bank acount success msg is not visible");
        return successMessageForAddingNewAccount.getText();
    }

    public String getSuccessMsgTransferToBank() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(successMessageForMoneyTransferToBank, 10, "transfer to bank success msg is not visible");
        return successMessageForMoneyTransferToBank.getText();
    }

    public String getSuccessMsgSendMoney() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(successMessageForSendMoney, 10, "send money success msg is not visible");
        return successMessageForSendMoney.getText();
    }

    public String getSuccessMsgRequestMoney() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(successMessageForRequestMoney, 10, "request money success msg is not visible");
        return successMessageForRequestMoney.getText();
    }

    public void removeBankAccount() {
        testBase.sleep(4000);
        testBase.getNativeView();
        testBase.waitForElementVisibility(deleteAccountBtn, 10, "delete account is not visible");
        deleteAccountBtn.click();
        testBase.sleep(2000);
        confirmDeleteBtn.click();
    }
}
