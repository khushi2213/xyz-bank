package testsuite;

import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BankManagerLoginPage;
import pages.CustomerLoginPage;
import pages.OpenAccountPage;

public class BankTest extends BaseTest {

    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    OpenAccountPage openAccountPage = new OpenAccountPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    AddCustomerPage addCustomerPage= new AddCustomerPage();

    @Test
    public void bankManagerShouldAddCustomerSuccessfully() {
        //click On "Bank Manager Login" Tab
        bankManagerLoginPage.clickOnBankManagerLogin();
        //click On "Add Customer" Tab
        addCustomerPage.clickOnAddCustomerTab();
        //enter FirstName
        bankManagerLoginPage.enterFirstName("Khushi");
        //enter LastName
        bankManagerLoginPage.enterLastName("Pandey");
        //enter PostCode
        bankManagerLoginPage.enterPostcode("HA2 9RE");
        //click On "Add Customer" Button
        bankManagerLoginPage.clickOnAddCustomerButton();
        //popup display
        //verify message "Customer added successfully"
        String actualMessage = bankManagerLoginPage.getTextFromAlert();
        Assert.assertEquals(actualMessage, "Customer added successfully with customer id :6", "Error message");
        acceptAlert();

    }


    @Test
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        //click On "Bank Manager Login" Tab
        bankManagerLoginPage.clickOnBankManagerLogin();
        //click On "Open Account" Tab
        openAccountPage.clickOnOpenAccountTab();
        //Search customer that created in first test
        Thread.sleep(2000);
        openAccountPage.searchCustomer();
        Thread.sleep(2000);
        //Select currency "Pound"
        openAccountPage.searchCurrency();
        //click on "process" button
        openAccountPage.clickOnProcessButton();
        //popup displayed
        //verify message "Account created successfully"
        String actualMessage = bankManagerLoginPage.getTextFromAlert();
        String expectedMessage = "Account created successfully with account Number :1016";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message");
        openAccountPage.acceptAlert();
    }

    @Test
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customerLoginPage.customerLogin();

        Thread.sleep(3000);
        //search customer that you created.
        customerLoginPage.searchCustomerName();

        //click on "Login" Button
        customerLoginPage.clickOnLoginButton();

        //verify "Logout" Tab displayed.
        Thread.sleep(2000);
        String actualText = customerLoginPage.logoutText();
        String expectedText = "Logout";
        Assert.assertEquals(actualText, expectedText, "Error message");
        Thread.sleep(1000);

        //click on "Logout"
        customerLoginPage.clickOnLogoutTab();

        //verify "Your Name" text displayed.
        String actualName = customerLoginPage.verifyText();
        String expectedName = "Your Name :";
        Assert.assertEquals(actualName, expectedName, "Error message");
    }

    @Test
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customerLoginPage.customerLogin();
        Thread.sleep(3000);

        //search customer that you created.
        customerLoginPage.searchCustomerName();

        //click on "Login" Button
        customerLoginPage.clickOnLoginButton();

        //click on "Deposit" Tab
        customerLoginPage.clickOnDepositTab();

        //Enter amount 100
        customerLoginPage.enterAmount("100");

        //click on "Deposit" Button
        customerLoginPage.clickOnDepositButton();

        //verify message "Deposit Successful"
        Assert.assertEquals(customerLoginPage.verifyDepositText(), "Deposit Successful", "Error message");

    }

   @Test
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customerLoginPage.customerLogin();
        Thread.sleep(3000);

        //search customer that you created.
        customerLoginPage.searchCustomerName();

        //click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        Thread.sleep(2000);

        //click on "Withdrawl" Tab
        customerLoginPage.clickOnWithdrawalTab();

        Thread.sleep(1000);
        // Enter amount 50
        customerLoginPage.enterAmount("50");
        Thread.sleep(1000);

        //click on "Deposit" Button
        customerLoginPage.clickOnWithdrawalButton();
        Thread.sleep(1000);

        //verify message "Transaction Successful"
      //  Assert.assertEquals(customerLoginPage.VerifyTransactionSuccessfulText(), "Transaction successful", "Error message");

    }

}
