package testcases;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.CarWaleSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(".\\src\\test\\resources\\testdata\\cardetails.csv")
public class CarPriceTest {

    public String getBrandName() {
        return brandName;
    }

    String brandName;
    //String brandName="Kia";
    //div[normalize-space()='Honda']
    @Managed
    WebDriver driver;
    @Steps
    CarWaleSteps car;
    @Title("Car Price Test")
    @Test
    public void findCarNameandPriceTest() throws InterruptedException {
        car.navigate().findNewCars(brandName);
        car.findNameandPrice();
        Thread.sleep(3000);
    }

}

