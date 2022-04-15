package base;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    String carBrandName = "xpath=//h3[@class='o-jjpuv o-cVMLxW']";
    String carPrice = "xpath=//span[@class='o-Hyyko o-cyHybq o-eZTujG o-eqqVmt']";
    public ArrayList<String> list = new ArrayList<String>();
    public void getCarNameAndPrice(){
        List<WebElementFacade> carNames = getListElement(carBrandName);
        List<WebElementFacade> carPrices = getListElement(carPrice);
        for(int i = 0; i< carNames.size();i++){
            System.out.println(carNames.get(i).getText()+" price í : "+carPrices.get(i).getText());
            String text = carNames.get(i).getText()+" price í : "+carPrices.get(i).getText();
            list.add(text);
        }
        for(String l:list){
            System.out.println(l);
        }

    }
    public void updateCarPriceInFile(String fileName) {

        String info = fileName + " car brand name and price\n";
        File file = new File(fileName);
        try {

            FileWriter fw = new FileWriter(file, true);

            // if you want to write the linesperator ("\n) as they are in the txt you should
            // use the following Code:

            fw.write(info);
            String lineSeparator = System.getProperty("line.separator");



            for (int i = 0; i < list.size(); i++) {
                fw.write(list.get(i));
                fw.write(lineSeparator);
            }

            fw.flush();
            fw.close();
            FileUtils.copyFile(file, new File(".//carprice//" + fileName + ".txt"));
            FileUtils.deleteQuietly(file);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
