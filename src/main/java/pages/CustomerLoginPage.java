package pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {

    By customerLogin = By.xpath("//button[normalize-space()='Customer Login']");
    By searchCustomer = By.xpath("//select[@id='userSelect']");
    By loginButton = By.xpath("//button[normalize-space()='Login']");
    By logOutTab = By.cssSelector(".btn.logout");
    By VerifyText = By.xpath("//div[@class='form-group']/label");
    By depositTab = By.xpath("//button[normalize-space()='Deposit']");
    By enterAmount = By.xpath("//input[@placeholder='amount']");
    By depositButton = By.xpath("//button[@type='submit']");
    By withdrawalTab = By.xpath("//button[normalize-space()='Withdrawl']");
    By verifyDepositText = By.xpath("//span[@class='error ng-binding']");
    By withdrawalButton = By.xpath("//button[normalize-space()='Withdraw']");
    By withdrawalText = By.xpath("//span[@class='error ng-binding']");
    By verifyTransactionSuccessful= By.xpath("//span[contains(text(),'Transaction successful')]");

    public void customerLogin() {
        clickOnElement(customerLogin);
    }

    public void searchCustomerName() {
        // selectByVisibleTextFromDropDown(searchCustomer, "Khushi Pandey");
        selectByIndexFromDropDown(searchCustomer,2);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String logoutText() {
        return getTextFromElement(logOutTab);
    }

    public void clickOnLogoutTab() {
        clickOnElement(logOutTab);
    }

    public String verifyText(){
        return getTextFromElement(VerifyText);
    }

    public void clickOnDepositTab(){
        clickOnElement(depositTab);
    }

    public void enterAmount(String amount){
        sendTextToElement(enterAmount, amount);
    }

    public void clickOnDepositButton(){
        clickOnElement(depositButton);
    }

    public String verifyDepositText(){
        return getTextFromElement(verifyDepositText);
    }

    public void clickOnWithdrawalTab(){
        clickOnElement(withdrawalTab);
    }

    public void clickOnWithdrawalButton(){
        clickOnElement(withdrawalButton);
    }

    public String VerifyWithdrawalText(){
        return driver.findElement(withdrawalText).getText();
    }

     public String VerifyTransactionSuccessfulText(){
        return driver.findElement(verifyTransactionSuccessful).getText();
     }

}
