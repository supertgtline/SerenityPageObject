package pages;

import base.BasePage;

public class NewCarsPage extends BasePage {
    public void chooseCarBrand(String brandName) throws InterruptedException {
        click("xpath="+brandName);
        Thread.sleep(3000);
    }
}
