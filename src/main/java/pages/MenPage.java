package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenPage extends BasePage{

    @FindBy(xpath = "//span[@class='hero__cta js-buttonHover']")
    private WebElement clickShopSummer;


    @FindBy(xpath = ".//button[@type='button']//span[@class='_30BqGyh']")
    private WebElement clickOnSavedItems;

    public MenPage(WebDriver driver) {
        super(driver);
    }

    public void setClickShopSummer(){
        clickShopSummer.click();
    }

    public void setClickOnSavedItems(){
        clickOnSavedItems.click();
    }

}
