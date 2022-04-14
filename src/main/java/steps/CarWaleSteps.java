package steps;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class CarWaleSteps {
    HomePage homePage;
    @Step
    public  void navigate(){
        homePage.open();
    }
    @Step
    public void findNewCars(){
        homePage.findNewCar();
    }
}
