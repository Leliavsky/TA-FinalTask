package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//div[@class='ERlP6Bx']")
    private WebElement itemAfterSearch;

    @FindBy(xpath = "//div[@class='ERlP6Bx']")
    private List<WebElement> listAssembledElements;

    @FindBy(xpath = "//*[@ data-test-id='add-button']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//span[@id='selectSizeError']")
    private WebElement popupWindowWithSize;

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement sizePopupWindow;

    @FindBy(xpath = "//select[@data-id='sizeSelect']//option")
    private List<WebElement> listOfSize;

    @FindBy(xpath = "//p[@class='grid-text__copy ']")
    private WebElement txtAfterWrongSearching;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickItemAfterSearch(){
        itemAfterSearch.click();
    }
    public void clickAddToBagButton(){
        addToBagButton.click();
    }
    public void isPopupWindowWithSize() {
        popupWindowWithSize.isDisplayed();
    }
    public boolean getTxtAfterWrongSearching() {return txtAfterWrongSearching.isDisplayed();}

    public void clickOnSizeWindow(){
        sizePopupWindow.click();
    }

    public void clickToTakeSize(){
        listOfSize.get(5).click();
    }

    public int countListElements(){
        return listAssembledElements.size();
    }
}
