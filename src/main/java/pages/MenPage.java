package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenPage extends BasePage{

    @FindBy(xpath = ".//*[text()='SHOES & TRAINERS']")
    private WebElement clickShoesAndTrainers;


    @FindBy(xpath = ".//button[@type='button']//span[@class='_30BqGyh']")
    private WebElement clickOnSavedItems;

    public MenPage(WebDriver driver) {
        super(driver);
    }

    public void clickShoesAndTrainers(){
        clickShoesAndTrainers.click();
    }

    public void setClickOnSavedItems(){
        clickOnSavedItems.click();
    }

}
