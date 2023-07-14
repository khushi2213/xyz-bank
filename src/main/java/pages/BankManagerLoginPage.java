package pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends Utility {


    By bankManagerLoginTab = By.xpath("//button[normalize-space()='Bank Manager Login']");
    By firstNameField = By.xpath("//input[@placeholder='First Name']");
    By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    By postcodeField = By.xpath("//input[@placeholder='Post Code']");
    By addCustomerButton = By.xpath("//button[@type='submit']");



    public void clickOnBankManagerLogin() {
        clickOnElement(bankManagerLoginTab);
    }

    public void enterFirstName(String Khushi) {
        sendTextToElement(firstNameField, Khushi);
    }

    public void enterLastName(String Pandey) {
        sendTextToElement(lastNameField, Pandey);
    }

    public void enterPostcode(String postcode) {
        sendTextToElement(postcodeField, postcode);
    }

    public void clickOnAddCustomerButton() {
        clickOnElement(addCustomerButton);
    }

    public void clickOnAlertMessage(){
        acceptAlert();
    }




}
