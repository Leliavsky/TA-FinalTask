package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement inputEmailAddress;

    @FindBy(xpath = "//input[@ value='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement popUpNotCorrectEmail;

    @FindBy(xpath = "//input[@class='qa-password-textbox']")
    private WebElement passwordInput;
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToEmailAddress(final String searchText) {
        inputEmailAddress.clear();
        inputEmailAddress.sendKeys(searchText);
    }

    public void setSignInButton(){
        signInButton.click();
    }

    public WebElement getPopUpNotCorrectEmail(){
        return popUpNotCorrectEmail;
    }
    public boolean isNotCorrectEmailPopupVisible() {
        return getPopUpNotCorrectEmail().isDisplayed();
    }

    public void enterTextToPasswordLine(final String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
}
