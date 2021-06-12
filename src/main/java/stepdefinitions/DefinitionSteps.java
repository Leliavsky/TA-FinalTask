package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    private static final String EXPECTED_RESOLD = "1 item";
    WebDriver driver;
    HomePage homePage;
    MenPage menPage;
    SavedListPage savedListPage;
    PageFactoryManager pageFactoryManager;
    AccountPage accountPage;
    SearchResultsPage searchResultsPage;
    CustomerCarePage customerCarePage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User clicks to men clothes")
    public void userClicksToMenClothes() {
        homePage.clickOnMenWebsite();
    }

    @And("User clicks to Shoes & Trainers")
    public void userClicksToShoesTrainers() {
        menPage = pageFactoryManager.getMenPage();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        menPage.clickShoesAndTrainers();
    }

    @When("User add any product to Saved Items")
    public void userAddToSavedItems() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        menPage.setClickOnSavedItems();
    }

    @And("User go to Saved Items")
    public void userGoToSavedItems() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
        homePage.clickOnSavedList();
    }

    @Then("User check his Saved List")
    public void userCheckHisSavedList() {
        savedListPage = pageFactoryManager.getSavedListPage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedListPage.getItemSaved());
        assertEquals(savedListPage.getTextFromItemSaved(),EXPECTED_RESOLD);
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @Then("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User clicks on language button")
    public void userClicksOnLanguageButton() {
        homePage.clickOnLanguageButton();
    }

    @When("User clicks on drop-out window")
    public void userClicksOnDropOutWindow() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getOnDropOutWindow());
        homePage.clickOnDropOutWindow();
    }

    @And("User clicks on Ukraine language")
    public void userClicksOnUkraineLanguage() {
        homePage.clickOptionalLanguageUa();
    }

    @And("User click on update preference")
    public void userClickOnUpdatePreference() {
        homePage.clickUpdatePreferenceButton();
    }

    @Then("User check website update preference")
    public void userCheckWebsiteUpdatePreference() {
            assertTrue(homePage.isLanguageVisible());
    }

    @And("User clicks on Account button")
    public void userClicksOnAccountButton() {
        homePage.moveToElement(homePage.getOnAccountButton());
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        this.sleep(2);
        homePage.clickOnSignIn();
    }

    @When("User introduces incorrect email {string}")
    public void userIntroducesIncorrectEmailKeyword(final String keyword) {
        accountPage = pageFactoryManager.getAccountPage();
        accountPage.enterTextToEmailAddress(keyword);
    }

    @And("User clicks on Sigh In button")
    public void userClicksOnSighInButton() {
        accountPage.setSignInButton();
    }

    @Then("User checks that not correct email popup visible")
    public void userChecksThatNotCorrectEmailPopupVisible() {
        accountPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, accountPage.getPopUpNotCorrectEmail());
        assertTrue(accountPage.isNotCorrectEmailPopupVisible());
    }

    @And("User clicks on item")
    public void userClicksOnItem() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        homePage.implicitWait(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        searchResultsPage.clickItemAfterSearch();
    }

    @And("User click on button add to bag")
    public void userClickOnButtonAddToBag() {
        searchResultsPage.clickAddToBagButton();
    }

    @Then("User checks popup window with select size visible")
    public void userChecksPopupWindowWithSelectSizeVisible() {
        searchResultsPage.isPopupWindowWithSize();
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickOnSearchingButton();
    }

    @And("User click on size popup window")
    public void userClickOnSizePopupWindow() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickOnSizeWindow();
    }

    @And("User clicks to take a size")
    public void userClicksToTakeASize() {
        searchResultsPage.clickToTakeSize();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50)");
    }

    @Then("User check his bag")
    public void userCheckHisBag() {
        assertEquals(homePage.getMyBugDropDownWindow(), EXPECTED_RESOLD);
    }

    @Then("User check search line on extra words")
    public void userCheckSearchLineOnExtraWords() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.getTxtAfterWrongSearching());
    }

    @Then("User check number of search items")
    public void userCheckNumberOfSearchItems() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        assertEquals(searchResultsPage.countListElements(),72);
    }

    @When("User introduces correct email {string}")
    public void userIntroducesCorrectEmailKeyword(final String keyword) {
        accountPage = pageFactoryManager.getAccountPage();
        accountPage.enterTextToEmailAddress(keyword);
    }

    @And("User write password {string}")
    public void userWritePasswordPassword(final String password) {
        accountPage.enterTextToPasswordLine(password);
    }

    @Then("User check his logged in")
    public void userCheckHisLoggedIn() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.implicitWait(6000);
        homePage.moveToElement(homePage.getOnAccountButton());
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        this.sleep(2);
        assertTrue(homePage.getCheckLogin());
    }

    @And("User clicks on FQAs button")
    public void userClicksOnFQAsButton() {
        homePage.clickOnFAQsButton();
    }

    @When("User check search helping line")
    public void userCheckSearchHelpingLine() {
        customerCarePage = pageFactoryManager.getCustomerCarePage();
        customerCarePage.getHelpInputLine();
    }

    @Then("User check six topics FAQs")
    public void userCheckSixTopicsFAQs() {
        assertEquals(customerCarePage.getSizeListFQATopics(),6);
    }
}
