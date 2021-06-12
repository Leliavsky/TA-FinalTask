package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;
    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public AccountPage getAccountPage() {
        return new AccountPage(driver);
    }

    public MenPage getMenPage() {
        return new MenPage(driver);
    }
    public SavedListPage getSavedListPage() {
        return new SavedListPage(driver);
    }
    public SearchResultsPage getSearchResultPage() {
        return new SearchResultsPage(driver);
    }
    public CustomerCarePage getCustomerCarePage(){
        return new CustomerCarePage(driver);
    }
}
