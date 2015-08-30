import CommonApi.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by mounssif on 8/27/2015.
 */
public class homePage extends BaseClass{
    @Test
    public void navigate() throws InterruptedException{
        driver.findElement(By.cssSelector(".header-nav-link")).click();
        Thread.sleep(4000);




    }
}
