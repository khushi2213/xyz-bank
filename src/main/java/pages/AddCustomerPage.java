package pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class AddCustomerPage extends Utility {
    By addCustomerTab = By.xpath("//button[normalize-space()='Add Customer']");

    public void clickOnAddCustomerTab() {
        clickOnElement(addCustomerTab);
    }

}
