package base;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage extends PageObject {
    public List<WebElementFacade> getListElement(String locator){
        try{
            return  findAll(getBy(locator));
        }catch(Exception e){
            e.getMessage();
        }
        return null;
    }
    public WebElementFacade getElement(String locator){
        try{
            return  find(getBy(locator));
        }catch(Exception e){
            e.getMessage();
        }
        return null;
    }
    private By getBy(String locator){
        By by = null;
        try{
            if(locator.startsWith("id=")){
                locator = locator.substring(3);
                by = By.id(locator);
            }
            else  if(locator.startsWith("xpath=")){
                locator = locator.substring(6);
                by = By.xpath(locator);
            }
            else if(locator.startsWith("css=")){
                locator = locator.substring(4);
                by = By.cssSelector(locator);
            }
            else if(locator.startsWith("name=")){
                locator = locator.substring(5);
                by = By.cssSelector(locator);
            }
            else if(locator.startsWith("link=")){
                locator = locator.substring(5);
                by = By.cssSelector(locator);
            }
            return by;
        }
        catch (Throwable t){
            t.getMessage();
        }
        return null;
    }
    public void click(String locator){
        waitFor(getElement(locator)).click();
    }
    public void type(String locator,String value){
        waitFor(getElement(locator)).sendKeys(value);
    }
    public String getText(String locator){
        return waitFor(getElement(locator)).getText();
    }
    public void moveMouseTo(String locator){
        WebElement moveTo = waitFor(getElement(locator));
        withAction().moveToElement(moveTo).perform();
    }

    String headingText = "xpath=//h2[@class='o-fzpilz o-dAvrcB']";
    public String getPageCarHeading(){
        return getText(headingText);
    }
}
