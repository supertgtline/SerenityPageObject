package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.CarWaleSteps;

@RunWith(SerenityRunner.class)
public class FindCarTest {
    @Managed
    WebDriver driver;
    @Steps
    CarWaleSteps car;
    @Title("Finding Car Test")
    @Test
    public void findCarTest(){
        car.navigate();
        car.findNewCars();
    }

}
