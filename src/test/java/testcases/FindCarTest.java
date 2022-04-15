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
public class FindCarTest {

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
    @Title("Finding Car Test")
    @Test
    public void findCarTest() throws InterruptedException {
        car.navigate();
        car.findNewCars(brandName);
        Thread.sleep(3000);
    }

}

