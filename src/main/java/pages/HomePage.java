package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@id=\"men-floor\"]")
    private WebElement menWebsite;

    @FindBy(xpath = "//a[@ icon='aECYnc0']")
    private WebElement savedListPage;

    @FindBy(xpath = "//*[@id=\"chrome-search\"]")
    private WebElement searchLine;

    @FindBy(xpath = "//*[@class='_25L--Pi']")
    private WebElement languageButton;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement dropOutWindow;

    @FindBy(xpath = "//option[@value='UA']")
    private WebElement optionalLanguageUa;

    @FindBy(xpath = "//button[@ data-testid='save-country-button']")
    private WebElement updatePreferenceButton;

    @FindBy(xpath = "//*[@ alt='Ukraine']")
    private WebElement checkUkraineImg;

    @FindBy(xpath = "//*[@ icontype='accountUnfilled']")
    private WebElement clickOnAccountButton;

    @FindBy(xpath = "//a[@class='_1336dMe _1uUU2Co _1336dMe _1uUU2Co'][text()='Sign In']")
    private WebElement clickOnSignIn;

    @FindBy(xpath = "//button[@class='kH5PAAC _1KRfEms']")
    private WebElement searchingButton;

    @FindBy(xpath = "//span[@data-test-id='miniBagItemCount']")
    private WebElement myBugDropDownWindow;

    @FindBy(xpath = "//span[@class='tiqiyps']")
    private WebElement loginLocator;

    @FindBy(xpath = "//a[@data-testid='help']")
        private WebElement fAQsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnMenWebsite(){
        menWebsite.click();
    }

    public void clickOnSavedList(){
        savedListPage.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchLine.clear();
        searchLine.sendKeys(searchText);
    }

    public void isSearchFieldVisible() {
        searchLine.isDisplayed();
    }

    public void clickOnLanguageButton(){
        languageButton.click();
    }

    public WebElement getOnDropOutWindow(){
        return dropOutWindow;
    }

    public void clickOnDropOutWindow(){
        dropOutWindow.click();
    }

    public void clickOptionalLanguageUa(){
        optionalLanguageUa.click();
    }

    public void clickUpdatePreferenceButton(){
        updatePreferenceButton.click();
    }

    public boolean isLanguageVisible() {
        return checkUkraineImg.isDisplayed();
    }

    public WebElement getOnAccountButton(){
        return clickOnAccountButton;
    }

    public void clickOnSignIn(){
        clickOnSignIn.click();
    }

    public void clickOnSearchingButton(){
        searchingButton.click();
    }

    public String getMyBugDropDownWindow(){
         return myBugDropDownWindow.getAttribute("innerHTML");
    }

    public boolean getCheckLogin(){
        return loginLocator.isDisplayed();
    }

    public void clickOnFAQsButton(){
        fAQsButton.click();
    }
}
