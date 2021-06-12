package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedListPage extends BasePage{
    @FindBy(xpath = ".//div[@class='itemCount_3vWat']")
    private WebElement itemSaved;

    public SavedListPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromItemSaved(){
        return itemSaved.getText();
    }
    public WebElement getItemSaved(){
        return itemSaved;
    }
}
