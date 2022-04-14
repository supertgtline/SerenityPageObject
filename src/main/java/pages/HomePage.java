package pages;

import base.BasePage;

public class HomePage extends BasePage {
    String newCarMenu ="xpath=//div[contains(text(),'NEW CARS')]";
    String findNewCar="xpath=//div[contains(text(),'Find New Cars')]";
    String findUsedCars="";

    public  void findNewCar(){
        moveMouseTo(newCarMenu);
        click(findNewCar);
    }
    public  void findUsedCars(){

    }
    public void doLogin(){

    }

}
