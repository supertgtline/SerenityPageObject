package pages;

import base.BasePage;

public class HomePage extends BasePage {
    String newCarMenu ="xpath=//div[contains(text(),'NEW CARS')]";
    String findNewCar="xpath=//div[contains(text(),'Find New Cars')]";
    String findUsedCars="";

    public NewCarsPage findNewCar(){
        moveMouseTo(newCarMenu);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(findNewCar);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // return this.switchToPage(NewCarsPage.class);
       // return this.switchToPage(NewCarsPage.class);
        return (new NewCarsPage());
     //   return this;
    }
    public  void findUsedCars(){

    }
    public void doLogin(){

    }

}
