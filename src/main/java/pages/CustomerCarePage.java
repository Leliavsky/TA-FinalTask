package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomerCarePage extends BasePage{
    @FindBy(xpath = "//input[@placeholder='Search for help']")
    private WebElement helpInputLine;

    @FindBy(xpath = "//div[@class='CardListItem_homepageTopicItem']")
    private List<WebElement> listFAQTopics;

    public CustomerCarePage(WebDriver driver) {
        super(driver);
    }
    public boolean getHelpInputLine(){
        return helpInputLine.isDisplayed();
    }

    public int getSizeListFQATopics(){
        return listFAQTopics.size();
    }
}
