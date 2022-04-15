package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.HomePage;
import pages.NewCarsPage;

public class CarWaleSteps {
    @Steps
    HomePage homePage;
    NewCarsPage newCarsPage;
    @Step
    public  void navigate(){
        homePage.open();
    }
    @Step
    public void findNewCars(String carBrand) throws InterruptedException {
        homePage.findNewCar();
          //      .chooseCarBrand(carBrand);
        newCarsPage.chooseCarBrand(carBrand);
       // Assert.assertTrue(homePage.getPageCarHeading().contains("Kia Car Models"));
    }
}
